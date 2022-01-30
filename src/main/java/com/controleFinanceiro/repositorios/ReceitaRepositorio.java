package com.controleFinanceiro.repositorios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controleFinanceiro.modelo.Receita;

@Repository
public interface ReceitaRepositorio extends JpaRepository<Receita, Integer>{

	@Query(value = 
		   " SELECT exists(select 1 " +
		   "   FROM receita r " +
		   "   WHERE r.descricao = ?1 "+
		   "	 AND EXTRACT(MONTH FROM r.data) = EXTRACT(MONTH FROM TO_DATE(?2,'YYYY-MM-DD')) " +
		   "	 AND EXTRACT(YEAR FROM r.data) = EXTRACT(YEAR FROM TO_DATE(?2,'YYYY-MM-DD')) " +
		   "		) ",
		   nativeQuery = true)
	public Boolean findReceitaComMesmaDescricaoEDentroDoMesmoMes(String descricao, LocalDate data);
	
	@Query(value = " SELECT r.id, r.descricao, r.valor, r.data " +
			   	   " FROM receita r " +
			       " WHERE EXTRACT(YEAR FROM r.data) = ?1 " +
			       "   	AND EXTRACT(MONTH FROM r.data) = ?2 ",
		   nativeQuery = true)
	public List<Receita> findReceitaByMesEAno(Integer ano, Integer mes);
	
	@Query(value = " SELECT SUM(r.valor) " +
	               " FROM Receita r " +
                   " WHERE YEAR(r.data) = ?1 " +
                   "   	AND MONTH(r.data) = ?2 ")
	public BigDecimal totalReceitasPorMes(Integer ano, Integer mes);
	
	public List<Receita> findByDescricao(String descricao);
}
