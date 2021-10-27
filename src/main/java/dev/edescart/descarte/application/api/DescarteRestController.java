package dev.edescart.descarte.application.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.edescart.descarte.application.api.dto.BuscaDescarteDTO;
import dev.edescart.descarte.application.api.dto.CadastraDescarteDTO;
import dev.edescart.descarte.application.api.dto.ListaDescartesDTO;
import dev.edescart.descarte.application.api.form.AtualizaDescarteFORM;
import dev.edescart.descarte.application.api.form.CadastraDescarteFORM;
import dev.edescart.descarte.application.service.DescarteService;
import dev.edescart.descarte.domain.Descarte;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class DescarteRestController implements DescarteAPI {
	private DescarteService descarteService;

	@Override
	public String test() {
		log.info("[Iniciando - Finalizando] - Método test em DescarteRestController");
		return "test ok!";
	}

	@Override
	public BuscaDescarteDTO buscaEquipamentoPorId(Long idEquipamento) {
		log.info("[Iniciando] - Método buscaEquipamentoPorId em DescarteRestController");
		log.info("[Buscando] - Id em DescarteRestController: {}", idEquipamento);
		Descarte descarte = descarteService.buscaEquipamentoPorIdService(idEquipamento);
		log.info("[Finalizando] - Método buscaEquipamentoPorId em DescarteRestController");
		return new BuscaDescarteDTO(descarte);
	}

	@Override
	public ResponseEntity<CadastraDescarteDTO> cadastraEquipamento(CadastraDescarteFORM cadastraDescarteFORM,
			UriComponentsBuilder uriBuilder) {
		log.info("[Iniciando] - Método cadastraEquipamento em DescarteRestController");
		Descarte descarte = descarteService.cadastraEquipamentoService(cadastraDescarteFORM.toEntity());
		URI uri = uriBuilder.path("/").buildAndExpand(descarte.getId()).toUri();
		log.info("[Finalizando] - Método cadastraEquipamento em DescarteRestController");
		return ResponseEntity.created(uri).body(new CadastraDescarteDTO(descarte));
	}

	@Override
	public ResponseEntity<Void> deletaEquipamento(Long idEquipamento) {
		log.info("[Iniciando] - Método deletaEquipamento em DescarteRestController");
		if (!descarteService.verificaIdService(idEquipamento)) {
			log.info("[Finalizando] - Método deletaEquipamento em DescarteRestController [NOT FOUND]");
			return ResponseEntity.notFound().build();
		}
		descarteService.deletaEquipamentoService(idEquipamento);
		log.info("[Finalizando] - Método deletaEquipamento em DescarteRestController [OK]");
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<?> atualizaEquipamento(Long idEquipamento, AtualizaDescarteFORM atualizaDescarteFORM) {
		log.info("[Iniciando] - Método atualizaEquipamento em DescarteRestController");
		if (!descarteService.verificaIdService(idEquipamento)) {
			log.info("[Finalizando] - Método atualizaEquipamento em DescarteRestController [NOT FOUND]");
			return ResponseEntity.notFound().build();
		}
		atualizaDescarteFORM.setId(idEquipamento);
		Descarte descarte = descarteService.atualizaEquipamentoService(atualizaDescarteFORM.toEntity());
		log.info("[Finalizando] - Método atualizaEquipamento em DescarteRestController [OK]");
		return ResponseEntity.ok(descarte);
	}

	@Override
	public List<ListaDescartesDTO> listaEquipamentos() {
		log.info("[Iniciando] - Método listaEquipamentos em DescarteRestController");
		List<Descarte> descartes = descarteService.listaEquipamentosService();
		log.info("[Finalizando] - Método listaEquipamentos em DescarteRestController");
		return ListaDescartesDTO.toList(descartes);
	}

	@Override
	public List<BuscaDescarteDTO> buscaClientePorNome(String nome) {
		log.info("[Iniciando] - Método buscaClientePorNome em DescarteRestController");
		List<Descarte> descartes = descarteService.buscaClientePorNomeService(nome);
		log.info("[Finalizando] - Método buscaClientePorNome em DescarteRestController");
		return BuscaDescarteDTO.toList(descartes);
	}

	@Override
	public List<BuscaDescarteDTO> buscaTecnicoPorNome(String nome) {
		log.info("[Iniciando] - Método buscaTecnicoPorNome em DescarteRestController");
		List<Descarte> descartes = descarteService.buscaTecnicoPorNomeService(nome);
		log.info("[Finalizando] - Método buscaTecnicoPorNome em DescarteRestController");
		return BuscaDescarteDTO.toList(descartes);
	}

	@Override
	public List<BuscaDescarteDTO> buscaDataEntrada(String data) {
		List<Descarte> descartes = descarteService.buscaDataEntradaService(data);
		return BuscaDescarteDTO.toList(descartes);
	}

}
