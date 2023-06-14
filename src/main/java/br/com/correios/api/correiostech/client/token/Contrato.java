package br.com.correios.api.correiostech.client.token;

import java.util.List;

public class Contrato {

    private String numero;
    private String dr;
    private List<Integer> api;

    public Contrato() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public List<Integer> getApi() {
        return api;
    }

    public void setApi(List<Integer> api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "numero='" + numero + '\'' +
                ", dr='" + dr + '\'' +
                ", api=" + api +
                '}';
    }
}
