package dev.edescart.descarte.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dev.edescart.descarte.domain.enums.SituacaoDoItem;
import dev.edescart.descarte.domain.enums.TipoDoItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Descarte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private LocalDate dataEntrada;
	private int descartarEm;
	private String motivoDescarte;
	private String origemObservacao;

	private SituacaoDoItem situacaoDoItem;
	private TipoDoItem tipoDoItem;

}
