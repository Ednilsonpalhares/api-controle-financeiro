package com.controleFinanceiro.repositorios;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controleFinanceiro.modelo.Despesa;

@Repository
public interface DespesaRepositorio extends JpaRepository<Despesa, Integer>{

	@Query(value = 
		   " SELECT exists(select 1 " +
		   "   FROM despesa d " +
		   "   where d.descricao = ?1 "+
		   "	 and extract(month from d.data) = extract(month from TO_DATE(?2,'YYYY-MM-DD')) " +
		   "	 and extract(year from d.data) = extract(year from TO_DATE(?2,'YYYY-MM-DD')) " +
		   "		) ",
		   nativeQuery = true)
	public Boolean findDespesaComMesmaDescricaoEDentroDoMesmoMes(String descricao, LocalDate data);
}
