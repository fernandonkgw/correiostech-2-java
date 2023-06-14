package br.com.correios.api.correiostech.client.preco.model;

public record PrecoParamClientRequest(
        String coProduto,
        String psObjeto,
        String cepOrigem,
        String cepDestino
) {
}
