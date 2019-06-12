package Venda;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Logistica.Catalogo;
import Logistica.Produto;

public class Principal {

	
	public static void main (String[] args) {
		(new Principal()).run();
	}
	
	
	public void run() {
		loopOpMenu();	    
	}
	
	
	public void loopOpMenu() {
		 int opcao1; 
		 Menu.exibirOpcoes();
		 
		do {
		    opcao1 = new Scanner(System.in).nextInt();
		    
		    if (opcao1 == 1){
		    	Menu.submenuOp1();
		    	loopOpMenu2();
		    	
		    } else if (opcao1 == 2) {
		    	System.out.println("Agradecemos pela preferência! Até logo!\n\n");
		    	System.exit(0);
		    	
		    } else {
		    	System.out.println("Digite uma opção válida! \n\n");
		    	
		    }
		    
		} while(opcao1 != 2);
	
	}
	
	
	public void loopOpMenu2() {
		Registro registro = new Registro();
		
		int v_cliente, opcao2;
		float troco;
		Scanner scanner = new Scanner(System.in);
		
		do {
			opcao2 = scanner.nextInt();
				
			if(opcao2 == 1) {
				InserirItem(registro);
			
			} else if(opcao2 == 2) {
				System.out.println("Obrigada pela preferência! Volte sempre!\n\n");
				limpar();
				Menu.exibirOpcoes();
				break;
				
		 		  
		 	}else if(opcao2 == 3) {
		 		  float total = registro.calculoTotal();
		 		  System.out.println("TOTAL = R$"+ total +"\n\n");
		 		  
		 		  System.out.println("VALOR DO CLIENTE = R$");
		 		  v_cliente = scanner.nextInt();
		 		  
		 		 Pagamento pagamento = new Pagamento(total);
		 		 
		 		  if(v_cliente < total)
		 			 System.out.println("Falta uns acréscimos para completar o pagamento \n\n");
		 		  else
		 			  if( pagamento.calculo(v_cliente) != -1) {
		 		  		System.out.println("TROCO: R$"+ pagamento.calculo(v_cliente)+ "\n\n");
		 		  		System.out.println(registro.toString() + "\n\n");
		 			  }
		 	}else 
		 		   System.out.println("Digite uma opção válida!\n\n");
			
			Menu.submenuOp1();
		} while(opcao2 != 2);
		
	}
	
	
	public void limpar() {
		
		for(int i = 0; i < 400; i++)
		{
			System.out.print("\r\n");
		}
	}
	
	
	public void InserirItem(Registro registro) {
		Catalogo catalogo = new Catalogo();
		Scanner scanner = new Scanner(System.in);
		
		int quantidade;

		do {
			  System.out.println(catalogo.toString() + "\n\n");
			  
			  System.out.println("\n\nCód. do produto: ");
			  Produto produto = catalogo.getProduto(scanner.nextInt()); 
	 		  System.out.println("Quantidade: ");
	 		  	quantidade = scanner.nextInt();
	 		  
	 		  if (produto != null) {
	 			 
	 			  if (catalogo.verificarQuantidade(produto, quantidade)) {
	 				  catalogo.setCompras(produto, quantidade);
	 				  registro.addProduto(produto, quantidade);
	 			  } else 
	 				 System.out.println("Quantidade não disponível no estoque para esse produto.\n\n");
	 			  
	 		  } else
	 			 System.out.println("Produto não encontrado com o código inserido. Tente novamente. \n\n");
//	 		  limpar();
		} while(quantidade != 0);
	}

}
