package br.com.pcv.resources;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;

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

import br.com.pcv.domain.Endereco;
import br.com.pcv.services.EnderecosService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResources {

	@Autowired
	private EnderecosService enderecosService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.enderecosService.listar()); 
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> buscarEndereco(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.enderecosService.buscar(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Endereco endereco) {
		
		endereco = this.enderecosService.salvar(endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		this.enderecosService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Endereco endereco, @PathVariable Long id) {
		endereco.setId(id);
		this.enderecosService.atualizar(endereco);
		
		return ResponseEntity.noContent().build();
	}
	
}
