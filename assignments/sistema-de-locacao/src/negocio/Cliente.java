package negocio;

public class Cliente {
	private int id;
	private String nome;
	private boolean ativo = true;
	protected ListaFavoritos listaFavoritos;
	
	public Cliente(int id, String nome) {
		this.listaFavoritos = new ListaFavoritos(this);
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
