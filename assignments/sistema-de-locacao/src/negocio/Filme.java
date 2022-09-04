package negocio;

import java.util.Objects;

public class Filme {
	private int id;
	private String nome;
	private double valor;
	private GeneroEnum genero;
	
	public Filme(int id) {
		this.id = id;
	}
	
	public Filme(String nome, GeneroEnum genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public Filme(int id, String nome, GeneroEnum genero, double valor) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero, id, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return genero == other.genero && id == other.id && Objects.equals(nome, other.nome) && Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
}
