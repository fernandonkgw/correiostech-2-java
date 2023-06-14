package br.com.correios.api.techday.configuration.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class CredencialProperties implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CredencialProperties.class);

    private String usuario;
    private String senha;
    private String urlToken;
    private String contrato;

    @Override
    public String toString() {
        return "CredencialProperties{" +
                "usuario='" + usuario + '\'' +
                ", urlToken='" + urlToken + '\'' +
                ", contrato='" + contrato + '\'' +
                '}';
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrlToken() {
        return urlToken;
    }

    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.debug(toString());
    }
}
