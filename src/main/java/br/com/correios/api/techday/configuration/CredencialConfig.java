package br.com.correios.api.techday.configuration;

import br.com.correios.api.techday.configuration.properties.CredencialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredencialConfig {

    @Bean
    @ConfigurationProperties("correios.credencial")
    public CredencialProperties credencialProperties() {
        return new CredencialProperties();
    }
}
