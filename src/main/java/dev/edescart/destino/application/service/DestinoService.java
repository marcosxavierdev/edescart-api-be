package dev.edescart.destino.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.edescart.destino.domain.Destino;

@Service
public interface DestinoService {

	void criaDestinoService(Long idDescarte, Destino buildDestino);

	Destino buscaDestinoPorIdService(Long idDestino);

	List<Destino> listaDestinosService();

	List<Destino> buscaDestinoPorNomeService(String destino);

	List<Destino> buscaDataSaidaService(String data);

	boolean verificaIdDestinoService(Long idDestino);

	void deletaDestinoService(Long idDestino);

	Destino atualizaDestinoService(Destino buildDestino);

}
