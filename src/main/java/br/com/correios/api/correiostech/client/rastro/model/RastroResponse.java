package br.com.correios.api.correiostech.client.rastro.model;

import br.com.correios.api.correiostech.domain.rastro.ObjetoPostal;
import br.com.correios.api.correiostech.domain.rastro.Rastro;

import java.util.List;

public record RastroResponse(
        String versao,
        Integer quantidade,
        List<ObjetoResponse> objetos
) {

    public Rastro toDomain() {
        List<ObjetoPostal> objetosPostais = objetos.stream().map(ObjetoResponse::toDomain).toList();
        return new Rastro(versao, quantidade, objetosPostais);
    }
}
