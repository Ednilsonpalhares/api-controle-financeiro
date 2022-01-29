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
		Receita receita = receitaServico.insert(Receita.toReceita(receitaDto));

		return ResponseEntity.status(HttpStatus.CREATED).body(Receita.toReceitaDTO(receita));
	}
	
	@GetMapping
	public ResponseEntity<List<ReceitaDto>> findAll() {
		List<ReceitaDto> productsDto = receitaServico.findAll()
												     .stream()
												     .map(receita -> Receita.toReceitaDTO(receita))
												     .collect(Collectors.toList());

		return ResponseEntity.ok().body(productsDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReceitaDto> findById(@PathVariable Integer id) {
		Receita receita = this.receitaServico.findById(id);

		return ResponseEntity.ok().body(Receita.toReceitaDTO(receita));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReceitaDto> update(@Valid @RequestBody ReceitaDto receitaDto, @PathVariable Integer id) {
		receitaDto.setId(id);
		Receita receita = receitaServico.update(Receita.toReceita(receitaDto));

		return ResponseEntity.ok().body(Receita.toReceitaDTO(receita));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.receitaServico.delete(id);

		return ResponseEntity.ok().build();
	}
}
