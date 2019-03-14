package br.com.fiap.loja.view;

import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Informe o c�digo: ");
		int cod = scan.nextInt();
		
		//Instanciar o stub para acessar o web service
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			
			ConsultarProduto produto = new ConsultarProduto();
			produto.setCodigoProduto(cod);
			
			//Chamando o Web Service
			ConsultarProdutoResponse resp = stub.consultarProduto(produto);
			
			//Recuperar o valor retornado pelo web service
			ProdutoTO p = resp.get_return();
			System.out.println("C�digo: " + p.getCodigo() + " / " + p.getDescricao() + " / Valor: R$" + 
								p.getPreco() + " / Quantidade: "+ p.getQuantidade());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
}
