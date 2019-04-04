package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String usuario;
	private String senha;
	private String mensagem;
	
	public void entrar() {
		if (usuario.equals("Fiap") && senha.equals("Fiap2019") ) {
			System.out.println("Acesso realizado com sucesso");
			setMensagem("Logado");
		}else {
			System.out.println("Acesso negado!");
			setMensagem("Usuáio e/ou senha inválidos."); 
		}
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
