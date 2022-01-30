package com.controleFinanceiro.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleFinanceiro.modelo.Receita;
import com.controleFinanceiro.repositorios.ReceitaRepositorio;
import com.controleFinanceiro.servicos.exceptions.NegocionException;
import com.controleFinanceiro.servicos.exceptions.NoContentException;
import com.controleFinanceiro.servicos.exceptions.ObjectNotFoundException;

@Service
public class ReceitaServico {
	
	@Autowired
	private ReceitaRepositorio receitaRepositorio;
	
	private final static String MENSAGEM_DE_ERRO = "Receita não encontrada.";
	
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
				   .orElseThrow(() -> new ObjectNotFoundException(MENSAGEM_DE_ERRO));
	}
	
	public List<Receita> findByDescricao(String descricao) {
		List<Receita> receitas = this.receitaRepositorio.findByDescricao(descricao);
		
		if(receitas.isEmpty())
			throw new ObjectNotFoundException(MENSAGEM_DE_ERRO);
		
		return receitas;
				   
	}
	
	public Receita update(Receita receita) {
		findById(receita.getId());

		return this.receitaRepositorio.save(receita);
	}
	
	public void delete(Integer id) {
		findById(id);

		this.receitaRepositorio.deleteById(id);
	}
	
	public List<Receita> findReceitaByMesEAno(Integer ano, Integer mes) {
		List<Receita> receitas = this.receitaRepositorio.findReceitaByMesEAno(ano, mes);
		
		if(receitas.isEmpty())
			throw new NoContentException();
		
		return receitas;	   
	}				
}
