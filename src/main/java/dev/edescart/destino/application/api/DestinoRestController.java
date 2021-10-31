package dev.edescart.destino.application.api;

import org.springframework.web.bind.annotation.RestController;

import dev.edescart.descarte.application.service.DescarteService;
import dev.edescart.destino.application.service.DestinoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class DestinoRestController implements DestinoAPI {
	private DescarteService descarteService;
	private DestinoService destinoService;

	@Override
	public void criaDestino (Long idDescarte, CriaDestinoFORM criaDestinoFORM) {
		destinoService.criaDestinoService(idDescarte, criaDestinoFORM.buildDestino());
		
	}

}
