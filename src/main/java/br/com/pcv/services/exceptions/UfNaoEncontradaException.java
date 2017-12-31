package br.com.pcv.services.exceptions;

public class UfNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = -2259289792099070374L;
	
	public UfNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public UfNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
