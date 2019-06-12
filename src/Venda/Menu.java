package Venda;

public class Menu {

	
	public static void exibirOpcoes() {
		System.out.println("=======   SISTEMA DE CONTROLE DE VENDAS DE SUPERMERCADO   ===== \n\n"
						   +"	 =============================== \n" 
						   +"	|	1 - Iniciar caixa	|\n"
						   +"	|	2 - Encerrar caixa 	|\n"
						   +"	 ===============================\n");
	}
	
	public static void submenuOp1() {
		System.out.println("\n	 =============================== \n" 
				   +"	|	1 - Incluir itens	|\n"
				   +"	|	  0 - Voltar ao menu	| \n"		
				   +"	|	2 - Encerrar vendas 	|\n"
				   +"	|	3 - Efetuar pagamento 	|\n"
				   +"	 =============================== \n");
	}
	
}
