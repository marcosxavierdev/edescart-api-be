package dev.edescart.descarte.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.edescart.descarte.domain.Descarte;

@Repository
public interface DescarteSpringDataJpaRepository extends JpaRepository<Descarte, Long> {

	List<Descarte> findByClienteContainingIgnoreCase(String nome);

	List<Descarte> findByTecnicoResponsavelContainingIgnoreCase(String nome);

	List<Descarte> findByDataEntrada(String data);

}
