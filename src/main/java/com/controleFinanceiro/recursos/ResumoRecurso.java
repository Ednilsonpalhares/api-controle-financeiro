package com.controleFinanceiro.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleFinanceiro.dto.ResumoDto;
import com.controleFinanceiro.servicos.ResumoServico;

@RestController
@RequestMapping(value = "/resumo")
public class ResumoRecurso {
	
	@Autowired
	private ResumoServico resumoServico;
	
	@GetMapping("/{ano}/{mes}")
	public ResponseEntity<ResumoDto> findByAnoEMes(
									  @PathVariable Integer ano,
									  @PathVariable Integer mes) {
		
		ResumoDto resumoDto = resumoServico.buscarResumoPorMesEAno(ano, mes);
		
		return ResponseEntity.ok().body(resumoDto);
	}
}
