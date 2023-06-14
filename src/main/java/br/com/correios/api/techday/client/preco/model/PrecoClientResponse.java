package br.com.correios.api.techday.client.preco.model;

import br.com.correios.api.techday.domain.preco.Preco;

public record PrecoClientResponse(
        String coProduto,
        String pcFinal
) {

    public Preco toDomain() {
        return new Preco(coProduto, pcFinal);
    }
}
