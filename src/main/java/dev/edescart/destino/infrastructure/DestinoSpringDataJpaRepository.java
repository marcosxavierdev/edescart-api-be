package dev.edescart.destino.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.edescart.destino.domain.Destino;

@Repository
public interface DestinoSpringDataJpaRepository extends JpaRepository<Destino, Long> {

}
