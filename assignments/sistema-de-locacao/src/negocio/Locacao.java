package negocio;

public class Locacao {
	Cliente cliente;
	Filme filme;
	double valor;
	
	public void alugar(Cliente cliente, Filme filme) {
		this.cliente = cliente;
		this.filme = filme;
	}
	
	public void alugar(Cliente cliente, Filme filme, double valor) {
		this.cliente = cliente;
		this.filme = filme;
		this.valor = valor;
	}	
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Filme getFilme() {
		return filme;
	}
}
