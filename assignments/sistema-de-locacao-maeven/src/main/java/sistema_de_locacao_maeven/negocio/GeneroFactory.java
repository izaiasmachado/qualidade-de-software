package sistema_de_locacao_maeven.negocio;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GeneroFactory {
	private static GeneroFactory instance = new GeneroFactory();
	private Map<GeneroEnum, Genero> mapa = new EnumMap<GeneroEnum, Genero>(GeneroEnum.class);

	private GeneroFactory() {
		List<GeneroEnum> listaGeneros = Arrays.asList(GeneroEnum.values());

		for (GeneroEnum generoEnum : listaGeneros) {
			Genero genero = new Genero(generoEnum);
			mapa.put(generoEnum, genero);
		}
	}
	
	protected static GeneroFactory getInstance() {
		return instance;
	}
	
	protected Genero getGenero(GeneroEnum generoEnum) {
		Genero genero = mapa.get(generoEnum);
		return genero;
	}
}
