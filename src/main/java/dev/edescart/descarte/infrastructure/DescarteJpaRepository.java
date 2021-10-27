package dev.edescart.descarte.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.edescart.descarte.application.repository.DescarteRepository;
import dev.edescart.descarte.domain.Descarte;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class DescarteJpaRepository implements DescarteRepository {
	private DescarteSpringDataJpaRepository descarteSpringDataJpaRepository;

	@Override
	public Optional<Descarte> buscaEquipamentoPorIdInfra(Long idEquipamento) {
		log.info("[Iniciando] - Método buscaEquipamentoPorIdInfra em DescarteJpaRepository");
		Optional<Descarte> descarte = descarteSpringDataJpaRepository.findById(idEquipamento);
		log.info("[Finalizando] - Método buscaEquipamentoPorIdInfra em DescarteJpaRepository");
		return descarte;
	}

	@Override
	public Descarte cadastraEquipamentoInfra(Descarte descarte) {
		log.info("[Iniciando] - Método cadastraEquipamentoInfra em DescarteJpaRepository");
		Descarte novoEquipamento = descarteSpringDataJpaRepository.save(descarte);
		log.info("[Finalizando] - Método cadastraEquipamentoInfra em DescarteJpaRepository");
		return novoEquipamento;
	}

	@Override
	public boolean verificaIdInfra(Long idEquipamento) {
		log.info("[Iniciando] - Método verificaIdInfra em DescarteJpaRepository");
		boolean statusEquipamento = descarteSpringDataJpaRepository.existsById(idEquipamento);
		log.info("[Finalizando] - Método verificaIdInfra em DescarteJpaRepository");
		return statusEquipamento;
	}

	@Override
	public void deletaEquipamentoInfra(Long idEquipamento) {
		log.info("[Iniciando] - Método deletaEquipamentoInfra em DescarteJpaRepository");
		descarteSpringDataJpaRepository.deleteById(idEquipamento);
		log.info("[Finalizando] - Método deletaEquipamentoInfra em DescarteJpaRepository");
	}

	@Override
	public Descarte atualizaEquipamentoInfra(Descarte descarte) {
		log.info("[Iniciando] - Método atualizaEquipamentoInfra em DescarteJpaRepository");
		Descarte novoEquipamento = descarteSpringDataJpaRepository.save(descarte);
		log.info("[Finalizando] - Método atualizaEquipamentoInfra em DescarteJpaRepository");
		return novoEquipamento;
	}

	@Override
	public List<Descarte> listaEquipamentosInfra() {
		log.info("[Iniciando - Finalizando] - Método listaEquipamentosInfra em DescarteJpaRepository");
		return descarteSpringDataJpaRepository.findAll();
	}

	@Override
	public List<Descarte> buscaClientePorNomeInfra(String nome) {
		log.info("[Iniciando] - Método buscaClientePorNomeInfra em DescarteJpaRepository");
		List<Descarte> descartes = descarteSpringDataJpaRepository.findByClienteContainingIgnoreCase(nome);
		log.info("[Finalizando] - Método buscaClientePorNomeInfra em DescarteJpaRepository");
		return descartes;
	}

	@Override
	public List<Descarte> buscaTecnicoPorNomeInfra(String nome) {
		log.info("[Iniciando] - Método buscaTecnicoPorNomeInfra em DescarteJpaRepository");
		List<Descarte> descartes = descarteSpringDataJpaRepository.findByTecnicoResponsavelContainingIgnoreCase(nome);
		log.info("[Finalizando] - Método buscaTecnicoPorNomeInfra em DescarteJpaRepository");
		return descartes;
	}

	@Override
	public List<Descarte> buscaDataEntradaInfra(String data) {
		List<Descarte> descartes = descarteSpringDataJpaRepository.findByDataEntrada(data);
		return descartes;
	}

}
