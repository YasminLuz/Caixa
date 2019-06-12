package Logistica;

import Auxiliar.Endereco;

public class Loja {

	private Endereco endereco;
	private String nome;
	
	public Loja(Endereco endereco, String nome) {
		this.endereco = endereco;
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getNome() {
		return nome;
	}

	
}
