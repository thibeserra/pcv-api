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

import br.com.pcv.domain.Contato;
import br.com.pcv.services.ContatosService;


@RestController
@RequestMapping("/contatos")
public class ContatoResources {

	@Autowired
	private ContatosService contatosService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Contato>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.contatosService.listar());
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> buscarContato(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.contatosService.buscar(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Contato contato) {
		contato = this.contatosService.salvar(contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contato.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		this.contatosService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Contato contato, @PathVariable Long id) {
		contato.setId(id);
		this.contatosService.atualizar(contato);
		
		return ResponseEntity.noContent().build();
	}
	
}
