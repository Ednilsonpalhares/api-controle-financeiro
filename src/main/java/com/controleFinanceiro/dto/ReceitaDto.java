package com.controleFinanceiro.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.controleFinanceiro.modelo.Receita;

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
public class ReceitaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotBlank
	private String descricao;
	@NotNull
	@Positive
	private BigDecimal valor;
	@NotNull
	private LocalDate data;
	
	public static ReceitaDto toProductDTO(Receita receita){
		return new ReceitaDto(receita.getId(), receita.getDescricao(), receita.getValor(), receita.getData());
	}

	public static Receita toProduct(ReceitaDto receitaDto){
		return new Receita(receitaDto.getId(), receitaDto.getDescricao(), receitaDto.getValor(), receitaDto.getData());
	}
}
