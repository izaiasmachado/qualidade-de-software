package negocio;

public class Cliente {
	private int id;
	private String nome;
	private boolean ativo = true;

	public Cliente(int id, String nome) {
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
	
	protected boolean isAtivo() {
		return ativo;
	}

	protected void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
