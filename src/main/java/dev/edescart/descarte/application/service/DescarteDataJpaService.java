package dev.edescart.descarte.application.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.edescart.descarte.application.repository.DescarteRepository;
import dev.edescart.descarte.domain.Descarte;
import dev.edescart.handler.ApiException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class DescarteDataJpaService implements DescarteService {
	private DescarteRepository descarteRepository;

	@Override
	public Descarte buscaEquipamentoPorIdService(Long idEquipamento) {
		log.info("[Iniciando] - Método buscaEquipamentoPorIdService em DescarteDataJpaService");
		Descarte descarte = descarteRepository.buscaEquipamentoPorIdInfra(idEquipamento)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Equipamento não encontrado!"));
		log.info("[Finalizando] - Método buscaEquipamentoPorIdService em DescarteDataJpaService");
		return descarte;
	}

	@Override
	public Descarte cadastraEquipamentoService(Descarte descarte) {
		log.info("[Iniciando] - Método cadastraEquipamentoService em DescarteDataJpaService");
		Descarte novoEquipamento = descarteRepository.cadastraEquipamentoInfra(descarte);
		log.info("[Finalizando] - Método cadastraEquipamentoService em DescarteDataJpaService");
		return novoEquipamento;
	}

	@Override
	public boolean verificaIdService(Long idEquipamento) {
		log.info("[Iniciando] - Método verificaIdService em DescarteDataJpaService");
		boolean statusEquipamento = descarteRepository.verificaIdInfra(idEquipamento);
		log.info("[Finalizando] - Método verificaIdService em DescarteDataJpaService");
		return statusEquipamento;
	}

	@Override
	public void deletaEquipamentoService(Long idEquipamento) {
		log.info("[Iniciando] - Método deletaEquipamentoService em DescarteDataJpaService");
		descarteRepository.deletaEquipamentoInfra(idEquipamento);
		log.info("[Finalizando] - Método deletaEquipamentoService em DescarteDataJpaService");
	}

	@Override
	public Descarte atualizaEquipamentoService(Descarte descarte) {
		log.info("[Iniciando] - Método atualizaEquipamentoService em DescarteDataJpaService");
		Descarte novoEquipamento = descarteRepository.atualizaEquipamentoInfra(descarte);
		log.info("[Finalizando] - Método atualizaEquipamentoService em DescarteDataJpaService");
		return novoEquipamento;
	}

	@Override
	public List<Descarte> listaEquipamentosService() {
		log.info("[Iniciando - Finalizando] - Método listaEquipamentosService em DescarteDataJpaService");
		return descarteRepository.listaEquipamentosInfra();
	}

	@Override
	public List<Descarte> buscaClientePorNomeService(String nome) {
		log.info("[Iniciando] - Método buscaClientePorNomeService em DescarteDataJpaService");
		List<Descarte> descartes = this.descarteRepository.buscaClientePorNomeInfra(nome);
		log.info("[Finalizando] - Método buscaClientePorNomeService em DescarteDataJpaService");
		return descartes;
	}

	@Override
	public List<Descarte> buscaTecnicoPorNomeService(String nome) {
		log.info("[Iniciando] - Método buscaTecnicoPorNomeService em DescarteDataJpaService");
		List<Descarte> descartes = this.descarteRepository.buscaTecnicoPorNomeInfra(nome);
		log.info("[Finalizando] - Método buscaTecnicoPorNomeService em DescarteDataJpaService");
		return descartes;
	}

}
