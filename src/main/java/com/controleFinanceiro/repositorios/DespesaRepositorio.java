package com.controleFinanceiro.repositorios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controleFinanceiro.dto.GastoCategoriaDto;
import com.controleFinanceiro.modelo.Despesa;

@Repository
@JaversSpringDataAuditable
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
	
	@Query(value = " SELECT d.id, d.descricao, d.valor, d.data, d.categoria " +
		   	       " FROM despesa d " +
		           " WHERE EXTRACT(YEAR FROM d.data) = ?1 " +
		           "   	AND EXTRACT(MONTH FROM d.data) = ?2 ",
	   nativeQuery = true)
	public List<Despesa> findDespesaByMesEAno(Integer ano, Integer mes);
		
	@Query(value = " SELECT SUM(d.valor) " +
	   	           " FROM despesa d " +
	               " WHERE EXTRACT(YEAR FROM d.data) = ?1 " +
	               "   	AND EXTRACT(MONTH FROM d.data) = ?2 ",
	       nativeQuery = true)
	public BigDecimal totalDespesasPorMes(Integer ano, Integer mes);
	
    @Query(value = "SELECT new com.controleFinanceiro.dto.GastoCategoriaDto(d.categoria, sum(d.valor))" +
    		       " FROM Despesa d " +
                   " WHERE YEAR(d.data) = ?1 " +
                   "   	AND MONTH(d.data) = ?2 " + 
                   " GROUP BY d.categoria ")
	public List<GastoCategoriaDto> totalMesEAnoPorCategoria(Integer ano, Integer mes);
	
	public List<Despesa> findByDescricao(String descricao);
}
