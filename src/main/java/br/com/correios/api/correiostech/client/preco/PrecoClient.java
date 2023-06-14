package br.com.correios.api.correiostech.client.preco;

import br.com.correios.api.correiostech.client.commons.ApiCorreiosRequestConfiguration;

import br.com.correios.api.correiostech.client.preco.model.PrecoClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "precoClient", url = "${correios.client.preco-url}",
        configuration = ApiCorreiosRequestConfiguration.class)
public interface PrecoClient {

    @GetMapping(value = "v1/nacional/{codigoServico}", produces = MediaType.APPLICATION_JSON_VALUE)
    PrecoClientResponse getPreco(
            @PathVariable("codigoServico") String codigoServico,
            @RequestParam("psObjeto") Integer pesoObjeto,
            @RequestParam("cepOrigem") String cepOrigem,
            @RequestParam("cepDestino") String cepDestino
    );
}
