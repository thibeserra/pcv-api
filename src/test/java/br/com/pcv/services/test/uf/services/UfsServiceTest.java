package br.com.pcv.services.test.uf.services;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pcv.domain.Uf;
import br.com.pcv.services.UfsService;
import br.com.pcv.services.exceptions.UfNaoEncontradaException;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@ContextConfiguration(classes = {UfsService.class})
//@EnableAutoConfiguration
public class UfsServiceTest {

	@Autowired(required = true)
	private UfsService ufsService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void listarNaoENulo() {
		for (Uf u : ufsService.listar()) {
			System.out.println("UF: " + u.getDescricao());
		}
		Assert.assertNotNull(this.ufsService.listar());
	}
	
	@Test
	public void BuscarNaoENulo() {
		Assert.assertNotNull(this.ufsService.buscar(1L));
	}
	
	@Test
	public void BuscarGerarUFNaoEncontradaException() {
		thrown.expect(UfNaoEncontradaException.class);
		this.ufsService.buscar(1000L);
	}
}
