package sistema_de_locacao_maeven.negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente cliente;
	int id;
	String nome;
	
	@Before
	public void setUp() throws Exception {
		id = 1;
		nome = "Izaias";
		cliente = new Cliente(id, nome);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCliente() {
		assertEquals(id, cliente.getId());
		assertEquals(nome, cliente.getNome());
	}
	
	@Test
	public void testSetAndGetId() {
		int novoId = 2;
		cliente.setId(novoId);
		assertEquals(novoId, cliente.getId());
	}
	
	@Test
	public void testSetAndGetNome() {
		String novoNome = "Pedro";
		cliente.setNome(novoNome);
		assertEquals(novoNome, cliente.getNome());
	}
	
	@Test
	public void testSetAndIsAtivo() {
		cliente.setAtivo(true);
		assertTrue(cliente.isAtivo());
		
		cliente.setAtivo(false);
		assertFalse(cliente.isAtivo());
	}
}
