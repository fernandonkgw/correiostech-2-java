package br.com.correios.api.techday.client.commons;

import br.com.correios.api.techday.configuration.properties.CredencialProperties;
import br.com.correios.api.techday.client.commons.interceptor.BearerAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class ApiCorreiosRequestConfiguration {

    public Long CONNECT_TIMEOUT = 3000L;
    public Long READ_TIMEOUT = 3000L;

    public ApiCorreiosRequestConfiguration() {
    }

    @Bean
    public Request.Options getOptions() {
        return new Request.Options(this.connectTimeout(), TimeUnit.MILLISECONDS, this.readTimeout(), TimeUnit.MILLISECONDS, false);
    }

    @Bean
    public Retryer.Default getRetryer() {
        return new Retryer.Default();
    }

    public long connectTimeout() {
        return this.CONNECT_TIMEOUT;
    }

    public long readTimeout() {
        return this.READ_TIMEOUT;
    }

    @Bean
    public BearerAuthRequestInterceptor requestInterceptorBearerAuth(CredencialProperties credencialProperties) {
        final var urlToken = credencialProperties.getUrlToken();
        final var user = credencialProperties.getUsuario();
        final var password = credencialProperties.getSenha();
        final var contrato = credencialProperties.getContrato();
        return new BearerAuthRequestInterceptor(urlToken, user, password, contrato);
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return new ErrorApiGatewayDecoder();
//    }
//
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
