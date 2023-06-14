package br.com.correios.api.correiostech.client.token;

import java.time.LocalDateTime;
import java.util.List;

public class Token {
    private String id;
    private String perfil;
    private String emissao;
    private String expiraEm;
    private String token;
    private List<Integer> api;
    private Contrato contrato;

    public Token() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String var1) {
        this.id = var1;
    }

    public String getPerfil() {
        return this.perfil;
    }

    public void setPerfil(String var1) {
        this.perfil = var1;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String var1) {
        this.token = var1;
    }

    public String getEmissao() {
        return this.emissao;
    }

    public void setEmissao(String var1) {
        this.emissao = var1;
    }

    public String getExpiraEm() {
        return this.expiraEm;
    }

    public void setExpiraEm(String var1) {
        this.expiraEm = var1;
    }

    public List<Integer> getApi() {
        return this.api;
    }

    public void setApi(List<Integer> var1) {
        this.api = var1;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public List<Integer> getApisContrato() {
        if (contrato == null) {
            return null;
        }
        return getContrato().getApi();
    }

    public boolean estaExpirado() {
        LocalDateTime var1 = LocalDateTime.now().plusMinutes(5L);
        LocalDateTime var2 = LocalDateTime.parse(this.expiraEm);
        boolean var3 = var1.isAfter(var2);
        return var3;
    }

    public String toString() {
        return "TokenClient [id=" + this.id + ", perfil=" + this.perfil + ", emissao=" + this.emissao + ", expiracaoEm=" + this.expiraEm + ", token=" + this.token + "]";
    }
}
