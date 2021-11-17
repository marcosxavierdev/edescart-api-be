package dev.edescart.destino.application.api.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.edescart.destino.domain.DescarteAntecipado;
import dev.edescart.destino.domain.Destino;
import lombok.Value;

@Value
public class CriaDestinoFORM {

	private long id;
	private String destino;
	private String autorizacaoDestino;
	private String contatoDestino;
	private String dataSaida = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private String observacaoDestino;

	private DescarteAntecipado descarteAntecipado = DescarteAntecipado.NAO;

	public Destino buildDestino() {
		return Destino.builder().id(this.id).destino(destino).autorizacaoDestino(this.autorizacaoDestino)
				.contatoDestino(this.contatoDestino).dataSaida(this.dataSaida).observacaoDestino(this.observacaoDestino)
				.descarteAntecipado(this.descarteAntecipado).build();
	}

}
