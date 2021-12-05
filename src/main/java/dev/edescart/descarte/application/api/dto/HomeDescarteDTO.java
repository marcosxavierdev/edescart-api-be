package dev.edescart.descarte.application.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.destino.domain.Destino;
import lombok.Getter;

@Getter
public class HomeDescarteDTO {

	private Long id;
	private String nome;
	private String cliente;
	private String destino;
	private String tecnicoResponsavel;
	private String dataEntrada;
	private String dataSaida;
	

	public HomeDescarteDTO(Descarte descarte, Destino destino) {
		this.id = descarte.getId();
		this.nome = descarte.getNome();
		this.cliente = descarte.getCliente();
		this.destino = destino.getDestino();
		this.tecnicoResponsavel = descarte.getTecnicoResponsavel();
		this.dataEntrada = descarte.getDataEntrada();
		this.dataSaida = destino.getDataSaida();
	}


}
