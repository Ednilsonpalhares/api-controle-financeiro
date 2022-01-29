package com.controleFinanceiro.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleFinanceiro.modelo.Receita;
import com.controleFinanceiro.repositorios.ReceitaRepositorio;
import com.controleFinanceiro.servicos.exceptions.NegocionException;

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
}
