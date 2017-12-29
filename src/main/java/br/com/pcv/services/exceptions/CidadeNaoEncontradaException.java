package br.com.pcv.services.exceptions;

public class CidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 5054323371809290768L;

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CidadeNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
