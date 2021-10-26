package dev.edescart.descarte.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.edescart.descarte.domain.Descarte;

@Service
public interface DescarteService {

	Descarte buscaEquipamentoPorIdService(Long idEquipamento);

	Descarte cadastraEquipamentoService(Descarte descarte);

	boolean verificaIdService(Long idEquipamento);

	void deletaEquipamentoService(Long idEquipamento);

	Descarte atualizaEquipamentoService(Descarte descarte);

	List<Descarte> listaEquipamentosService();

	List<Descarte> buscaClientePorNomeService(String nome);

}
