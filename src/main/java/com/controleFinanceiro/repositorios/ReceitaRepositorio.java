package com.controleFinanceiro.repositorios;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controleFinanceiro.modelo.Receita;

@Repository
public interface ReceitaRepositorio extends JpaRepository<Receita, Long>{

	@Query(value = 
		   " SELECT exists(select 1 " +
		   "   FROM receita re " +
		   "   where re.descricao = ?1 "+
		   "	 and extract(month from re.data) = extract(month from TO_DATE(?2,'YYYY-MM-DD')) " +
		   "	 and extract(year from re.data) = extract(year from TO_DATE(?2,'YYYY-MM-DD')) " +
		   "		) ",
		   nativeQuery = true)
	public Boolean findReceitaComMesmaDescricaoEDentroDoMesmoMes(String descricao, LocalDate data);
}
