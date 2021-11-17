package dev.edescart.destino.application.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.destino.application.api.dto.BuscaDestinoDTO;
import dev.edescart.destino.application.api.form.AtualizaDestinoFORM;
import dev.edescart.destino.application.api.form.CriaDestinoFORM;
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

	@Override
	public List<BuscaDestinoDTO> listaDestinos() {
		log.info("[Iniciando] - Método listaDestinos em DestinoRestController");
		List<Destino> destino = destinoService.listaDestinosService();
		log.info("[Finalizando] - Método listaDestinos em DestinoRestController");
		return BuscaDestinoDTO.toList(destino);
	}

	@Override
	public List<BuscaDestinoDTO> buscaDestinoPorNome(String destino) {
		log.info("[Iniciando] - Método buscaDestinoPorNomes em DestinoRestController");
		List<Destino> destinos = destinoService.buscaDestinoPorNomeService(destino);
		log.info("[Finalizando] - Método buscaDestinoPorNome em DestinoRestController");
		return BuscaDestinoDTO.toList(destinos);
	}

	@Override
	public List<BuscaDestinoDTO> buscaDataSaida(String data) {
		log.info("[Iniciando] - Método buscaDataSaida em DestinoRestController");
		List<Destino> destinos = destinoService.buscaDataSaidaService(data);
		log.info("[Finalizando] - Método buscaDataSaida em DestinoRestController");
		return BuscaDestinoDTO.toList(destinos);
	}

	@Override
	public ResponseEntity<Void> deletaDestino(Long idDestino) {
		log.info("[Iniciando] - Método deletaDestino em DestinoRestController");
		if (!destinoService.verificaIdDestinoService(idDestino)) {
			log.info("[Finalizando] - Método deletaDestino em DestinoRestController [NOT FOUND]");
			return ResponseEntity.notFound().build();
		}
		destinoService.deletaDestinoService(idDestino);
		log.info("[Finalizando] - Método deletaDestino em DestinoRestController [OK]");
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<?> atualizaDestino(Long idDestino, AtualizaDestinoFORM atualizaDestinoFORM) {
		log.info("[Iniciando] - Método atualizaDestino em DestinoRestController");
		if (!destinoService.verificaIdDestinoService(idDestino)) {
			log.info("[Finalizando] - Método atualizaDestino em DestinoRestController [NOT FOUND]");
			return ResponseEntity.notFound().build();
		}
		atualizaDestinoFORM.setId(idDestino);
		Destino destino = destinoService.atualizaDestinoService(atualizaDestinoFORM.buildDestino());
		log.info("[Finalizando] - Método atualizaDestino em DestinoRestController [OK]");
		return ResponseEntity.ok(destino);
	}

}
