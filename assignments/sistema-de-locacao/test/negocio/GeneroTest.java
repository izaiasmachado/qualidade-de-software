package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneroTest {
	Genero genero;
	
	@Before
	public void setUp() throws Exception {
		genero = new Genero(GeneroEnum.ACAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetDescontoNegativo() {
		genero.setDesconto(-1);
		assertEquals(genero.getDesconto(), 0, 0.01);
	}
	
	@Test
	public void testSetDescontoAcima() {
		genero.setDesconto(1.01);
		assertEquals(genero.getDesconto(), 0, 0.01);
	}
	
	@Test
	public void testSetDescontoValido() {
		genero.setDesconto(0.99);
		assertEquals(genero.getDesconto(), 0.99, 0.01);
		
		genero.setDesconto(0.01);
		assertEquals(genero.getDesconto(), 0.01, 0.01);
	}
}
