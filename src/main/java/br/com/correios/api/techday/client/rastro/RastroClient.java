package br.com.correios.api.techday.client.rastro;

import br.com.correios.api.techday.client.commons.ApiCorreiosRequestConfiguration;
import br.com.correios.api.techday.client.rastro.model.RastroResponse;
import br.com.correios.api.techday.domain.rastro.EventoFiltro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rastroClient", url = "${correios.client.rastro-url}",
        configuration = ApiCorreiosRequestConfiguration.class)
public interface RastroClient {

    @GetMapping(value = "v1/objetos/{etiquetaObjeto}", produces = MediaType.APPLICATION_JSON_VALUE)
    RastroResponse getRastro(
            @PathVariable("etiquetaObjeto") String etiquetaObjeto,
            @RequestParam("resultado") String filtro
    );
}
