package dev.edescart.descarte.application.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.descarte.domain.enums.SituacaoDoItem;
import dev.edescart.descarte.domain.enums.TipoDoItem;
import lombok.Getter;

@Getter
public class ResultadoBuscaDescarteDTO {

	private Long id;
	private String nome;
	private String modelo;
	private String marca;
	private String unidade;
	private int quantidade;
	private String observacao;
	private String cliente;
	private String autorizacaoEmpresa;
	private String tecnicoResponsavel;
	private String dataEntrada;
	private int descartarEm;
	private String motivoDescarte;
	private String origemObservacao;
	private SituacaoDoItem situacaoDoItem;
	private TipoDoItem tipoDoItem;

	public ResultadoBuscaDescarteDTO(Descarte descarte) {
		this.id = descarte.getId();
		this.nome = descarte.getNome();
		this.modelo = descarte.getModelo();
		this.marca = descarte.getMarca();
		this.unidade = descarte.getUnidade();
		this.quantidade = descarte.getQuantidade();
		this.observacao = descarte.getObservacao();
		this.cliente = descarte.getCliente();
		this.autorizacaoEmpresa = descarte.getAutorizacaoEmpresa();
		this.tecnicoResponsavel = descarte.getTecnicoResponsavel();
		this.dataEntrada = descarte.getDataEntrada();
		this.descartarEm = descarte.getDescartarEm();
		this.motivoDescarte = descarte.getMotivoDescarte();
		this.origemObservacao = descarte.getOrigemObservacao();
		this.situacaoDoItem = descarte.getSituacaoDoItem();
		this.tipoDoItem = descarte.getTipoDoItem();
	}

	public static List<ResultadoBuscaDescarteDTO> toList(List<Descarte> descartes) {
		return descartes.stream().map(ResultadoBuscaDescarteDTO::new).collect(Collectors.toList());
	}

}
