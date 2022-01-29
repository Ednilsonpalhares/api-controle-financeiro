package com.controleFinanceiro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Categoria {
	ALIMENTACAO("Alimentação"),
	SAUDE("Saúde"),
	MORADIA("Moradia"),
	TRANSPORTE("Transporte"),
	EDUCACAO("Educação"),
	LAZER("Lazer"),
	IMPREVISTOS("Imprevistos"),
	OUTRAS("Outras");
	
	private String descricao;
	
	public static Categoria toCategoria(String descricaoCategoria) {
		for(Categoria categoria : Categoria.values()) {
			if(categoria.getDescricao().equalsIgnoreCase(descricaoCategoria))
				return categoria;
		}
		return OUTRAS;
	}
}
