package br.com.pcv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.pcv.domain.Cidade;
import br.com.pcv.domain.Endereco;
import br.com.pcv.repository.EnderecosRepository;
import br.com.pcv.services.exceptions.EnderecoNaoEncontradoException;

@Service
public class EnderecosService {

	@Autowired
	private EnderecosRepository enderecosRespository;
	
	public List<Endereco> listar() {
		return this.enderecosRespository.findAll();
	}
	
	public Endereco buscar(Long id) {
		Endereco e = this.enderecosRespository.findOne(id);
		
		if(e == null) {
			throw new EnderecoNaoEncontradoException("Endereço não encontrado!");
		}
		
		return e;
	}
	
	public Endereco salvar(Endereco endereco) {
		endereco.setId(null);
		endereco = this.enderecosRespository.save(endereco);
		
		return endereco;
	}
	
	public void deletar(Long id) {
		try {
			this.enderecosRespository.delete(id);
		} catch(EmptyResultDataAccessException e) {
			throw new EnderecoNaoEncontradoException("Endereço não encontrado!");
		}
	}
	
	public void atualizar(Endereco endereco) {
		this.verificarExistencia(endereco);
		this.enderecosRespository.save(endereco);
	}
	
	private void verificarExistencia(Endereco endereco) {
		this.buscar(endereco.getId());
	}
	
}
