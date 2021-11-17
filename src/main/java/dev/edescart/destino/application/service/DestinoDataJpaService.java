package dev.edescart.destino.application.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.edescart.descarte.application.repository.DescarteRepository;
import dev.edescart.descarte.domain.Descarte;
import dev.edescart.destino.application.repository.DestinoRepository;
import dev.edescart.destino.domain.Destino;
import dev.edescart.handler.ApiException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class DestinoDataJpaService implements DestinoService {
	private DescarteRepository descarteRepository;
	private DestinoRepository destinoRepository;

	@Override
	public void criaDestinoService(Long idDescarte, Destino buildDestino) {
		log.info("[Iniciando] - Método criaDestinoService em DestinoDataJpaService");
		Descarte descartePorId = this.buscaPorId(idDescarte);
		buildDestino.setDescarte(descartePorId);
		destinoRepository.criaDestinoInfra(buildDestino);
		log.info("[Finalizando] - Método criaDestinoService em DestinoDataJpaService");
	}

	private Descarte buscaPorId(Long idDescarte) {
		log.info("[Iniciando] - Método buscaPorId em DestinoDataJpaService");
		Descarte descartePorId = descarteRepository.buscaDescartePorIdInfra(idDescarte)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.BAD_REQUEST, "Descarte não encontrado!"));
		log.info("[Finalizando] - Método buscaPorId em DestinoDataJpaService");
		return descartePorId;
	}

	@Override
	public Destino buscaDestinoPorIdService(Long idDestino) {
		log.info("[Iniciando] - Método buscaDestinoPorIdService em DestinoDataJpaService");
		Destino destino = destinoRepository.buscaDestinoPorIdInfra(idDestino)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Destino não encontrado!"));
		log.info("[Finalizando] - Método buscaDestinoPorIdService em DestinoDataJpaService");
		return destino;
	}

	@Override
	public List<Destino> listaDestinosService() {
		log.info("[Iniciando - Finalizando] - Método listaDestinosService em DestinoDataJpaService");
		return destinoRepository.listaDestinosInfra();
	}

	@Override
	public List<Destino> buscaDestinoPorNomeService(String destino) {
		log.info("[Iniciando] - Método buscaDestinoPorNomeService em DestinoDataJpaService");
		List<Destino> destinos = this.destinoRepository.buscaDestinoPorNomeInfra(destino);
		log.info("[Finalizando] - Método buscaDestinoPorNomeService em DestinoDataJpaService");
		return destinos;
	}

	@Override
	public List<Destino> buscaDataSaidaService(String data) {
		log.info("[Iniciando] - Método buscaDataSaidaService em DestinoDataJpaService");
		List<Destino> destinos = this.destinoRepository.buscaDataSaidaInfra(data);
		log.info("[Finalizando] - Método buscaDataSaidaService em DestinoDataJpaService");
		return destinos;
	}

	@Override
	public boolean verificaIdDestinoService(Long idDestino) {
		log.info("[Iniciando] - Método verificaIdDestinoService em DestinoDataJpaService");
		boolean statusDestino = destinoRepository.verificaIdDestinoInfra(idDestino);
		log.info("[Finalizando] - Método verificaIdDestinoService em DestinoDataJpaService");
		return statusDestino;
	}

	@Override
	public void deletaDestinoService(Long idDestino) {
		log.info("[Iniciando - Finalizando] - Método deletaDestinoService em DestinoDataJpaService");
		destinoRepository.deletaDestinoInfra(idDestino);
	}

	@Override
	public Destino atualizaDestinoService(Destino buildDestino) {
		log.info("[Iniciando] - Método verificaIdDestinoService em DestinoDataJpaService");
		Destino novoDestino = destinoRepository.atualizaDestinoInfra(buildDestino);
		log.info("[Finalizando] - Método verificaIdDestinoService em DestinoDataJpaService");
		return novoDestino;
	}

	@Override
	public Destino buscaDestinoPorFK(Long idDestino) {
		Destino destinoPorFK = destinoRepository.buscaDestinoPorFKInfra(idDestino)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.BAD_REQUEST, "Destino não encontrado!"));
		return destinoPorFK;	
	}
	
}
