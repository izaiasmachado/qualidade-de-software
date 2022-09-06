package sistema_de_locacao_maeven.negocio;

import java.util.ArrayList;

public class ListaFavoritos {
	private ArrayList<Filme> filmes;
	private Cliente cliente;
	
	public ListaFavoritos(Cliente cliente) {
		filmes = new ArrayList<Filme>();
		this.cliente = cliente;
	}
	
	protected Cliente getCliente() {
		return this.cliente;
	}
	
	public void adiciona(Filme filme) throws Exception {
		int idFilme = filme.getId();
		Filme filmeBuscado = busca(idFilme);
		
		if (filmeBuscado != null) {
			throw new Exception("Filme should be unique in list");

		}
		
		filmes.add(filme);
	}
	
	public Filme busca(int idFilme) {
		for (Filme filme : filmes) {
			if (filme.getId() == idFilme) return filme;
		}
		
		return null;
	}
	
	public ArrayList<Filme> lista() {
		return this.filmes;
	}
	
	public int getTamanhoLista() {
		return this.filmes.size();
	}
	
	public Filme remove(int idFilme) {
		Filme filmeAchado = busca(idFilme);
		if (filmeAchado == null) return null;
		
		filmes.remove(filmeAchado);
		return filmeAchado;
	}
	
	public void aluga(int idFilme) throws Exception {
		Transacao transacao = Transacao.getInstance();
		Locacao locacao = new Locacao();
		Filme filme = busca(idFilme);
		
		if (filme == null) return;
		locacao.alugar(cliente, filme);
		transacao.locacoes.add(locacao);
	}
	
	public void aluga(Filme filme) throws Exception {
		this.aluga(filme.getId());
	}
}
