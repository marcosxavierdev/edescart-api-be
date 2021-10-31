package dev.edescart.destino.application.service;

import org.springframework.stereotype.Service;

import dev.edescart.destino.domain.Destino;

@Service
public interface DestinoService {

	void criaDestinoService(Long idDescarte, Destino buildDestino);

}
