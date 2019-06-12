package Venda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Auxiliar.Endereco;
import Logistica.Catalogo;
import Logistica.Loja;
import Logistica.Produto;

public class Registro {

	Map<Produto,Integer> compras = new HashMap<Produto, Integer>(); //associa produto (que é único) e quantidade
	private Date hoje = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	
//	public int getQuantidadeTotal() {
//		int soma = 0;
//		for (int quant : this.compras.values()) 
//			soma += quant;
//		
//		return soma;
//	}
	
	public Map<Produto,Integer> getCompras() {
		Map<Produto,Integer> valor = new HashMap<Produto, Integer>();
		for (Map.Entry<Produto,Integer> item : compras.entrySet())  
			valor.put(item.getKey(), item.getValue());
		return valor; 
	}
	
	public void addProduto(Produto produto, int quantidade) {
		compras.put(new Produto(produto.getCodigo(), produto.getNome(), produto.getMarca(), produto.getValor()), quantidade);
	}
	
	public float calculoTotal() {
		float total = 0f;
			for (Map.Entry<Produto,Integer> item : compras.entrySet())  
				total += (item.getValue() * item.getKey().getValor());

		return total;
	}

	@Override
	public String toString() {
		Endereco end = new Endereco();
		Loja loja = new Loja(end, "MERCADÃO X");
		
		String notaFiscal = "Nota Fiscal\n"
							+"SUPERMERCADO " + loja.getNome() + "\n"
							+ loja.getEndereco() + "\n"
							+ df.format(hoje)+ "\n"
							+ "_______________________________________________________________________________\n";
		
		for (Map.Entry<Produto,Integer> item : compras.entrySet())  
			notaFiscal += "\n"+ item.getValue() +" X "+ item.getKey().getNome() + ".................... 	R$" + item.getValue() * item.getKey().getValor() + "\n_________\n";

		notaFiscal += "\t\t\t\t	Total = " + this.calculoTotal();
		return notaFiscal;
	}
	
}
