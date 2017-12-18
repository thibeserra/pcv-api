package br.com.pcv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pcv.domain.Cidade;
import br.com.pcv.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResources {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cidade> listar() {
		return this.cidadeRepository.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Cidade buscarCidade(@PathVariable Long id) {
		return this.cidadeRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Cidade salvar(@RequestBody Cidade cidade) {
		return this.cidadeRepository.save(cidade);	
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Long id) {
		this.cidadeRepository.delete(id);
	}
	
}
