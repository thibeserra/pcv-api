package br.com.pcv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pcv.domain.Uf;
import br.com.pcv.repository.UfsRepository;

@RestController
@RequestMapping("/ufs")
public class UfResources {
	
	@Autowired
	private UfsRepository ufsRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Uf> listar() {
		
		return this.ufsRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Uf buscaUf(@PathVariable Long id) {
		return this.ufsRepository.findOne(id);
	}
	
}
