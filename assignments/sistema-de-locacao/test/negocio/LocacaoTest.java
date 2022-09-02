package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LocacaoTest {
	Cliente cliente;
	Filme filme;
	Locacao locacao;
	double valor;
	
	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente(1, "Izaias");
		filme = new Filme(1, "JavaLand", Genero.DRAMA, 1000.00);
		locacao = new Locacao();
		valor = 20.00;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAlugarClienteFilme() throws Exception {
		locacao.alugar(cliente, filme);			
		assertEquals(locacao.getFilme(), filme);
		assertEquals(locacao.getCliente(), cliente);
		assertEquals(locacao.getValor(), 0, 0.01);
	}
	
	@Test
	public void testAlugarClienteInativoFilme() throws Exception {
		cliente.setAtivo(false);
		exception.expect(Exception.class);
		
		locacao.alugar(cliente, filme);
		assertEquals(locacao.getFilme(), null);
		assertEquals(locacao.getCliente(), null);
		assertEquals(locacao.getValor(), 0, 0.01);
	}

	@Test
	public void testAlugarClienteFilmeDouble() throws Exception {
		locacao.alugar(cliente, filme, valor);			
		assertEquals(locacao.getFilme(), filme);
		assertEquals(locacao.getCliente(), cliente);
		assertEquals(locacao.getValor(), valor, 0.01);
	}
	
	@Test
	public void testAlugarClienteInativoFilmeDouble() throws Exception {
		cliente.setAtivo(false);
		exception.expect(Exception.class);
		
		locacao.alugar(cliente, filme, valor);
		assertEquals(locacao.getFilme(), filme);
		assertEquals(locacao.getCliente(), cliente);
		assertEquals(locacao.getValor(), valor, 0.01);
	}
}