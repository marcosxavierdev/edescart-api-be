package dev.edescart.destino.infrastructure;

import org.springframework.stereotype.Component;

import dev.edescart.destino.application.repository.DestinoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class DestinoJpaRepository implements DestinoRepository {
	private DestinoSpringDataJpaRepository destinoSpringDataJpaRepository;

}
