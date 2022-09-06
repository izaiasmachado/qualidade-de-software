package sistema_de_locacao_maeven.negocio;

public class Genero {
	private GeneroEnum nome;
	private double desconto = 0.00;
	
	protected Genero(GeneroEnum nome) {
		this.nome = nome;
	}
	
	protected GeneroEnum getNome() {
		return this.nome;
	}
	
	protected double getDesconto() {
		return this.desconto;
	}
	
	protected void setDesconto(double desconto) {
		if (desconto < 0 || desconto > 1) return;
		this.desconto = desconto;
	}
}
