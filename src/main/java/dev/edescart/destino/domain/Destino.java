package dev.edescart.destino.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dev.edescart.descarte.domain.Descarte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
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
	private String dataSaida;
	private String observacaoDestino;

	private DescarteAntecipado descarteAntecipado;

	@OneToOne
	private Descarte descarte;

	public void setDescarte(Descarte descarte) {
		this.descarte = descarte;
	}

}
