package br.com.correios.api.correiostech.client.rastro.model;

public record TipoPostalResponse(
        String sigla,
        String descricao,
        String categoria
) {
}
