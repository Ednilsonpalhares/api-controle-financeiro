package com.controleFinanceiro.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleFinanceiro.modelo.Receita;
import com.controleFinanceiro.repositorios.ReceitaRepositorio;
import com.controleFinanceiro.servicos.exceptions.NegocionException;
import com.controleFinanceiro.servicos.exceptions.ObjectNotFoundException;

@Service
public class ReceitaServico {
	
	@Autowired
	private ReceitaRepositorio receitaRepositorio;
	
	public Receita insert(Receita receita) {
		
		if(receitaRepositorio.findReceitaComMesmaDescricaoEDentroDoMesmoMes(receita.getDescricao(), 
																			receita.getData()))
		   throw new NegocionException("Receita já existe com mesma descrição.");
		
		receita.setId(null);

		return this.receitaRepositorio.save(receita);
	}
	
	public List<Receita> findAll() {
		return this.receitaRepositorio.findAll();
	}
	
	public Receita findById(Integer id) {
		return this.receitaRepositorio
				   .findById(id)
				   .orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public Receita update(Receita receita) {
		findById(receita.getId());

		return this.receitaRepositorio.save(receita);
	}
}
