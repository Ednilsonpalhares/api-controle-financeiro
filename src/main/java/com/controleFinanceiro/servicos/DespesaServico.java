package com.controleFinanceiro.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleFinanceiro.modelo.Despesa;
import com.controleFinanceiro.repositorios.DespesaRepositorio;
import com.controleFinanceiro.servicos.exceptions.NegocionException;
import com.controleFinanceiro.servicos.exceptions.ObjectNotFoundException;

@Service
public class DespesaServico {
	
	@Autowired
	private DespesaRepositorio despesaRepositorio;
	
	public Despesa insert(Despesa despesa) {
		
		if(despesaRepositorio.findDespesaComMesmaDescricaoEDentroDoMesmoMes(despesa.getDescricao(), 
																			despesa.getData()))
		   throw new NegocionException("Despesa já existe com mesma descrição.");
		
		despesa.setId(null);

		return this.despesaRepositorio.save(despesa);
	}
	
	public List<Despesa> findAll() {
		return this.despesaRepositorio.findAll();
	}
	
	public List<Despesa> findByDescricao(String descricao) {
		List<Despesa> despesas = this.despesaRepositorio.findByDescricao(descricao);
		
		if(despesas.isEmpty())
			throw new ObjectNotFoundException();
		
		return despesas;
				   
	}
	
	public Despesa findById(Integer id) {
		return this.despesaRepositorio
				   .findById(id)
				   .orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public Despesa update(Despesa despesa) {
		findById(despesa.getId());

		return this.despesaRepositorio.save(despesa);
	}
	
	public void delete(Integer id) {
		findById(id);

		this.despesaRepositorio.deleteById(id);
	}
	
	public List<Despesa> findDespesaByMesEAno(Integer ano, Integer mes) {
		List<Despesa> despesas = this.despesaRepositorio.findDespesaByMesEAno(ano, mes);
		
		if(despesas.isEmpty())
			throw new ObjectNotFoundException();
		
		return despesas; 
	}
}
