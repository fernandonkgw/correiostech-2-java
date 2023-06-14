package br.com.correios.api.techday.client.token;

import org.springframework.web.bind.annotation.PostMapping;

public interface TokenClientRequest {

    @PostMapping(
            value = {"/v1/autentica"},
            consumes = {"application/json"}
    )
    Token token();

    @PostMapping(
            value = {"/v1/autentica/cartaopostagem"},
            consumes = {"application/json"}
    )
    Token autenticaCartaoPostagem(String var1);

    @PostMapping(
            value = {"/v1/autentica/contrato"},
            consumes = {"application/json"}
    )
    Token autenticaContrato(String var1);
}
