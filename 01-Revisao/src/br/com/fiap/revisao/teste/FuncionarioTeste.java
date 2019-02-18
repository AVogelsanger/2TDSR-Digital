package br.com.fiap.revisao.teste;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Gerente;

public class FuncionarioTeste {

	public static void main(String[] args) {
		
		Funcionario f = new Gerente();
		f.setSalario(900);
		
		
		Gerente g = (Gerente) f; // cast
		
		System.out.println("Funcionario - gerente R$" + f.calcularBonificacao());
		System.out.println(g.calcularBonificacao());
		
		
		String salario = (f.getSalario() > 1000)? "Maior":"Menor"; // operador ternário
		System.out.println(salario);
		
	}

}
