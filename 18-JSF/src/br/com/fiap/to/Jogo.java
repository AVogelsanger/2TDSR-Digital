package br.com.fiap.to;

import java.util.List;

public class Jogo {

	private String nome;
	private String genero;
	private List<String> plataforma;
	private boolean demo;
	private int jogadores;
	private float preco;
	
	public Jogo() {
		super();
	}

	public Jogo(String nome, String genero, List<String> plataforma, boolean demo, int jogadores, float preco) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.plataforma = plataforma;
		this.demo = demo;
		this.jogadores = jogadores;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<String> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(List<String> plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isDemo() {
		return demo;
	}

	public void setDemo(boolean demo) {
		this.demo = demo;
	}

	public int getJogadores() {
		return jogadores;
	}

	public void setJogadores(int jogadores) {
		this.jogadores = jogadores;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
