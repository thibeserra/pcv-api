package br.com.pcv;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pcv.repository.UfsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UfsRepositoryTest {

	@Autowired
	private UfsRepository ufsRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void findAll() {
		Assert.assertTrue(this.ufsRepository.findAll() != null);
	}
	
	@Test
	public void FindOne() {
		Assert.assertTrue(this.ufsRepository.findOne(1L) != null);
	}
}
