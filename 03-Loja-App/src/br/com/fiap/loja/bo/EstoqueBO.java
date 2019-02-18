package br.com.fiap.loja.bo;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	
	ProdutoTO prod = new ProdutoTO(401, 10, 50, "camisa branca");

	public ProdutoTO consultarProduto(int codigoProduto) {
	
		switch (codigoProduto) {
		case 401:
			System.out.println(" Code:" + prod.getCodigo() + "\n Pre�o: R$" + prod.getPreco() +
								"\n Quantidade: " + prod.getQuantidade() + "\n Descri��o: " + prod.getDescricao());
			break;
		case 402:
			System.out.println(" Code:" + prod.getCodigo() + "\n Pre�o: R$" + prod.getPreco() +
					"\n Quantidade: " + prod.getQuantidade() + "\n Descri��o: " + prod.getDescricao());
			break;
		case 403:
			System.out.println(" Code:" + prod.getCodigo() + "\n Pre�o: R$" + prod.getPreco() +
					"\n Quantidade: " + prod.getQuantidade() + "\n Descri��o: " + prod.getDescricao());
			break;	
		default:
			System.out.println("Produto n�o encontrado!");
			break;
		}
		return prod;
		
	}
}
