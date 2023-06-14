package br.com.correios.api.correiostech.usecase.rastro;

import br.com.correios.api.correiostech.client.rastro.RastroClient;
import br.com.correios.api.correiostech.domain.rastro.EventoFiltro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuscaTodosEventosUmObjetoUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuscaTodosEventosUmObjetoUseCase.class);

    private final RastroClient rastroClient;

    public BuscaTodosEventosUmObjetoUseCase(RastroClient rastroClient) {
        this.rastroClient = rastroClient;
    }

    public void executa() {
        LOGGER.debug("UseCase consulta de rastro de um produto/servico");

        final var etiquetaObjeto = "AA123456789BR";
        final var filtroEventos = EventoFiltro.TODOS;

        final var rastroResponse = rastroClient.getRastro(etiquetaObjeto, filtroEventos.getCodigo());
        LOGGER.debug("rastroResponse {}", rastroResponse);

        final var rastro = rastroResponse.toDomain();
        LOGGER.debug("rastro {}", rastro);
    }
}
