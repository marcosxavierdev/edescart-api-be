package dev.edescart.destino.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.edescart.descarte.application.repository.DescarteRepository;
import dev.edescart.descarte.domain.Descarte;
import dev.edescart.destino.application.repository.DestinoRepository;
import dev.edescart.destino.domain.Destino;
import dev.edescart.handler.ApiException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class DestinoDataJpaService implements DestinoService {
	private DescarteRepository descarteRepository;
	private DestinoRepository destinoRepository;

	@Override
	public void criaDestinoService(Long idDescarte, Destino buildDestino) {
		Descarte descartePorId = this.buscaPorId(idDescarte);
		buildDestino.setDescarte(descartePorId);
		destinoRepository.criaDestinoInfra(buildDestino);
	}

	private Descarte buscaPorId(Long idDescarte) {
		Descarte descartePorId = descarteRepository.buscaPorId(idDescarte);
		return descartePorId;
	}

}
