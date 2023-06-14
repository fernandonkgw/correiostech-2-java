package br.com.correios.api.correiostech.client.preco.model;

import br.com.correios.api.correiostech.domain.preco.Preco;

public record PrecoClientResponse(
        String coProduto,
        String pcFinal
) {

    public Preco toDomain() {
        return new Preco(coProduto, pcFinal);
    }
}
