package br.com.pcv.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pcv.domain.DetalhesErro;
import br.com.pcv.services.exceptions.CidadeNaoEncontradaException;
import br.com.pcv.services.exceptions.ContatoNaoEncontradoException;
import br.com.pcv.services.exceptions.EnderecoNaoEncontradoException;
import br.com.pcv.services.exceptions.UfNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CidadeNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleCidadeNaoEncontradaException(CidadeNaoEncontradaException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setTitulo("Cidade não encontrada!");
		erro.setMensagemDesenvolvedor(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		//return ResponseEntity.notFound().build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UfNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleUfNaoEncontradaException(UfNaoEncontradaException e, HttpServletRequest request) {
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setTitulo("Uf não encontrada!");
		erro.setMensagemDesenvolvedor(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		//return ResponseEntity.notFound().build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EnderecoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleEnderecoNaoEncontradoException(EnderecoNaoEncontradoException e, HttpServletRequest request) {
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setTitulo("Endereço não encontrado!");
		erro.setMensagemDesenvolvedor(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		//return ResponseEntity.notFound().build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ContatoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleContatoNaoEncontradoException(ContatoNaoEncontradoException e, HttpServletRequest request) {
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setTitulo("Contato não encontrado!");
		erro.setMensagemDesenvolvedor(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		//return ResponseEntity.notFound().build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
}
