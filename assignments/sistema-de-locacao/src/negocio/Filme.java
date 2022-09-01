package negocio;

import java.util.Objects;

public class Filme {
	protected int id;
	protected String nome;
	protected double valor;
	protected Genero genero;
	
	public Filme(int id) {
		this.id = id;
	}
	
	public Filme(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public Filme(int id, String nome, Genero genero, double valor) {
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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
