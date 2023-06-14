package br.com.correios.api.techday.client.rastro.model;

import br.com.correios.api.techday.domain.rastro.ObjetoPostal;

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
