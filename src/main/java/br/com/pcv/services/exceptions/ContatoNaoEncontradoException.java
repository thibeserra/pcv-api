package br.com.pcv.services.exceptions;

public class ContatoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 6023862602023385031L;
	
	public ContatoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ContatoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
