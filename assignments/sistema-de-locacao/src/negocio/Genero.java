package negocio;

public class Genero {
	double desconto = 0.00;
	
	protected double getDesconto() {
		return this.desconto;
	}
	
	protected void setDesconto(double desconto) {
		if (desconto < 0 || desconto > 1) return;
		this.desconto = desconto;
	}
}
