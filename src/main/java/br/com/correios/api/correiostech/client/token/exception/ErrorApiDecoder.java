package br.com.correios.api.correiostech.client.token.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ErrorApiDecoder implements ErrorDecoder {
    public ErrorApiDecoder() {
    }

    public Exception decode(String var1, Response var2) {
        if (var2.status() != 401 && var2.status() != 403) {
            Response.Body var8 = var2.body();
            String var4 = null;
            if (var8 != null) {
                try {
                    ObjectMapper var5 = new ObjectMapper();
                    MessageApi var6 = (MessageApi)var5.readValue(var8.asInputStream(), MessageApi.class);
                    var4 = (String)var6.getMsgs().get(0);
                } catch (Exception var7) {
                    if (var2.status() == 503) {
                        return new ApiClientErrorException(var2.status(), "Serviço indisponível");
                    }

                    var7.printStackTrace();
                }
            }

            var4 = var4 == null ? var2.reason() : var4;
            if (var2.status() >= 400 && var2.status() <= 499) {
                return new ApiClientErrorException(var2.status(), var4);
            } else if (var2.status() >= 500 && var2.status() <= 599) {
                return new ApiClientErrorException(var2.status(), var4);
            } else {
                FeignException var9 = FeignException.errorStatus(var1, var2);
                return var9;
            }
        } else {
            FeignException var3 = FeignException.errorStatus(var1, var2);
            return var3;
        }
    }
}
