package Auxiliar;

public class Endereco {

	private String rua, bairro, cidade, estado, bloco; 
	private int numero, apartamento, cep;

	public Endereco() {
		this.rua = "São Francisco";
		this.bairro = "Novo";
		this.cidade = "Salvador";
		this.estado = "BA";
		this.numero = 0;
		this.cep = 41548723;
	}
	
	public Endereco(String rua, String bairro, String cidade, String estado, int cep, int numero) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.cep = cep;
	}


	public Endereco(String rua, String bairro, String cidade, String estado, int cep, int numero, String bloco, int apartamento) {
		this(rua, bairro, cidade, estado, cep, numero);
		this.bloco = bloco;
		this.apartamento = apartamento;
	}
	
	public String toString() {
		return "Rua "+ this.rua +", numero "+ this.numero + ", bairro " + this.bairro + ", " + this.cidade + ", " +  this.estado;
	}
	
}
