package dev.edescart.descarte.application.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.edescart.descarte.application.api.dto.CadastraDescarteDTO;
import dev.edescart.descarte.application.api.dto.ResultadoBuscaDescarteDTO;
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
	public ResultadoBuscaDescarteDTO buscaDescartePorId(Long idDescarte) {
		log.info("[Iniciando] - Método buscaDescartePorId em DescarteRestController");
		log.info("[Buscando] - Id em DescarteRestController: {}", idDescarte);
		Descarte descarte = descarteService.buscaDescartePorIdService(idDescarte);
		log.info("[Finalizando] - Método buscaDescartePorId em DescarteRestController");
		return new ResultadoBuscaDescarteDTO(descarte);
	}

	@Override
	public ResponseEntity<CadastraDescarteDTO> cadastraDescarte(CadastraDescarteFORM cadastraDescarteFORM,
			UriComponentsBuilder uriBuilder) {
		log.info("[Iniciando] - Método cadastraDescarte em DescarteRestController");
		Descarte descarte = descarteService.cadastraDescarteService(cadastraDescarteFORM.buildDescarte());
		URI uri = uriBuilder.path("/").buildAndExpand(descarte.getId()).toUri();
		log.info("[Finalizando] - Método cadastraDescarte em DescarteRestController");
		return ResponseEntity.created(uri).body(new CadastraDescarteDTO(descarte));
	}

	@Override
	public ResponseEntity<Void> deletaDescarte(Long idDescarte) {
		log.info("[Iniciando] - Método deletaDescarte em DescarteRestController");
		if (!descarteService.verificaIdService(idDescarte)) {
			log.info("[Finalizando] - Método deletaDescarte em DescarteRestController [NOT FOUND]");
			return ResponseEntity.notFound().build();
		}
		descarteService.deletaDescarteService(idDescarte);
		log.info("[Finalizando] - Método deletaDescarte em DescarteRestController [OK]");
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<?> atualizaDescarte(Long idDescarte, AtualizaDescarteFORM atualizaDescarteFORM) {
		log.info("[Iniciando] - Método atualizaDescarte em DescarteRestController");
		if (!descarteService.verificaIdService(idDescarte)) {
			log.info("[Finalizando] - Método atualizaDescarte em DescarteRestController [NOT FOUND]");
			return ResponseEntity.notFound().build();
		}
		atualizaDescarteFORM.setId(idDescarte);
		Descarte descarte = descarteService.atualizaDescarteService(atualizaDescarteFORM.buildDescarte());
		log.info("[Finalizando] - Método atualizaDescarte em DescarteRestController [OK]");
		return ResponseEntity.ok(descarte);
	}

	@Override
	public List<ResultadoBuscaDescarteDTO> listaDescartes() {
		log.info("[Iniciando] - Método listaDescartes em DescarteRestController");
		List<Descarte> descartes = descarteService.listaDescartesService();
		log.info("[Finalizando] - Método listaDescartes em DescarteRestController");
		return ResultadoBuscaDescarteDTO.toList(descartes);
	}

	@Override
	public List<ResultadoBuscaDescarteDTO> buscaClientePorNome(String nome) {
		log.info("[Iniciando] - Método buscaClientePorNome em DescarteRestController");
		List<Descarte> descartes = descarteService.buscaClientePorNomeService(nome);
		log.info("[Finalizando] - Método buscaClientePorNome em DescarteRestController");
		return ResultadoBuscaDescarteDTO.toList(descartes);
	}

	@Override
	public List<ResultadoBuscaDescarteDTO> buscaTecnicoPorNome(String nome) {
		log.info("[Iniciando] - Método buscaTecnicoPorNome em DescarteRestController");
		List<Descarte> descartes = descarteService.buscaTecnicoPorNomeService(nome);
		log.info("[Finalizando] - Método buscaTecnicoPorNome em DescarteRestController");
		return ResultadoBuscaDescarteDTO.toList(descartes);
	}

	@Override
	public List<ResultadoBuscaDescarteDTO> buscaDataEntrada(String data) {
		log.info("[Iniciando] - Método buscaDataEntrada em DescarteRestController");
		List<Descarte> descartes = descarteService.buscaDataEntradaService(data);
		log.info("[Finalizando] - Método buscaDataEntrada em DescarteRestController");
		return ResultadoBuscaDescarteDTO.toList(descartes);
	}

}
