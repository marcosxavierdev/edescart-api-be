package dev.edescart.destino.application.api;

import org.springframework.web.bind.annotation.RestController;

import dev.edescart.destino.application.service.DestinoService;
import dev.edescart.destino.domain.Destino;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class DestinoRestController implements DestinoAPI {
	private DestinoService destinoService;

	@Override
	public void criaDestino(Long idDescarte, CriaDestinoFORM criaDestinoFORM) {
		log.info("[Iniciando] - Método criaDestino em DestinoRestController");
		log.info("[Buscando] - Id em DescarteRestController: {}", idDescarte);
		destinoService.criaDestinoService(idDescarte, criaDestinoFORM.buildDestino());
		log.info("[Finalizando] - Método criaDestino em DestinoRestController");
	}

	@Override
	public BuscaDestinoDTO buscaDestinoPorId(Long idDestino) {
		log.info("[Iniciando] - Método buscaDestinoPorId em DestinoRestController");
		log.info("[Buscando] - Id em DestinoRestController: {}", idDestino);
		Destino destino = destinoService.buscaDestinoPorIdService(idDestino);
		log.info("[Finalizando] - Método buscaDestinoPorId em DestinoRestController");
		return new BuscaDestinoDTO(destino);
	}

}
