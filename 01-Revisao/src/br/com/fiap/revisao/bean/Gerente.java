package br.com.fiap.revisao.bean;

public class Gerente extends Funcionario{

	//sobrescrita do método - polimorfismo(Vários comportamentos)
	
	
	@Override
	public double calcularBonificacao() {
		return salario*2;
	}
	
	
	//Usado quando vc imprimir o obj - invocado no sys
	@Override
	public String toString() {
		return "Salário: R$" + salario;
	}
	
}
