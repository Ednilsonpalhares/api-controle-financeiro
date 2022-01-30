package com.controleFinanceiro.servicos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleFinanceiro.dto.GastoCategoriaDto;
import com.controleFinanceiro.dto.ResumoDto;
import com.controleFinanceiro.repositorios.DespesaRepositorio;
import com.controleFinanceiro.repositorios.ReceitaRepositorio;
import com.controleFinanceiro.servicos.exceptions.NoContentException;

@Service
public class ResumoServico {
	
	@Autowired
	private DespesaRepositorio despesaRepositorio;
	
	@Autowired
	private ReceitaRepositorio receitaRepositorio;
	
	public ResumoDto buscarResumoPorMesEAno(Integer ano, Integer mes) {
		BigDecimal totalReceitasPorMes = this.receitaRepositorio.totalReceitasPorMes(ano, mes);
		BigDecimal totalDespesasPorMes = this.despesaRepositorio.totalDespesasPorMes(ano, mes);
		
		if(totalReceitasPorMes == null || totalDespesasPorMes == null)
			throw new NoContentException();
		
		BigDecimal saldoFinalNoMes = totalReceitasPorMes.subtract(totalDespesasPorMes);

		List<GastoCategoriaDto> gastosCategoriaDtos = this.despesaRepositorio.totalMesEAnoPorCategoria(ano, mes);
				
		ResumoDto resumoDto = new ResumoDto(totalReceitasPorMes, totalDespesasPorMes, saldoFinalNoMes, gastosCategoriaDtos);
		
		return resumoDto;
	}
}
