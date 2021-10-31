package dev.edescart.destino.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.edescart.descarte.domain.Descarte;
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

}
