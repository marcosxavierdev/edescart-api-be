package dev.edescart.descarte.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.edescart.descarte.application.api.dto.BuscaDescarteDTO;
import dev.edescart.descarte.application.api.dto.CadastraDescarteDTO;
import dev.edescart.descarte.application.api.dto.ListaDescartesDTO;
import dev.edescart.descarte.application.api.form.AtualizaDescarteFORM;
import dev.edescart.descarte.application.api.form.CadastraDescarteFORM;

@RestController
@RequestMapping("/api/v1/descarte")
public interface DescarteAPI {

	@GetMapping("/test")
	String test();

	@GetMapping("/buscaPorId/{idDescarte}")
	@ResponseStatus(value = HttpStatus.OK)
	BuscaDescarteDTO buscaDescartePorId(@PathVariable Long idDescarte);

	@PostMapping("/cadastra")
	@ResponseStatus(value = HttpStatus.CREATED)
	ResponseEntity<CadastraDescarteDTO> cadastraDescarte(@RequestBody CadastraDescarteFORM cadastraDescarteFORM,
			UriComponentsBuilder uriBuilder);

	@DeleteMapping("/deleta/{idDescarte}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	ResponseEntity<Void> deletaDescarte(@PathVariable Long idDescarte);

	@PutMapping("/atualiza/{idDescarte}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<?> atualizaDescarte(@PathVariable Long idDescarte,
			@RequestBody AtualizaDescarteFORM atualizaDescarteFORM);

	@GetMapping("/listaDescartes")
	@ResponseStatus(value = HttpStatus.OK)
	List<ListaDescartesDTO> listaDescartes();

	@GetMapping("/buscaCliente")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> buscaClientePorNome(@RequestParam String nome);

	@GetMapping("/buscaTecnico")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> buscaTecnicoPorNome(@RequestParam String nome);

	@GetMapping("/buscaDataEntrada")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> buscaDataEntrada(@RequestParam String data);
	
}
