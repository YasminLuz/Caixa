package Logistica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Catalogo {

	private Map<Produto, Integer> catalogo = new HashMap<Produto, Integer>();

	public Catalogo() {
		criarListaRandomica();	
	}

	public Map<Produto,Integer> getCompras() {
		Map<Produto,Integer> valor = new HashMap<Produto, Integer>();
		
		for (Map.Entry<Produto,Integer> item : this. catalogo.entrySet())  
			valor.put(item.getKey(), item.getValue());
		
		return valor;
	}
	
	public Produto getProduto(int codigo) {
		for (Map.Entry<Produto,Integer> item : catalogo.entrySet())  
			if (item.getKey().getCodigo() == codigo)
			return item.getKey();
		
		return null;
	}

	public void setCompras(Produto p, int quantidade)  {
		for (Iterator it = catalogo.entrySet().iterator(); it.hasNext(); ) { //percorre
			Map.Entry entry = (Map.Entry) it.next();
			  if (p.equals(entry.getKey()))
				 entry.setValue (new Integer (((Integer)entry.getValue()) - quantidade));
			}
	}
	
	public boolean verificarQuantidade(Produto p, int quantidade) {
		for (Map.Entry<Produto,Integer> item : catalogo.entrySet())  
			if(quantidade <= item.getValue() && item.getValue() >= 0 )
				return true;
		
		return false;
	}
	
	public void criarListaRandomica() {
		Random gerador = new Random();

		List<String> nomes_produtos = Arrays.asList("sabão", "feijão", "creme dental", "papel higiênico", "açúcar", "vassoura", "arroz", "biscoito", "café", "fósforo", "carne bovina");
		List<String> marcas_produtos = Arrays.asList("ipê", "tio Jão", "sorriso", "limpa bem", "adoça tudo", "voa poeira", "branquinho", "B", "ativar", "fiat lux", "gado demais");
		float[] valores_produtos = {2,50f, 6f, 1.99f, 4,50f, 3f, 7,80f, 5f, 2.50f, 2.70f, 0.70f};
		int[] quant_produtos = {12, 20, 10, 92, 5, 15, 70, 50, 45, 88};
		
		for(int x = 1; x < 13; x++) {
			String nomesSelect = nomes_produtos.get(gerador.nextInt(nomes_produtos.size()));
			String marcasSelect = marcas_produtos.get(gerador.nextInt(marcas_produtos.size()));
			int valoresSelect = gerador.nextInt(valores_produtos.length);
			int quantSelect = gerador.nextInt(quant_produtos.length);
			
			catalogo.put(new Produto(x, nomesSelect, marcasSelect, valores_produtos[valoresSelect]), quant_produtos[quantSelect]);
		}
	}
	
	
	public String toString() {
	   StringBuffer sb = new StringBuffer();
	   
	    for (Map.Entry<Produto,Integer> item : catalogo.entrySet())  {
	    	sb.append("Cód produto: ");
			sb.append(item.getKey().getCodigo());
			sb.append("\n");
			sb.append("Nome do produto: ");
			sb.append(item.getKey().getNome());
			sb.append("\n");
			sb.append("Quantidade produto: ");
			sb.append(item.getValue());
			sb.append("\n");
			sb.append("Valor produto: R$ ");
			sb.append(item.getKey().getValor());
			sb.append("\n\n");
	    }
		
	    return sb.toString();
	}
	
	
}
