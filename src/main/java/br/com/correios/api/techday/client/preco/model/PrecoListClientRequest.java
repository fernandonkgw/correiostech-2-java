package br.com.correios.api.techday.client.preco.model;

import java.util.List;

public record PrecoListClientRequest(
        String idLote,
        List<Object> parametrosProduto
) {
}
