package sistema_de_locacao_maeven.negocio;

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
		double desconto = -0.01;	
		genero.setDesconto(desconto);
		assertTrue(genero.getDesconto() != desconto);
	}
	
	@Test
	public void testSetDescontoAcima() {
		double desconto = 1.01;
		genero.setDesconto(desconto);
		assertTrue(genero.getDesconto() != desconto);
	}
	
	@Test
	public void testSetDescontoValido() {		
		genero.setDesconto(1.00);
		assertEquals(genero.getDesconto(), 1.00, 0.01);
		
		genero.setDesconto(0.00);
		assertEquals(genero.getDesconto(), 0.00, 0.01);
		
		genero.setDesconto(0.99);
		assertEquals(genero.getDesconto(), 0.99, 0.01);
		
		genero.setDesconto(0.01);
		assertEquals(genero.getDesconto(), 0.01, 0.01);
	}
}
