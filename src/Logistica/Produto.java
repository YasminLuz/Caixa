package Logistica;

public class Produto {
	private int codigo;
	private String nome, marca, categoria, descricao;
	private float valor;
	Produto p;
	
	public Produto(int codigo, String nome, String marca, float valor) {
		this.codigo = codigo;
		this.marca = marca;
		this.nome = nome;
		this.valor = valor;
	}
	
	public Produto(int codigo, String nome, String marca, float valor, String categoria, String descricao) {
		this(codigo, nome, marca, valor);
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public float getValor() {
		return this.valor;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getMarca() {
		return this.marca;
	}

}
