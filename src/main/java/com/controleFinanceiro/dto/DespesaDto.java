package com.controleFinanceiro.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DespesaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Integer id;
	
	@NotBlank
	private String descricao;
	@NotNull
	@Positive
	private BigDecimal valor;
	@NotNull
	private LocalDate data;
	
    private String categoria;
}
