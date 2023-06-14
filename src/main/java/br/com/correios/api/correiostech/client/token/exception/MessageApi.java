package br.com.correios.api.correiostech.client.token.exception;

import java.util.ArrayList;
import java.util.List;

public class MessageApi {
    private List<String> msgs;
    private String date;
    protected String excecao;
    protected String causa;
    protected String path;
    private String user;
    protected String stackTrace;

    public MessageApi() {
    }

    public String getCausa() {
        return this.causa;
    }

    public void setCausa(String var1) {
        this.causa = var1;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String var1) {
        this.stackTrace = var1;
    }

    public String getExcecao() {
        return this.excecao;
    }

    public void setExcecao(String var1) {
        this.excecao = var1;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String var1) {
        this.user = var1;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String var1) {
        this.path = var1;
    }

    public void addMensagem(String var1) {
        if (this.msgs == null) {
            this.msgs = new ArrayList();
        }

        this.msgs.add(var1);
    }

    public List<String> getMsgs() {
        return this.msgs;
    }

    public void setMsgs(List<String> var1) {
        this.msgs = var1;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String var1) {
        this.date = var1;
    }

    public String toString() {
        return "MessageResponse [msgs=" + this.msgs + ", date=" + this.date + ", excecao=" + this.excecao + ", causa=" + this.causa + ", path=" + this.path + ", user=" + this.user + ", stackTrace=" + this.stackTrace + "]";
    }
}
