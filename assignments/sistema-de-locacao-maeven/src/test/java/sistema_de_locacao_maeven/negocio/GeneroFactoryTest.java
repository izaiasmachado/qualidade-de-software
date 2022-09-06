package sistema_de_locacao_maeven.negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneroFactoryTest {
	GeneroFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = GeneroFactory.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		GeneroFactory newFactory = GeneroFactory.getInstance();
		assertEquals(factory, newFactory);
	}

	@Test
	public void testGetGenero() {
		Genero acao = factory.getGenero(GeneroEnum.ACAO);
		Genero comedia = factory.getGenero(GeneroEnum.COMEDIA);
		Genero drama = factory.getGenero(GeneroEnum.DRAMA);
		Genero musical = factory.getGenero(GeneroEnum.MUSICAL);
		Genero romance = factory.getGenero(GeneroEnum.ROMANCE);
		
		assertEquals(acao.getNome(), GeneroEnum.ACAO);
		assertEquals(comedia.getNome(), GeneroEnum.COMEDIA);
		assertEquals(drama.getNome(), GeneroEnum.DRAMA);
		assertEquals(musical.getNome(), GeneroEnum.MUSICAL);
		assertEquals(romance.getNome(), GeneroEnum.ROMANCE);
	}

}
