package com.controleFinanceiro.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;


import com.controleFinanceiro.dto.DespesaDto;
import com.controleFinanceiro.enums.Categoria;

import jakarta.persistence.*;
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
public class Despesa {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
    private Categoria categoria;
	
	public static DespesaDto toDespesaDTO(Despesa despesa){
		return new DespesaDto(despesa.getId(), 
							  despesa.getDescricao(), 
							  despesa.getValor(), 
							  despesa.getData(),
							  despesa.getCategoria().getDescricao());
	}
	
	public static Despesa toDespesa(DespesaDto despesaDto){
		return new Despesa(despesaDto.getId(), 
				           despesaDto.getDescricao(), 
				           despesaDto.getValor(), 
				           despesaDto.getData(),
				           Categoria.toCategoria(despesaDto.getCategoria()));
	}
}
