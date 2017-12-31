package br.com.pcv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pcv.domain.Contato;
import br.com.pcv.repository.ContatosRepository;
import br.com.pcv.services.exceptions.ContatoNaoEncontradoException;

@Service
public class ContatosService {

	@Autowired
	private ContatosRepository contatosRepository;
	
	public List<Contato> listar() {
		return this.contatosRepository.findAll();
	}
	
	public Contato buscar(Long id) {
		Contato c = this.contatosRepository.findOne(id);
		
		if(c == null) {
			throw new ContatoNaoEncontradoException("Contato não encontrado!");
		}
		
		return c;
	}
	
	public Contato salvar(Contato contato) {
		contato.setId(null);
		contato = this.contatosRepository.save(contato);
		
		return contato;
	}
	
	public void deletar(Long id) {
		try {
			this.contatosRepository.delete(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ContatoNaoEncontradoException("Contato não encontrado!");
		}
	}
	
	public void atualizar(Contato contato) {
		this.verificaExistencia(contato);
		this.contatosRepository.save(contato);
	}
	
	private void verificaExistencia(Contato contato) {
		this.buscar(contato.getId());
	}
	
}
