package com.controleFinanceiro.recursos;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleFinanceiro.dto.DespesaDto;
import com.controleFinanceiro.modelo.Despesa;
import com.controleFinanceiro.servicos.DespesaServico;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaRecurso {
	
	@Autowired
	private DespesaServico despesaServico;
	
	@PostMapping
	public ResponseEntity<DespesaDto> insert(@Valid @RequestBody DespesaDto despesaDto) {
		Despesa despesa = despesaServico.insert(DespesaDto.toDespesa(despesaDto));

		return ResponseEntity.status(HttpStatus.CREATED).body(DespesaDto.toDespesaDTO(despesa));
	}
	
	@GetMapping
	public ResponseEntity<List<DespesaDto>> findAll() {
		List<DespesaDto> despesasDto = despesaServico.findAll()
												     .stream()
												     .map(despesa -> DespesaDto.toDespesaDTO(despesa))
												     .collect(Collectors.toList());

		return ResponseEntity.ok().body(despesasDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DespesaDto> findById(@PathVariable Integer id) {
		Despesa despesa = this.despesaServico.findById(id);

		return ResponseEntity.ok().body(DespesaDto.toDespesaDTO(despesa));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DespesaDto> update(@Valid @RequestBody DespesaDto despesaDto, @PathVariable Integer id) {
		despesaDto.setId(id);
		Despesa despesa = despesaServico.update(DespesaDto.toDespesa(despesaDto));

		return ResponseEntity.ok().body(DespesaDto.toDespesaDTO(despesa));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.despesaServico.delete(id);

		return ResponseEntity.ok().build();
	}
}
