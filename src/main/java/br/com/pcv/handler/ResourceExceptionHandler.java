package br.com.pcv.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pcv.domain.DetalhesErro;
import br.com.pcv.services.exceptions.CidadeNaoEncontradaException;

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
	
}
