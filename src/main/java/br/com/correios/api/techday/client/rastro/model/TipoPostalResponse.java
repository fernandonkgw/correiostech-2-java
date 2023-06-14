package br.com.correios.api.techday.client.rastro.model;

public record TipoPostalResponse(
        String sigla,
        String descricao,
        String categoria
) {
}
