package br.com.fiap.to;

public class Filme {

	private String titulo;
	private int classificacao;
	private String duracao;
	private int estudio;
	private boolean nacional;
	
	public Filme() {
		super();
	}

	public Filme(String titulo, int classificacao, String duracao, int estudio, boolean nacional) {
		super();
		this.titulo = titulo;
		this.classificacao = classificacao;
		this.duracao = duracao;
		this.estudio = estudio;
		this.nacional = nacional;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getEstudio() {
		return estudio;
	}

	public void setEstudio(int estudio) {
		this.estudio = estudio;
	}

	public boolean isNacional() {
		return nacional;
	}

	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	
	
}
