package br.com.fiap.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.EmpresaTO;

@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable{

	private EmpresaTO empresa;
	private EmpresaRepository rep;

	@PostConstruct
	public void init() {
		empresa = new EmpresaTO();
		rep = new EmpresaRepository();
	}


	public void excluir(int codigo) {
		try {
			rep.remover(codigo);
		} catch (ResponseException e) {
			e.printStackTrace();
		}
	}

	private void exibirMessagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<EmpresaTO> listar(){

		try {
			return rep.listar();
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void cadastrar() {
		try {
			if (empresa.getCodigo() == 0) {
				rep.cadastrar(empresa);
				exibirMessagem("Cadastrado!");
			}else {
				rep.atualizar(empresa);
				exibirMessagem("Atualizado!");
			}

		} catch (ResponseException e) {
			e.printStackTrace();
			exibirMessagem("erro... ");
		}

	}


	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

}
