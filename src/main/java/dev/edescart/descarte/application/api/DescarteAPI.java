package dev.edescart.descarte.application.api;

import java.util.List;

import javax.transaction.Transactional;

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
<<<<<<< HEAD
=======
import dev.edescart.descarte.application.api.dto.DetalhaDescarteFinalDTO;
>>>>>>> aeed856ccb352099e5026cbc3266fa6efc07d406
import dev.edescart.descarte.application.api.form.AtualizaDescarteFORM;
import dev.edescart.descarte.application.api.form.CadastraDescarteFORM;
import dev.edescart.descarte.domain.Descarte;

@RestController
@RequestMapping("/api/v1/descarte")
public interface DescarteAPI {

	@GetMapping("/test")
	String test();

	@GetMapping("/{idDescarte}")
	@ResponseStatus(value = HttpStatus.OK)
	BuscaDescarteDTO buscaDescartePorId(@PathVariable Long idDescarte);

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	ResponseEntity<CadastraDescarteDTO> cadastraDescarte(@RequestBody CadastraDescarteFORM cadastraDescarteFORM,
			UriComponentsBuilder uriBuilder);

	@Transactional
	@DeleteMapping("/{idDescarte}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	ResponseEntity<Void> deletaDescarte(@PathVariable Long idDescarte);

	@Transactional
	@PutMapping("/{idDescarte}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<Descarte> atualizaDescarte(@PathVariable Long idDescarte,
			@RequestBody AtualizaDescarteFORM atualizaDescarteFORM);

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> listaDescartes();

	@GetMapping("/descartesPorCliente")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> buscaClientePorNome(@RequestParam String nome);

	@GetMapping("/descartesPorTecnico")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> buscaTecnicoPorNome(@RequestParam String nome);

	@GetMapping("/descartesPorDataEntrada")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDescarteDTO> buscaDataEntrada(@RequestParam String data);

	@GetMapping("/detalhaDescarte/{idDescarte}")
	@ResponseStatus(value = HttpStatus.OK)
	DetalhaDescarteFinalDTO detalhaDescarte (@PathVariable Long idDescarte);
}
