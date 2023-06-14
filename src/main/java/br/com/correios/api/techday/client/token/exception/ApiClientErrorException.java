package br.com.correios.api.techday.client.token.exception;

import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;

public class ApiClientErrorException extends FeignException {
    public ApiClientErrorException(int var1, String var2) {
        super(var1, var2);
    }
}
