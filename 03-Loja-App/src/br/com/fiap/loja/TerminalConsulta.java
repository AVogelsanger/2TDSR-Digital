package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.singleton.ConfiguracaoSingleton;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		Calendar dataAtual = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		do {

			String nomeLoja = ConfiguracaoSingleton.getInstance().getProperty("nome");

			System.out.println(nomeLoja + " - " + sdf.format(dataAtual.getTime()));

			System.out.println("Informe o codigo do produto: ");
			int codigoProduto = scan.nextInt();

			
			EstoqueBO estoque = new EstoqueBO();
			
			estoque.consultarProduto(codigoProduto);
			
			System.out.println("Sair? S/N: ");


		}while (scan.next().equalsIgnoreCase("N"));

		System.out.println("Obrigado!");

		scan.close();
	} 
}
