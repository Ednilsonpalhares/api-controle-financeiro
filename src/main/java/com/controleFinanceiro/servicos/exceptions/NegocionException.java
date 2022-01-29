package com.controleFinanceiro.servicos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NegocionException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
}
