package dev.edescart.destino.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dev.edescart.descarte.domain.Descarte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String destino;
	private String autorizacaoDestino;
	private String contatoDestino;
	private LocalDateTime dataSaida;
	private String ObservacaoDestino;
	
	private DescarteAntecipado descarteAntecipado;
	
	@OneToOne
	private Descarte descarte;

}
