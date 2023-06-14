package br.com.correios.api.correiostech.client.rastro.model;

import br.com.correios.api.correiostech.domain.rastro.Evento;

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
