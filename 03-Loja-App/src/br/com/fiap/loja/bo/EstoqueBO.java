package br.com.fiap.loja.bo;

import br.com.fiap.loja.exception.ProdutoNaoEncontradoException;
import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	
	//ProdutoTO prod = new ProdutoTO(401, 10, 50, "camisa branca");

	public ProdutoTO consultarProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
	
		ProdutoTO prod;
		
		switch (codigoProduto) {
		
		case 401:
			prod = new ProdutoTO(401, 10, 100, "camisa branca");
			break;
		case 402:
			prod = new ProdutoTO(402, 20, 50, "camisa azul");
			break;
		case 403:
			prod = new ProdutoTO(403, 30, 20, "camisa rosa");
			break;	
		default:
			throw new ProdutoNaoEncontradoException();
		}
		return prod;
		
	}
}
