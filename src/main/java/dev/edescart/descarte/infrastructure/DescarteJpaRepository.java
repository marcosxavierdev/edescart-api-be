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
	public Optional<Descarte> buscaDescartePorIdInfra(Long idDescarte) {
		log.info("[Iniciando] - Método buscaDescartePorIdInfra em DescarteJpaRepository");
		Optional<Descarte> descarte = descarteSpringDataJpaRepository.findById(idDescarte);
		log.info("[Finalizando] - Método buscaDescartePorIdInfra em DescarteJpaRepository");
		return descarte;
	}

	@Override
	public Descarte cadastraDescarteInfra(Descarte descarte) {
		log.info("[Iniciando] - Método cadastraDescarteInfra em DescarteJpaRepository");
		Descarte novoEquipamento = descarteSpringDataJpaRepository.save(descarte);
		log.info("[Finalizando] - Método cadastraDescarteInfra em DescarteJpaRepository");
		return novoEquipamento;
	}

	@Override
	public boolean verificaIdInfra(Long idDescarte) {
		log.info("[Iniciando] - Método verificaIdInfra em DescarteJpaRepository");
		boolean statusEquipamento = descarteSpringDataJpaRepository.existsById(idDescarte);
		log.info("[Finalizando] - Método verificaIdInfra em DescarteJpaRepository");
		return statusEquipamento;
	}

	@Override
	public void deletaDescarteInfra(Long idDescarte) {
		log.info("[Iniciando] - Método deletaDescarteInfra em DescarteJpaRepository");
		descarteSpringDataJpaRepository.deleteById(idDescarte);
		log.info("[Finalizando] - Método deletaDescarteInfra em DescarteJpaRepository");
	}

	@Override
	public Descarte atualizaDescarteInfra(Descarte descarte) {
		log.info("[Iniciando] - Método atualizaDescarteInfra em DescarteJpaRepository");
		Descarte novoEquipamento = descarteSpringDataJpaRepository.save(descarte);
		log.info("[Finalizando] - Método atualizaDescarteInfra em DescarteJpaRepository");
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
		log.info("[Iniciando] - Método buscaDataEntradaInfra em DescarteJpaRepository");
		List<Descarte> descartes = descarteSpringDataJpaRepository.findByDataEntrada(data);
		log.info("[Finalizando] - Método buscaDataEntradaInfra em DescarteJpaRepository");
		return descartes;
	}

	@Override
	public Descarte buscaPorId(Long idDescarte) {
		Descarte descarte = descarteSpringDataJpaRepository.getOne(idDescarte);
		return descarte;
	}

}
