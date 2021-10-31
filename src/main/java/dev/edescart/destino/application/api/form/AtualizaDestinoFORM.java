package dev.edescart.destino.application.api.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.edescart.destino.domain.DescarteAntecipado;
import dev.edescart.destino.domain.Destino;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaDestinoFORM {

	private Long id;
	private String destino;
	private String autorizacaoDestino;
	private String contatoDestino;
	private String dataSaida = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private String observacaoDestino;

	private DescarteAntecipado descarteAntecipado = DescarteAntecipado.NAO;

	public Destino buildDestino() {
		return Destino.builder().destino(destino).autorizacaoDestino(this.autorizacaoDestino)
				.contatoDestino(this.contatoDestino).dataSaida(this.dataSaida).observacaoDestino(this.observacaoDestino)
				.descarteAntecipado(this.descarteAntecipado).build();
	}

	public void setId(Long idDestino) {
		this.id= idDestino;	
	}
	
}
