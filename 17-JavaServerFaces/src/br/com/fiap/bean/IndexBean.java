package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

	private String nome;
	
	public void showName() {
		System.out.println("nome");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
