package negocio;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GeneroFactory {
	private static GeneroFactory instance = new GeneroFactory();
	Map<GeneroEnum, Genero> mapa = new EnumMap<GeneroEnum, Genero>(GeneroEnum.class);

	private GeneroFactory() {
		List<GeneroEnum> listaGeneros = Arrays.asList(GeneroEnum.values());

		for (GeneroEnum generoEnum : listaGeneros) {
			Genero genero = getGeneroFactory(generoEnum);
			mapa.put(generoEnum, genero);
		}
	}
	
	protected static GeneroFactory getInstance() {
		return instance;
	}
	
	public Genero getGenero(GeneroEnum generoEnum) {
		Genero genero = mapa.get(generoEnum);
		return genero;
	}
	
	private static Genero getGeneroFactory(GeneroEnum genero) {
		switch (genero) {
			case ACAO:
				return new GeneroAcao();
			case COMEDIA:
				return new GeneroComedia();
			case DRAMA:
				return new GeneroDrama();
			case MUSICAL:
				return new GeneroMusical();
			case ROMANCE:
				return new GeneroRomance();
			default:
				return null;
		}
	}
}
