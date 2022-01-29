package com.controleFinanceiro.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.controleFinanceiro.dto.ReceitaDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Receita {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	
	public static ReceitaDto toReceitaDTO(Receita receita){
		return new ReceitaDto(receita.getId(), receita.getDescricao(), receita.getValor(), receita.getData());
	}
	
	public static Receita toReceita(ReceitaDto receitaDto){
		return new Receita(receitaDto.getId(), receitaDto.getDescricao(), receitaDto.getValor(), receitaDto.getData());
	}
}
