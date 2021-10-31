package dev.edescart.destino.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.destino.domain.Destino;

@Repository
public interface DestinoRepository {

	Destino criaDestinoInfra(Destino buildDestino);

	Optional<Destino> buscaDestinoPorIdInfra(Long idDestino);

	List<Destino> listaDestinosInfra();

	List<Destino> buscaDestinoPorNomeInfra(String destino);

	List<Destino> buscaDataSaidaInfra(String data);

}
