package br.com.pcv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pcv.domain.Uf;
import br.com.pcv.repository.UfsRepository;
import br.com.pcv.services.exceptions.UfNaoEncontradaException;

@Service
public class UfsService {

	@Autowired
	private UfsRepository ufsRepository;
	
	public List<Uf> listar() {
		return this.ufsRepository.findAll();
	}
	
	public Uf buscar(Long id) {
		Uf u = this.ufsRepository.findOne(id);
		
		if(u == null) {
			throw new UfNaoEncontradaException("Uf não encontrada!");
		}
		
		return u;
	}
	
}
