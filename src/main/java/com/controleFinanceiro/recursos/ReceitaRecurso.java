package com.controleFinanceiro.recursos;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleFinanceiro.dto.ReceitaDto;
import com.controleFinanceiro.modelo.Receita;
import com.controleFinanceiro.servicos.ReceitaServico;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaRecurso {
	
	@Autowired
	private ReceitaServico receitaServico;
	
	@PostMapping
	public ResponseEntity<ReceitaDto> insert(@Valid @RequestBody ReceitaDto receitaDto) {
		Receita receita = receitaServico.insert(ReceitaDto.toProduct(receitaDto));

		return ResponseEntity.status(HttpStatus.CREATED).body(ReceitaDto.toProductDTO(receita));
	}
}
