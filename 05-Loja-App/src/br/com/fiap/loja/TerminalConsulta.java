package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.exception.ProdutoNaoEncontradoException;
import br.com.fiap.loja.to.ProdutoTO;
import br.com.fiap.singleton.ConfiguracaoSingleton;

public class TerminalConsulta {

	private static Logger Log = Logger.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		Calendar dataAtual = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		EstoqueBO estoque = new EstoqueBO();
		
		
		do {
			
			Log.warn("Inicializando a aplicação!");

			String nomeLoja = ConfiguracaoSingleton.getInstance().getProperty("nome");

			System.out.println(nomeLoja + " - " + sdf.format(dataAtual.getTime()));

			System.out.println("Informe o codigo do produto: ");
			int codigoProduto = scan.nextInt();
			
			try {
				ProdutoTO produto = estoque.consultarProduto(codigoProduto);
				System.out.println("Descrição: " + produto.getDescricao());
				System.out.println("Preço: " + produto.getPreco());
				System.out.println("Quantidade: " + produto.getQuantidade());
			} catch (ProdutoNaoEncontradoException e) {
				System.out.println("Produto não contido no estoque!");
				e.printStackTrace();
			}
			
			System.out.println("Sair? S/N: ");
		}while (scan.next().equalsIgnoreCase("N"));

		System.out.println("Obrigado!");
		
		
		
		Log.warn("Finalizando a aplicação!");

		scan.close();
	} 
}
