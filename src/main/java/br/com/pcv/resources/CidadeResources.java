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
import br.com.pcv.services.CidadesService;
import br.com.pcv.services.exceptions.CidadeNaoEncontradaException;

@RestController
@RequestMapping("/cidades")
public class CidadeResources {

	@Autowired
	private CidadesService cidadesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.cidadesService.listar());
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarCidade(@PathVariable Long id) {
		
		Cidade cidade = null;
		try {
			cidade = this.cidadesService.buscar(id);
		} catch(CidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Cidade cidade) {
		
		Cidade c = this.cidadesService.salvar(cidade); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		
		try {
			this.cidadesService.deletar(id);
		} catch(CidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Cidade cidade, @PathVariable("id") Long id) {
		cidade.setId(id);
		
		try {
			this.cidadesService.atualizar(cidade);
		} catch(CidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
}
