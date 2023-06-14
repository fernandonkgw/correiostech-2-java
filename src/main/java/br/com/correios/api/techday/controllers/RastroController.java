package br.com.correios.api.techday.controllers;

import br.com.correios.api.techday.usecase.rastro.BuscaTodosEventosUmObjetoUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rastros")
@RestController
public class RastroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RastroController.class);

    private final BuscaTodosEventosUmObjetoUseCase buscaTodosEventosUmObjetoUseCase;

    public RastroController(BuscaTodosEventosUmObjetoUseCase buscaTodosEventosUmObjetoUseCase) {
        this.buscaTodosEventosUmObjetoUseCase = buscaTodosEventosUmObjetoUseCase;
    }

    @GetMapping
    public void rastreiaUmObjeto() {
        LOGGER.trace("Endpoint consulta rastro de um objeto");
        this.buscaTodosEventosUmObjetoUseCase.executa();
    }
}
