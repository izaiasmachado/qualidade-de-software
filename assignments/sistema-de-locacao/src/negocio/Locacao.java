package negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		GeneroFactory factory = GeneroFactory.getInstance();

		GeneroEnum generoEnum = filme.getGenero();
		Genero genero = factory.getGenero(generoEnum);
		
		double desconto = genero.getDesconto();
		return (1 - desconto) * valor;
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
	
	protected String getDataLocacao() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String stringDate = dateFormat.format(getDate());
		return stringDate;
	}
	
	
	protected String getHoraLocacao() {
		DateFormat hourFormat = new SimpleDateFormat("hh:mm:ss");  
		String stringDate = hourFormat.format(getDate());
		return stringDate;		
	}
	
	private void setCurrentDate() {
		setDate(new Date());
	}
}
