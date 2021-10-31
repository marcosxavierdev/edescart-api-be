package dev.edescart.destino.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/descarte")
public interface DestinoAPI {

	@PostMapping("/{idDescarte}/criaDestino")
	@ResponseStatus(value = HttpStatus.CREATED)
	void criaDestino(@PathVariable Long idDescarte, @RequestBody CriaDestinoFORM criaDestinoFORM);

}