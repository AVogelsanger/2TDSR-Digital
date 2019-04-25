package br.com.fiap.to;

public class EmpresaTO {

	private int codigo;
	private String nome;
	private double faturamento;
	private boolean multinacional;
	
	public EmpresaTO() {
		super();
	}

	public EmpresaTO(int codigo, String nome, double faturamento, boolean multinacional) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.faturamento = faturamento;
		this.multinacional = multinacional;
	}
	


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getFaturamento() {
		return faturamento;
	}


	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}


	public boolean isMultinacional() {
		return multinacional;
	}


	public void setMultinacional(boolean multinacional) {
		this.multinacional = multinacional;
	}
	
}
