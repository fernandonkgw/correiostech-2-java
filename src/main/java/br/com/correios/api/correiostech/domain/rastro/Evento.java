package br.com.correios.api.correiostech.domain.rastro;

import java.time.LocalDateTime;
import java.util.Objects;

public class Evento {
    private final String codigo;
    private final String tipo;
    private final LocalDateTime criadoEm;
    private final String descricao;

    public Evento(String codigo, String tipo, LocalDateTime criadoEm, String descricao) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.criadoEm = criadoEm;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Evento evento = (Evento) o;
        return Objects.equals(getCodigo(), evento.getCodigo()) && Objects.equals(getTipo(), evento.getTipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getTipo());
    }

    @Override
    public String toString() {
        return "Evento{" +
                "codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", criadoEm=" + criadoEm +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
