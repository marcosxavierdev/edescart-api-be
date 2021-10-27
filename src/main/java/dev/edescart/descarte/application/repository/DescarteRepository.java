package dev.edescart.descarte.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.edescart.descarte.domain.Descarte;

@Repository
public interface DescarteRepository {

	Optional<Descarte> buscaDescartePorIdInfra(Long idDescarte);

	Descarte cadastraDescarteInfra(Descarte descarte);

	boolean verificaIdInfra(Long idDescarte);

	void deletaDescarteInfra(Long idDescarte);

	Descarte atualizaDescarteInfra(Descarte descarte);

	List<Descarte> listaEquipamentosInfra();

	List<Descarte> buscaClientePorNomeInfra(String nome);

	List<Descarte> buscaTecnicoPorNomeInfra(String nome);

	List<Descarte> buscaDataEntradaInfra(String data);

}
