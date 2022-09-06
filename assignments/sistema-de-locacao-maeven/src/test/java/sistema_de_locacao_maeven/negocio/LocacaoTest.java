package sistema_de_locacao_maeven.negocio;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");  
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente(1, "Izaias");
		filme = new Filme(1, "JavaLand", GeneroEnum.DRAMA, 1000.00);
		locacao = new Locacao();
		valor = 20.00;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAlugarClienteFilme() throws Exception {
		Date dataAtual = new Date();
		String dataAtualString = formatoData.format(dataAtual);

		locacao.alugar(cliente, filme);			
		assertEquals(locacao.getFilme(), filme);
		assertEquals(locacao.getCliente(), cliente);
		assertEquals(locacao.getValor(), 0, 0.01);
		assertEquals(dataAtualString, locacao.getDataLocacao());
		
		System.out.println(locacao.getHoraLocacao());
		assertTrue(isValidTime(locacao.getHoraLocacao()));
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
		Date dataAtual = new Date();
		String dataAtualString = formatoData.format(dataAtual);

		locacao.alugar(cliente, filme, valor);			
		assertEquals(locacao.getFilme(), filme);
		assertEquals(locacao.getCliente(), cliente);
		assertEquals(locacao.getValor(), valor, 0.01);
		assertEquals(dataAtualString, locacao.getDataLocacao());
		assertTrue(isValidTime(locacao.getHoraLocacao()));
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
	
	@Test
	public void testGetDesconto() throws Exception {
		Filme filme2 = new Filme(1, "JavaLand", GeneroEnum.ROMANCE, 1000.00);
		Locacao locacao2 = new Locacao();
		
		GeneroFactory factory = GeneroFactory.getInstance();
		Genero romance = factory.getGenero(filme2.getGenero());

		double desconto = 0.15;
		romance.setDesconto(desconto);
				
		double valorComDesconto = locacao2.getDesconto(valor, filme2);
		double porcentagemDesconto = 1 - (valorComDesconto / valor);
		assertEquals(desconto, porcentagemDesconto, 0.01);
	}
	
	
	   public static boolean isValidTime(String time) {
	        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
	 
	        Pattern p = Pattern.compile(regex);
	 
	        if (time == null) {
	            return false;
	        }
	 
	        Matcher m = p.matcher(time);
	        return m.matches();
	    }
}
