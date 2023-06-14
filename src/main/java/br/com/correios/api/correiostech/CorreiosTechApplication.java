package br.com.correios.api.correiostech;

import br.com.correios.api.correiostech.configuration.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class CorreiosTechApplication {

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "hom");
        SpringApplication.run(WebServerConfig.class, args);
    }

}
