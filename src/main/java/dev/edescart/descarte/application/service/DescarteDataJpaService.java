package dev.edescart.descarte.application.service;

import java.util.List;
import java.util.Optional;

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
	public Descarte buscaDescartePorIdService(Long idDescarte) {
		log.info("[Iniciando] - Método buscaDescartePorIdService em DescarteDataJpaService");
		Descarte descarte = descarteRepository.buscaDescartePorIdInfra(idDescarte)
				.orElseThrow(() -> ApiException.throwApiException(HttpStatus.NOT_FOUND, "Equipamento não encontrado!"));
		log.info("[Finalizando] - Método buscaDescartePorIdService em DescarteDataJpaService");
		return descarte;
	}

	@Override
	public Descarte cadastraDescarteService(Descarte descarte) {
		log.info("[Iniciando] - Método cadastraDescarteService em DescarteDataJpaService");
		Descarte novoEquipamento = descarteRepository.cadastraDescarteInfra(descarte);
		log.info("[Finalizando] - Método cadastraDescarteService em DescarteDataJpaService");
		return novoEquipamento;
	}

	@Override
	public boolean verificaIdService(Long idDescarte) {
		log.info("[Iniciando] - Método verificaIdService em DescarteDataJpaService");
		boolean statusEquipamento = descarteRepository.verificaIdInfra(idDescarte);
		log.info("[Finalizando] - Método verificaIdService em DescarteDataJpaService");
		return statusEquipamento;
	}

	@Override
	public void deletaDescarteService(Long idDescarte) {
		log.info("[Iniciando] - Método deletaDescarteService em DescarteDataJpaService");
		descarteRepository.deletaDescarteInfra(idDescarte);
		log.info("[Finalizando] - Método deletaDescarteService em DescarteDataJpaService");
	}

	@Override
	public Descarte atualizaDescarteService(Descarte descarte) {
		log.info("[Iniciando] - Método tualizaDescarteService em DescarteDataJpaService");
		Descarte novoEquipamento = descarteRepository.atualizaDescarteInfra(descarte);
		log.info("[Finalizando] - Método atualizaDescarteService em DescarteDataJpaService");
		return novoEquipamento;
	}

	@Override
	public List<Descarte> listaDescartesService() {
		log.info("[Iniciando - Finalizando] - Método listaDescartesService em DescarteDataJpaService");
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

	@Override
	public List<Descarte> buscaDataEntradaService(String data) {
		log.info("[Iniciando] - Método buscaDataEntradaService em DescarteDataJpaService");
		List<Descarte> descartes = this.descarteRepository.buscaDataEntradaInfra(data);
		log.info("[Finalizando] - Método buscaDataEntradaService em DescarteDataJpaService");
		return descartes;
	}

}
