package br.com.fiap.revisao.bean;

//Classe abstrata -> não pode ser instanciada
//PODE conter métodos abstratos
public abstract class Pessoa {

	private String nome;
	
	public abstract void falar();//met abstrato, sem corpo

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
