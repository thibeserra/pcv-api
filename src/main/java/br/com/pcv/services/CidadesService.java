package br.com.pcv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pcv.domain.Cidade;
import br.com.pcv.repository.CidadeRepository;
import br.com.pcv.services.exceptions.CidadeNaoEncontradaException;

@Service
public class CidadesService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar() {
		return this.cidadeRepository.findAll();
	}
	
	public Cidade buscar(Long id) {
		Cidade c = this.cidadeRepository.findOne(id);
		
		if(c == null) {
			throw new CidadeNaoEncontradaException("Cidade não encontrada!");
		}
		
		return c;
	}
	
	public Cidade salvar(Cidade cidade) {
		cidade.setId(null);
		cidade = this.cidadeRepository.save(cidade);
		
		return cidade;
	}
	
	public void deletar(Long id) {
		
		try {
			this.cidadeRepository.delete(id);
		} catch(EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradaException("Cidade não encontrada!");
		}
		
	}
	
	public void atualizar(Cidade cidade) {
		this.verificarExistencia(cidade);
		this.cidadeRepository.save(cidade);
	}
	
	private void verificarExistencia(Cidade cidade) {
		this.buscar(cidade.getId());
	}
	
}
