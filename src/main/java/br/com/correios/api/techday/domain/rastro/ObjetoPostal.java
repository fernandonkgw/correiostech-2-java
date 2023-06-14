package br.com.correios.api.techday.domain.rastro;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ObjetoPostal {
    private final String codigo;
    private final List<Evento> eventos;

    public ObjetoPostal(String codigo, List<Evento> eventos) {
        this.codigo = codigo;
        this.eventos = eventos;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Evento> getEventos() {
        return Collections.unmodifiableList(eventos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetoPostal that = (ObjetoPostal) o;
        return Objects.equals(getCodigo(), that.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public String toString() {
        return "ObjetoPostal{" +
                "codigo='" + codigo + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
