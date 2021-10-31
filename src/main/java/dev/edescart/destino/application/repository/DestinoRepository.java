package dev.edescart.destino.application.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.destino.domain.Destino;

@Repository
public interface DestinoRepository {

	Destino criaDestinoInfra(Destino buildDestino);

	Optional<Destino> buscaDestinoPorIdInfra(Long idDestino);

}
