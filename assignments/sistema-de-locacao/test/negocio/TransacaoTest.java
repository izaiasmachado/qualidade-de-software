package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransacaoTest {
	Transacao transacao;
	Filme filme;
	Cliente cliente, cliente2;
	Locacao locacao, locacao2; 
	
	@Before
	public void setUp() throws Exception {
		transacao = Transacao.getInstance();
		filme = new Filme(1, "JavaScript e Java - A Batalha Final", Genero.COMEDIA, 2000.00);

		cliente = new Cliente(1, "Izaias");
		cliente2 = new Cliente(2, "Pedro");
		
		locacao = new Locacao();
		locacao2 = new Locacao();		
	
		locacao.alugar(cliente, filme, 20.00);
		locacao2.alugar(cliente2, filme, 20.00);

		transacao.locacoes.add(locacao);
		transacao.locacoes.add(locacao2);
	}

	@After
	public void tearDown() throws Exception {
		transacao.locacoes.clear();
	}

	@Test
	public void testGetInstance() {
		Transacao transacao2 = Transacao.getInstance();
		assertEquals(transacao, transacao2);
	}

	@Test
	public void testGetValorLocacaoTotal() {
		double valorLocacaoTotal = transacao.getValorLocacaoTotal();
		assertEquals(40.00, valorLocacaoTotal, 0.01);
	}

	@Test
	public void testGetLucroFilme() {		
		Filme filmeAuxiliar = new Filme(filme.getId());
		double lucroFilme = transacao.getLucroFilme(filmeAuxiliar);
		assertEquals(2, lucroFilme, 0.01);
	}

}
