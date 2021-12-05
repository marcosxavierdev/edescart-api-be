package dev.edescart.destino.application.api;

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

import dev.edescart.descarte.application.api.dto.BuscaDescarteDTO;
import dev.edescart.descarte.application.api.form.AtualizaDescarteFORM;
import dev.edescart.destino.application.api.dto.BuscaDestinoDTO;
import dev.edescart.destino.application.api.form.AtualizaDestinoFORM;
import dev.edescart.destino.application.api.form.CriaDestinoFORM;

@RestController
@RequestMapping("/api/v1/descarte")
public interface DestinoAPI {

	@PostMapping("/{idDescarte}/criaDestino")
	@ResponseStatus(value = HttpStatus.CREATED)
	void criaDestino(@PathVariable Long idDescarte, @RequestBody CriaDestinoFORM criaDestinoFORM);

	@GetMapping("/{idDestino}")
	@ResponseStatus(value = HttpStatus.OK)
	BuscaDestinoDTO buscaDestinoPorId(@PathVariable Long idDestino);
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDestinoDTO> listaDestinos();
	
	@GetMapping("/destinosPorNome")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDestinoDTO> buscaDestinoPorNome(@RequestParam String destino);
	
	@GetMapping("/destinosPorDataSaida")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDestinoDTO> buscaDataSaida(@RequestParam String data);
	
	@Transactional
	@DeleteMapping("/destino/{idDestino}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	ResponseEntity<Void> deletaDestino(@PathVariable Long idDestino);
	
	@Transactional
	@PutMapping("/destino/{idDestino}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<?> atualizaDestino(@PathVariable Long idDestino,
			@RequestBody AtualizaDestinoFORM atualizaDestinoFORM);

}
