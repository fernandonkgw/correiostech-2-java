package br.com.correios.api.techday.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.com.correios.api.techday")
@EnableFeignClients("br.com.correios.api.techday.client")
public class WebServerConfig {
}
