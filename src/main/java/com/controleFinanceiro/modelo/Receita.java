package com.controleFinanceiro.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.controleFinanceiro.dto.ReceitaDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy= GenerationType.AUTO)
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
