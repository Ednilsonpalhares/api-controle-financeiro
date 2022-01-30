package com.controleFinanceiro.dto;

import java.math.BigDecimal;

import com.controleFinanceiro.enums.Categoria;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GastoCategoriaDto {
	
	private Categoria categoria;
	private BigDecimal valorTotal;
}
