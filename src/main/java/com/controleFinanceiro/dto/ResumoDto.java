package com.controleFinanceiro.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResumoDto {
	
	private BigDecimal valorTotalReceitasPorMes;
	private BigDecimal valorTotalDespesasPorMes;
	private BigDecimal saldoFinalNoMes;
	private List<GastoCategoriaDto> gastosNoMesPorCategoria;
}
