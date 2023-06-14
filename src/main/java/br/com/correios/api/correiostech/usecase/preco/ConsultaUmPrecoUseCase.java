package br.com.correios.api.correiostech.usecase.preco;

import br.com.correios.api.correiostech.client.preco.PrecoClient;
import br.com.correios.api.correiostech.domain.preco.Preco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsultaUmPrecoUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaUmPrecoUseCase.class);

    private final PrecoClient precoClient;

    public ConsultaUmPrecoUseCase(PrecoClient precoClient) {
        this.precoClient = precoClient;
    }

    public Preco executa() {
        LOGGER.debug("UseCase consulta de preco de um produto/servico");

        final var codigoServico = "04162";
        final var pesoObjeto = 300;
        final var cepOrigem = "71930000";
        final var cepDestino = "05336010";

        final var precoResponse = precoClient.getPreco(codigoServico, pesoObjeto, cepOrigem, cepDestino);
        final var preco = precoResponse.toDomain();

        LOGGER.debug("Preco: {}", preco);
        return preco;
    }
}
