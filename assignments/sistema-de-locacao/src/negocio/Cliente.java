package negocio;

import java.util.HashSet;
import java.util.Set;

public class Cliente {
	private int id;
	private String nome;
	private boolean ativo = true;
	public Set<Filme> listaFilmesFavoritos;
	
	public Cliente(int id, String nome) {
		this.listaFilmesFavoritos = new HashSet<Filme>();
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
