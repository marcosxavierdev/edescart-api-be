package dev.edescart.destino.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.edescart.destino.application.repository.DestinoRepository;
import dev.edescart.destino.domain.Destino;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class DestinoJpaRepository implements DestinoRepository {
	private DestinoSpringDataJpaRepository destinoSpringDataJpaRepository;

	@Override
	public Destino criaDestinoInfra(Destino buildDestino) {
		log.info("[Iniciando] - Método criaDestinoInfra em DestinoJpaRepository");
		Destino destino = destinoSpringDataJpaRepository.save(buildDestino);
		log.info("[Finalizando] - Método criaDestinoInfra em DestinoJpaRepository");
		return  destino;
	}

	@Override
	public Optional<Destino> buscaDestinoPorIdInfra(Long idDestino) {
		log.info("[Iniciando] - Método buscaDestinoPorIdInfra em DestinoJpaRepository");
		Optional<Destino> destino = destinoSpringDataJpaRepository.findById(idDestino);
		log.info("[Finalizando] - Método buscaDestinoPorIdInfra em DestinoJpaRepository");
		return destino;
	}

	@Override
	public List<Destino> listaDestinosInfra() {
		log.info("[Iniciando - Finalizando] - Método listaDestinosInfra em DestinoJpaRepository");
		return destinoSpringDataJpaRepository.findAll();
	}

	@Override
	public List<Destino> buscaDestinoPorNomeInfra(String destino) {
		log.info("[Iniciando] - Método buscaDestinoPorNomeInfra em DestinoJpaRepository");
		List<Destino> destinos = destinoSpringDataJpaRepository.findByDestinoContainingIgnoreCase(destino);
		log.info("[Finalizando] - Método buscaDestinoPorNomeInfra em DestinoJpaRepository");
		return destinos;
	}

	@Override
	public List<Destino> buscaDataSaidaInfra(String data) {
		log.info("[Iniciando] - Método buscaDataSaidaInfra em DestinoJpaRepository");
		List<Destino> destinos = destinoSpringDataJpaRepository.findByDataSaida(data);
		log.info("[Finalizando] - Método buscaDataSaidaInfra em DestinoJpaRepository");
		return destinos;
	}

	@Override
	public boolean verificaIdDestinoInfra(Long idDestino) {
		log.info("[Iniciando] - Método verificaIdDestinoInfra em DestinoJpaRepository");
		boolean statusDestino = destinoSpringDataJpaRepository.existsById(idDestino);
		log.info("[Finalizando] - Método verificaIdDestinoInfra em DestinoJpaRepository");
		return statusDestino;
	}

	@Override
	public void deletaDestinoInfra(Long idDestino) {
		log.info("[Iniciando] - Método deletaDestinoInfra em DestinoJpaRepository");
		destinoSpringDataJpaRepository.deleteById(idDestino);
		log.info("[Finalizando] - Método deletaDestinoInfra em DestinoJpaRepository");
	}

	@Override
	public Destino atualizaDestinoInfra(Destino buildDestino) {
		log.info("[Iniciando] - Método atualizaDestinoInfra em DestinoJpaRepository");
		Destino novoDestino = destinoSpringDataJpaRepository.save(buildDestino);
		log.info("[Finalizando] - Método atualizaDestinoInfra em DestinoJpaRepository");
		return novoDestino;
	}

}
