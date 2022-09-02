package negocio;

import java.util.Date;

public class Locacao {
	private Cliente cliente;
	private Filme filme;
	private double valor;
	private Date date;
	
	protected void alugar(Cliente cliente, Filme filme) {
		this.cliente = cliente;
		this.filme = filme;
		this.date = new Date();
	}
	
	protected void alugar(Cliente cliente, Filme filme, double valor) {
		this.cliente = cliente;
		this.filme = filme;
		this.valor = valor;
		this.date = new Date();
	}	
	
	protected double getValor() {
		return valor;
	}

	protected void setValor(double valor) {
		this.valor = valor;
	}

	protected Cliente getCliente() {
		return cliente;
	}

	protected Filme getFilme() {
		return filme;
	}

	protected Date getDate() {
		return date;
	}
}
