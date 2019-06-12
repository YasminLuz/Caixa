package Venda;

public class Pagamento {
	
	private float total;

	public Pagamento(float total) {
		this.total = total;
	}


	public float calculo(float valor) {
		if( valor >= this.total)
			return valor - this.total;
		return -1;
	}

}
