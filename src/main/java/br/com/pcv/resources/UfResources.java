package br.com.pcv.resources;

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
	
	@RequestMapping(value="/ufs", method = RequestMethod.GET)
	public List<Uf> listar() {
		
		return this.ufsRepository.findAll();
	}
	
}
