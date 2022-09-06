package sistema_de_locacao_maeven.negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmeTest {
	Filme filme;
	int id;
	double valor;
	String nome;
	GeneroEnum genero;
	
	@Before
	public void setUp() throws Exception {
		id = 20;
		nome = "Java";
		valor = 9.99;
		genero = GeneroEnum.ROMANCE;
		filme = new Filme(id);
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
		filme = new Filme(nome, genero);
		
		assertEquals(nome, filme.getNome());
		assertEquals(genero, filme.getGenero());
	}
	
	
	@Test
	public void testFilmeIntStringGeneroDouble() {
		filme = new Filme(id, nome, genero, valor);
		
		assertEquals(id, filme.getId());
		assertEquals(nome, filme.getNome());
		assertEquals(genero, filme.getGenero());
		assertEquals(valor, filme.getValor(), 0.01);
	}
	
	@Test
	public void testSetAndGetValor() {
		filme.setValor(valor);
		assertEquals(valor, filme.getValor(), 0.01);
	}
	
	@Test
	public void testSetAndGetNome() {
		filme.setNome(nome);
		assertEquals(nome, filme.getNome());
	}
	
	@Test
	public void testSetAndGetGenero() {
		filme.setGenero(genero);
		assertEquals(genero, filme.getGenero());
	}
	
	@Test
	public void testHashCode() {
		Filme filmeIgual = filme;
		assertEquals(filme.hashCode(), filmeIgual.hashCode());
	}
	
	@Test
	public void testHashCodeDiferente() {
		Filme filme1 = new Filme(id, nome, genero, valor);
		assertNotEquals(filme.hashCode(), filme1.hashCode());
	}
	
	@Test
	public void testEquals() {
		filme = new Filme(id, nome, genero, valor);
		Filme filme1 = new Filme(id, nome, genero, valor);
		
		assertTrue(filme.equals(filme1));
		assertTrue(filme1.equals(filme));
	}
	
	@Test
	public void testEqualsFalse() {
		filme = new Filme(id, nome, GeneroEnum.DRAMA, valor);
		Filme filme1 = new Filme(id, nome, genero, valor);
		
		assertFalse(filme.equals(filme1));
		assertFalse(filme1.equals(filme));
	
		assertFalse(filme.equals(null));
		assertFalse(filme1.equals(null));
		
		Cliente cliente = new Cliente(1, "Izaias");
		assertFalse(filme.equals(cliente));
	}
}
