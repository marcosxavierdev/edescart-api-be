package dev.edescart.destino.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.edescart.descarte.application.api.dto.BuscaDescarteDTO;

@RestController
@RequestMapping("/api/v1/descarte")
public interface DestinoAPI {

	@PostMapping("/{idDescarte}/criaDestino")
	@ResponseStatus(value = HttpStatus.CREATED)
	void criaDestino(@PathVariable Long idDescarte, @RequestBody CriaDestinoFORM criaDestinoFORM);

	@GetMapping("/destino/{idDestino}")
	@ResponseStatus(value = HttpStatus.OK)
	BuscaDestinoDTO buscaDestinoPorId(@PathVariable Long idDestino);
	
	@GetMapping("/listaDestinos")
	@ResponseStatus(value = HttpStatus.OK)
	List<BuscaDestinoDTO> listaDestinos();

}
