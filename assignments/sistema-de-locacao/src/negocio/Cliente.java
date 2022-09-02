package negocio;

import java.util.ArrayList;

public class Cliente {
	private int id;
	private String nome;
	private boolean ativo = true;
	public ArrayList<Filme> listaFilmesFavoritos;
	
	public Cliente(int id, String nome) {
		this.listaFilmesFavoritos = new ArrayList<Filme>();
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
