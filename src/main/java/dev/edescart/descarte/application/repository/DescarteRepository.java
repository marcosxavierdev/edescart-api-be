package dev.edescart.descarte.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.edescart.descarte.domain.Descarte;

@Repository
public interface DescarteRepository {

	Optional<Descarte> buscaEquipamentoPorIdInfra(Long idEquipamento);

	Descarte cadastraEquipamentoInfra(Descarte descarte);

	boolean verificaIdInfra(Long IdEquipamento);

	void deletaEquipamentoInfra(Long idEquipamento);

	Descarte atualizaEquipamentoInfra(Descarte descarte);

	List<Descarte> listaEquipamentosInfra();

	List<Descarte> buscaClientePorNomeInfra(String nome);

}
