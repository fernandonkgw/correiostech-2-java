package br.com.correios.api.correiostech.domain.preco;

import java.util.Objects;

public class Preco {

    private final String codigoProduto;
    private final String precoFinal;

    public Preco(String codigoProduto, String precoFinal) {
        this.codigoProduto = codigoProduto;
        this.precoFinal = precoFinal;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public String getPrecoFinal() {
        return precoFinal;
    }

    @Override
    public String toString() {
        return "Preco{" +
                "codigoProduto='" + codigoProduto + '\'' +
                ", precoFinal='" + precoFinal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Preco preco = (Preco) o;
        return Objects.equals(getCodigoProduto(), preco.getCodigoProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoProduto());
    }
}
