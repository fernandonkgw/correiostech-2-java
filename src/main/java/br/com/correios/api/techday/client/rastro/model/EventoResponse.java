package br.com.correios.api.techday.client.rastro.model;

import br.com.correios.api.techday.domain.rastro.Evento;

import java.time.LocalDateTime;

public record EventoResponse(
        String codigo,
        String tipo,
        String dtHrCriado,
        String descricao,
        String detalhe
) {

    public Evento toDomain() {
        final var criadoEm = LocalDateTime.parse(dtHrCriado);
        return new Evento(codigo, tipo, criadoEm, descricao);
    }
}
