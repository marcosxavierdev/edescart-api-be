package dev.edescart.destino.application.service;

import org.springframework.stereotype.Service;

import dev.edescart.descarte.application.repository.DescarteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class DestinoDataJpaService implements DestinoService {
	private DescarteRepository descarteRepository;

}
