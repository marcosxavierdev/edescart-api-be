package dev.edescart.descarte.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.edescart.descarte.domain.Descarte;

@Service
public interface DescarteService {

	Descarte buscaDescartePorIdService(Long idDescarte);

	Descarte cadastraDescarteService(Descarte descarte);

	boolean verificaIdService(Long idDescarte);

	void deletaDescarteService(Long idDescarte);

	Descarte atualizaDescarteService(Descarte descarte);

	List<Descarte> listaDescartesService();

	List<Descarte> buscaClientePorNomeService(String nome);

	List<Descarte> buscaTecnicoPorNomeService(String nome);

	List<Descarte> buscaDataEntradaService(String data);

}
