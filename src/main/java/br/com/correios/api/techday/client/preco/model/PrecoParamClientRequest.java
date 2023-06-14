package br.com.correios.api.techday.client.preco.model;

public record PrecoParamClientRequest(
        String coProduto,
        String psObjeto,
        String cepOrigem,
        String cepDestino
) {
}
