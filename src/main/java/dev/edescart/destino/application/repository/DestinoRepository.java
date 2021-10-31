package dev.edescart.destino.application.repository;

import org.springframework.stereotype.Repository;

import dev.edescart.destino.domain.Destino;

@Repository
public interface DestinoRepository {

	Destino criaDestinoInfra(Destino buildDestino);

}
