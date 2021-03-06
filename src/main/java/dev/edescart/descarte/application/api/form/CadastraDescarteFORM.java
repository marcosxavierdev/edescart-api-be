package dev.edescart.descarte.application.api.form;

import java.time.LocalDateTime;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.descarte.domain.enums.DescarteAntecipado;
import dev.edescart.descarte.domain.enums.SituacaoDoItem;
import dev.edescart.descarte.domain.enums.TipoDoItem;
import lombok.Getter;

@Getter
public class CadastraDescarteFORM {

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
	private LocalDateTime dataEntrada = LocalDateTime.now();
	private int descartarEm;
	private String motivoDescarte;
	private String origemObservacao;

	private SituacaoDoItem situacaoDoItem;
	private TipoDoItem tipoDoItem;
	private DescarteAntecipado descarteAntecipado;

	public Descarte toEntity() {
		return new Descarte(id, nome, modelo, marca, unidade, quantidade, observacao, cliente,
				autorizacaoEmpresa, tecnicoResponsavel, dataEntrada, descartarEm, motivoDescarte, origemObservacao,
				situacaoDoItem, tipoDoItem);
	}

}
