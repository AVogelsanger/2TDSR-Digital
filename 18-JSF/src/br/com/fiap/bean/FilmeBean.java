package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.FilmeBO;
import br.com.fiap.to.Filme;

@ManagedBean
public class FilmeBean {

	private Filme filme;
	private FilmeBO bo;
	
	@PostConstruct
	public void iniciar() {
		bo = new FilmeBO();
		filme = new Filme();
	}
	
	public List<Filme> listar() {
		return bo.listar();
	}
	
	public void cadastrar() {
		bo.cadastrar(filme);
		FacesMessage msg = new FacesMessage("Cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println(filme.getTitulo() + " cadastrado com sucesso!");
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
