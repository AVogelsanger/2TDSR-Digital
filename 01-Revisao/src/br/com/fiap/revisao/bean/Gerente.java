package br.com.fiap.revisao.bean;

public class Gerente extends Funcionario{

	//sobrescrita do m�todo - polimorfismo(V�rios comportamentos)
	
	
	@Override
	public double calcularBonificacao() {
		return salario*2;
	}
	
	
	//Usado quando vc imprimir o obj - invocado no sys
	@Override
	public String toString() {
		return "Sal�rio: R$" + salario;
	}
	
}
