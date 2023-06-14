package br.com.correios.api.techday.client.token.exception;

import feign.FeignException;

public class TokenClientException extends FeignException {
    public TokenClientException(int var1, String var2) {
        super(var1, var2);
    }
}
