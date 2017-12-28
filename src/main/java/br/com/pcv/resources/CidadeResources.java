package br.com.pcv.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<?> buscarCidade(@PathVariable Long id) {
		Cidade cidade = this.cidadeRepository.findOne(id);
		
		if(cidade == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Cidade cidade) {
		
		Cidade c = this.cidadeRepository.save(cidade); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable Long id) {
		this.cidadeRepository.delete(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Cidade cidade, @PathVariable("id") Long id) {
		cidade.setId(id);
		this.cidadeRepository.save(cidade);
	}
	
}
