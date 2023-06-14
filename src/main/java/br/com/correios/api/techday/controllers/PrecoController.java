package br.com.correios.api.techday.controllers;

import br.com.correios.api.techday.usecase.preco.ConsultaUmPrecoUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("precos")
@RestController
public class PrecoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrecoController.class);

    private final ConsultaUmPrecoUseCase consultaUmPrecoUseCase;

    public PrecoController(ConsultaUmPrecoUseCase consultaUmPrecoUseCase) {
        this.consultaUmPrecoUseCase = consultaUmPrecoUseCase;
    }


    @GetMapping
    public void consultaPreco() {
        LOGGER.trace("Endpoint consulta de preco de um produto/servico");
        consultaUmPrecoUseCase.executa();
    }
}
