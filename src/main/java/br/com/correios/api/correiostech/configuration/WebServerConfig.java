package br.com.correios.api.correiostech.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.com.correios.api.correiostech")
@EnableFeignClients("br.com.correios.api.correiostech.client")
public class WebServerConfig {
}
