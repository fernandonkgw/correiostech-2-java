package br.com.correios.api.techday.client.token.model;

public enum AmbientePublicacao {
    PRODUCAO("1", "PRODUCAO"),
    HOMOLOGACAO("2", "HOMOLOGACAO"),
    DESENVOLVIMENTO("3", "DESENVOLVIMENTO"),
    LOCAL("4", "LOCAL");

    private String codigo;
    private String ambiente;

    private AmbientePublicacao(String var3, String var4) {
        this.codigo = var3;
        this.ambiente = var4;
    }

    public String getAmbiente() {
        return this.ambiente;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static AmbientePublicacao fromCodigo(String var0) {
        AmbientePublicacao[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AmbientePublicacao var4 = var1[var3];
            if (var4.getCodigo().equals(var0)) {
                return var4;
            }
        }

        throw new IllegalArgumentException("AmbientePublicacao com código [" + var0 + "] não encontrado.");
    }
}
