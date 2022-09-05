package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ListaFavoritosTest {
	Cliente cliente;
	ListaFavoritos listaFavoritos;
	Filme filme;
	Filme filme1;
	Filme filme2;
	Transacao transacao = Transacao.getInstance();

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		filme = new Filme(0);
		filme1 = new Filme(1);
		filme2 = new Filme(2);
		
		cliente = new Cliente(1, "Izaias");
		listaFavoritos = new ListaFavoritos(cliente);
	}

	@After
	public void tearDown() throws Exception {
		transacao.locacoes.clear();
	}

	@Test
	public void testListaFavoritosCliente() {
		assertEquals(cliente, listaFavoritos.getCliente());
	}

	@Test
	public void testAdiciona() throws Exception {
		listaFavoritos.adiciona(filme);
	}
	
	@Test
	public void testAdicionaFilmeDuplicado() throws Exception {
		exception.expect(Exception.class);
		listaFavoritos.adiciona(filme);
		listaFavoritos.adiciona(filme);
	}

	@Test
	public void testBusca() throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.adiciona(filme1);
		listaFavoritos.adiciona(filme2);

		Filme filmeBuscado = listaFavoritos.busca(filme1.getId());
		assertEquals(filme1, filmeBuscado);
	}

	@Test
	public void testBuscaInvalida() throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.adiciona(filme1);

		Filme filmeBuscado = listaFavoritos.busca(filme2.getId());
		assertEquals(null, filmeBuscado);
	}

	@Test
	public void testRemove() throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.adiciona(filme1);
		listaFavoritos.adiciona(filme2);
		
		Filme filmeRemovido = listaFavoritos.remove(filme1.getId());
		assertEquals(filme1, filmeRemovido);
	}
	
	@Test
	public void testRemoveFilmeInvalido() throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.adiciona(filme1);
		
		Filme filmeRemovido = listaFavoritos.remove(filme2.getId());
		assertEquals(null, filmeRemovido);
	}

	@Test
	public void testAlugaInt() throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.aluga(filme.getId());
		
		Locacao locacao = transacao.locacoes.get(0);
		Filme filmeLocacao = locacao.getFilme();
		assertEquals(filme, filmeLocacao);
		assertEquals(transacao.locacoes.size(), 1);
	}
	
	@Test
	public void testAlugaFilme() throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.aluga(filme);
		
		Locacao locacao = transacao.locacoes.get(0);
		Filme filmeLocacao = locacao.getFilme();
		assertEquals(filme, filmeLocacao);
		assertEquals(transacao.locacoes.size(), 1);
	}
	
	@Test
	public void testAlugaInvalido () throws Exception {
		listaFavoritos.adiciona(filme);
		listaFavoritos.aluga(filme1.getId());
		assertEquals(transacao.locacoes.size(), 0);
	}

	
	@Test
	public void testLista() throws Exception {		
		listaFavoritos.adiciona(filme);
		listaFavoritos.adiciona(filme1);
		listaFavoritos.adiciona(filme2);

		ArrayList<Filme> filmesFavoritos = listaFavoritos.lista();
		assertEquals(filme, filmesFavoritos.get(0));
		assertEquals(filme1, filmesFavoritos.get(1));
		assertEquals(filme2, filmesFavoritos.get(2));
	}
	
	@Test
	public void testgetTamanho() throws Exception {
		assertEquals(0, listaFavoritos.getTamanhoLista());

		listaFavoritos.adiciona(filme);
		assertEquals(1, listaFavoritos.getTamanhoLista());
		
		listaFavoritos.adiciona(filme1);
		assertEquals(2, listaFavoritos.getTamanhoLista());
		
		listaFavoritos.adiciona(filme2);
		assertEquals(3, listaFavoritos.getTamanhoLista());
	}
}
