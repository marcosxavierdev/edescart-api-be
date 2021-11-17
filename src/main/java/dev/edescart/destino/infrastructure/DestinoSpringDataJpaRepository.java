package dev.edescart.destino.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.edescart.destino.domain.Destino;

@Repository
public interface DestinoSpringDataJpaRepository extends JpaRepository<Destino, Long> {

	List<Destino> findByDestinoContainingIgnoreCase(String destino);

	List<Destino> findByDataSaida(String data);

	Optional<Destino> findByDescarteId(Long idDestino);

}
