package negocio;

import java.util.ArrayList;

// Classe com implementação do Singleton para armazenar as locações
public final class Transacao {
	protected ArrayList<Locacao> locacoes;
	private static Transacao instance = null;
	
	private Transacao() {
		locacoes = new ArrayList<Locacao>();
	}
	
	public static Transacao getInstance() {
		if (instance == null) {
			instance = new Transacao();
		}
		
		return instance;
	}
	
	public double getValorLocacaoTotal() {
		double total = 0;
		
		for (Locacao locacao : locacoes) {
			double valorAluguelFilme = locacao.getValor();
			total += valorAluguelFilme;
		}
		
		return total;
	}
	
	public double getLucroFilme(Filme filme) {
		double valorArrecadacaoFilme = 0;
		
		for (Locacao locacao : locacoes) {
			Filme filmeLocado = locacao.filme;
			if (filme.id != filmeLocado.id) continue;

			double valorLocacaoFilme = locacao.getValor();
			filme = filmeLocado;
			valorArrecadacaoFilme += valorLocacaoFilme;
		}
		
		double valorCompraFilme = filme.getValor();
		double lucro = (valorArrecadacaoFilme / valorCompraFilme) * 100;
		return lucro;
	}
}

