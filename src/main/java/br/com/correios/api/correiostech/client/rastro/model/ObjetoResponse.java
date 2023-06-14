package br.com.correios.api.correiostech.client.rastro.model;

import br.com.correios.api.correiostech.domain.rastro.ObjetoPostal;

import java.util.List;

public record ObjetoResponse(
        String codObjeto,
        TipoPostalResponse tipoPostal,
        List<EventoResponse> eventos
) {

    public ObjetoPostal toDomain() {
        final var eventosList = eventos != null ? eventos.stream()
                .map(EventoResponse::toDomain)
                .toList() : null;
        return new ObjetoPostal(codObjeto, eventosList);
    }
}
