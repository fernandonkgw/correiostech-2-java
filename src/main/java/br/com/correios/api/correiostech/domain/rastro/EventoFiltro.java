package br.com.correios.api.correiostech.domain.rastro;

public enum EventoFiltro {
    PRIMERO("P"),
    ULTIMO("U"),
    TODOS("T");

    private final String codigo;

    EventoFiltro(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
