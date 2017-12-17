package br.com.pcv.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pcv.domain.Uf;
import br.com.pcv.repository.UfsRepository;

@RestController
public class UfResources {
	
	@Autowired
	private UfsRepository ufsRepository;
	
	@RequestMapping(value="/livros", method = RequestMethod.GET)
	public List<Uf> listar() {
		
		/*
		Uf sp = new Uf();
		
		sp.setDescricao("São Paulo");
		
		Uf mg = new Uf();
		mg.setId(2L);
		mg.setDescricao("Minas Gerais");
		
		return Arrays.asList(sp, mg);
		*/
		
		return this.ufsRepository.findAll();
	}
	
}
