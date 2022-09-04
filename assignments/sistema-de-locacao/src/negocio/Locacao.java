package negocio;

import java.util.Date;

public class Locacao {
	private Cliente cliente;
	private Filme filme;
	private double valor;
	private Date date;
	
	protected void alugar(Cliente cliente, Filme filme) throws Exception {
		this.setCliente(cliente);
		this.setFilme(filme);
		this.setCurrentDate();
	}
	
	protected void alugar(Cliente cliente, Filme filme, double valor) throws Exception {
		this.setCliente(cliente);
		this.setFilme(filme);
		this.setValor(valor);
		this.setCurrentDate();
	}	
	
	protected double getValor() {
		return valor;
	}

	protected void setValor(double valor) {
		double valorComDesconto = getDesconto(valor, filme);
		this.valor = valorComDesconto;
	}
	
	protected double getDesconto(double valor, Filme filme) {
		Genero genero = filme.getGenero();
		
		switch (genero) {
			case ROMANCE:
				return 0.9 * valor;
			default:
				return valor;
		}
	}

	protected Cliente getCliente() {
		return cliente;
	}
	
	private void setCliente(Cliente cliente) throws Exception {
		if (cliente.isAtivo() == false) {
			throw new Exception("Cliente should be active to perform this operation");
		}
		
		this.cliente = cliente;
	}

	protected Filme getFilme() {
		return filme;
	}
	
	private void setFilme(Filme filme) {
		this.filme = filme;
	}

	protected Date getDate() {
		return date;
	}

	private void setDate(Date date) {
		this.date = date;
	}
	
	private void setCurrentDate() {
		setDate(new Date());
	}
}
