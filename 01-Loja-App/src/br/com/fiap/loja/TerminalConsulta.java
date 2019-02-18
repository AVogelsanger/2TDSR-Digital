package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		Calendar dataAtual = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		do {
		
		System.out.println(" FIAP STORE - " + sdf.format(dataAtual.getTime()));
		
		System.out.println("Informe o codigo do produto: ");
		int codigo = scan.nextInt();
		
		switch (codigo) {
		case 401:
			System.out.println("Camiseta branca");
			break;
		case 402:
			System.out.println("Camiseta azul");
			break;
		case 403:
			System.out.println("Camiseta rosa");
			break;	
		default:
			System.out.println("Produto não encontrado!");
			break;
		}
		
		System.out.println("Sair? S/N: ");
		
		
		}while (scan.next().equalsIgnoreCase("N"));
		
		System.out.println("Obrigado!");
		
		scan.close();
	} 
}
