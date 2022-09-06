package sistema_de_locacao_maeven.negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmeTest {
	Filme filme;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFilmeInt() {
		int id = 1;
		filme = new Filme(id);
		
		assertEquals(id, filme.getId());
	}
	
	@Test
	public void testFilmeStringGenero() {
		String nome = "Java";
		GeneroEnum genero = GeneroEnum.ROMANCE;
		filme = new Filme(nome, genero);
		
		assertEquals(nome, filme.getNome());
		assertEquals(genero, filme.getGenero());
	}
	
	
	@Test
	public void testFilmeIntStringGeneroDouble() {
		int id = 20;
		String nome = "Java";
		GeneroEnum genero = GeneroEnum.ROMANCE;
		double valor = 9.99;
		filme = new Filme(id, nome, genero, valor);
		
		assertEquals(id, filme.getId());
		assertEquals(nome, filme.getNome());
		assertEquals(genero, filme.getGenero());
		assertEquals(valor, filme.getValor(), 0.01);
	}
}
