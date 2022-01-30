package com.controleFinanceiro.servicos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String mensagem;
}
