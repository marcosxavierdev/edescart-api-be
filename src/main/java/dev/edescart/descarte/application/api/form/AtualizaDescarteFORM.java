package dev.edescart.descarte.application.api.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.edescart.descarte.domain.Descarte;
import dev.edescart.descarte.domain.enums.SituacaoDoItem;
import dev.edescart.descarte.domain.enums.TipoDoItem;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtualizaDescarteFORM {

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
	private String dataEntrada = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	private int descartarEm;
	private String motivoDescarte;
	private String origemObservacao;

	private SituacaoDoItem situacaoDoItem;
	private TipoDoItem tipoDoItem;

	public Descarte buildDescarte() {
		return Descarte.builder().nome(this.nome).modelo(this.modelo).marca(this.marca).unidade(this.unidade)
				.quantidade(this.quantidade).observacao(this.observacao).cliente(this.cliente)
				.autorizacaoEmpresa(this.autorizacaoEmpresa).tecnicoResponsavel(this.tecnicoResponsavel)
				.dataEntrada(this.dataEntrada).descartarEm(this.descartarEm).motivoDescarte(this.motivoDescarte)
				.origemObservacao(this.origemObservacao).situacaoDoItem(this.situacaoDoItem).tipoDoItem(this.tipoDoItem)
				.build();
	}

	public void setId(Long idEquipamento) {
		this.id = idEquipamento;

	}

}
