package dev.edescart.destino.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.edescart.destino.domain.Destino;
import lombok.Getter;

@Getter
public class BuscaDestinoDTO {

	private Long id;
	private String destino;
	private String autorizacaoDestino;
	private String contatoDestino;
	private String dataSaida;
	private String observacaoDestino;

	public BuscaDestinoDTO(Destino destino) {
		this.id = destino.getId();
		this.destino = destino.getDestino();
		this.autorizacaoDestino = destino.getAutorizacaoDestino();
		this.contatoDestino = destino.getContatoDestino();
		this.dataSaida = destino.getDataSaida();
		this.observacaoDestino = destino.getObservacaoDestino();
	}

	public static List<BuscaDestinoDTO> toList(List<Destino> destino) {
		return destino.stream().map(BuscaDestinoDTO::new).collect(Collectors.toList());
	}

}
