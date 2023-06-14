package br.com.correios.api.correiostech.client.commons.interceptor;

import br.com.correios.api.correiostech.client.token.Token;
import br.com.correios.api.correiostech.client.token.TokenClientRequest;
import br.com.correios.api.correiostech.client.token.exception.ApiClientErrorException;
import br.com.correios.api.correiostech.client.token.exception.ErrorApiDecoder;
import br.com.correios.api.correiostech.client.token.exception.TokenClientException;
import feign.*;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.concurrent.TimeUnit;

public class BearerAuthRequestInterceptor implements RequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BearerAuthRequestInterceptor.class);
    private final String urlToken;
    private final String user;
    private final String password;
    private final String contrato;
    private Token objToken;

    public BearerAuthRequestInterceptor(String urlToken, String user, String password, String contrato) {
        this.urlToken = urlToken;
        this.user = user;
        this.password = password;
        this.contrato = contrato;
    }

    public void apply(RequestTemplate var1) {
        String var2 = this.obtemToken();
        String var3 = "Bearer " + var2;
        var1.header("Authorization", var3);
        byte[] var4 = var1.body();
        String var5 = "";
        if (var4 != null) {
            var5 = var4.toString();
        }

        LOGGER.trace("api-correios: url: {} {} {}", var1.method(), var1.url(), var5);
    }

    public String obtemToken() {
        String var1;
        if (this.objToken != null && this.objToken.getToken() != null && !this.objToken.estaExpirado()) {
            var1 = this.objToken.getToken();
            LOGGER.debug("api-correios: token recuperado.");
        } else {
            int var10002;
            String var10003;
            try {
                this.novoToken();
                var1 = this.objToken.getToken();
            } catch (ApiClientErrorException var3) {
                LOGGER.warn("api-correios: Não foi possivel obter o token: " + var3.getMessage());
                var10002 = var3.status();
                var10003 = var3.getMessage();
                throw new TokenClientException(var10002, var10003 + " status: " + var3.status() + ".");
            } catch (FeignException.Unauthorized var4) {
                throw new TokenClientException(var4.status(), "Não foi possível obter o token. Falha na autenticação. Verifique suas credenciais.");
            } catch (FeignException var5) {
                var10002 = var5.status();
                var10003 = var5.getMessage();
                throw new TokenClientException(var10002, var10003 + " status: " + var5.status() + ".");
            } catch (Exception var6) {
                throw new TokenClientException(503, var6.getMessage());
            }
        }

        return var1;
    }

    private void novoToken() {
        if (this.contrato != null && !this.contrato.isBlank()) {
            this.objToken = this.tokenClient().autenticaContrato(contrato);
        } else {
            this.objToken = this.tokenClient().token();
        }
        LOGGER.info("api-correios: token user: {}, expiraEm: {}, apis restritas autorizadas: {} ", this.objToken.getId(), this.objToken.getExpiraEm(), this.objToken.getApi());
        LOGGER.info("api-correios: token user: {}, expiraEm: {}, apis restritas autorizadas contrato: {} ", this.objToken.getId(), this.objToken.getExpiraEm(), this.objToken.getApisContrato());
    }

    private TokenClientRequest tokenClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .options(new Request.Options(2000L, TimeUnit.MILLISECONDS, 2000L, TimeUnit.MILLISECONDS, false))
                .retryer(new Retryer.Default())
                .requestInterceptor(new BasicAuthRequestInterceptor(this.user, this.password))
                .errorDecoder(new ErrorApiDecoder())
                .contract(new SpringMvcContract())
                .target(TokenClientRequest.class, urlToken);
    }
}
