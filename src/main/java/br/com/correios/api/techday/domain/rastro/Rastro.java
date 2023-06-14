package br.com.correios.api.techday.domain.rastro;

import java.util.Collections;
import java.util.List;

public class Rastro {

    private final String versao;
    private final Integer quantidade;
    private final List<ObjetoPostal> objetosPostais;

    public Rastro(String versao, Integer quantidade, List<ObjetoPostal> objetosPostais) {
        this.versao = versao;
        this.quantidade = quantidade;
        this.objetosPostais = objetosPostais;
    }

    public String getVersao() {
        return versao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public List<ObjetoPostal> getObjetosPostais() {
        return Collections.unmodifiableList(objetosPostais);
    }

    @Override
    public String toString() {
        return "Rastro{" +
                "versao='" + versao + '\'' +
                ", quantidade=" + quantidade +
                ", objetosPostais=" + objetosPostais +
                '}';
    }
}
