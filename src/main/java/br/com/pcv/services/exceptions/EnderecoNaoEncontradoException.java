package br.com.pcv.services.exceptions;

public class EnderecoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 813516851231915143L;
	
	public EnderecoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public EnderecoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
