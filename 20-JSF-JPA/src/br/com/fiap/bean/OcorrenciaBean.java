package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.OcorrenciaDAO;
import br.com.fiap.dao.impl.OcorrenciaDAOImpl;
import br.com.fiap.entity.Ocorrencia;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@RequestScoped
public class OcorrenciaBean implements Serializable{

	private Ocorrencia ocorrencia;
	private OcorrenciaDAO dao;
	
	@PostConstruct
	public void init() {
		ocorrencia = new Ocorrencia();
		ocorrencia.setData(Calendar.getInstance());
		dao = new OcorrenciaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	/*validar data - metodo recriado no pacote validator na classe DataFuturaValidator
	public void validaData(FacesContext context, UIComponent component, Object value)throws ValidatorException {
		Date data = (Date) value;
		
		if (data.after(new Date())) {
			throw new ValidatorException(new FacesMessage("Data inválida!"));
		}
	}*/
	
	
	public String excluir(int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
			adicionarMensagem("Cadastro removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lista-ocorrencia?faces-redirect=true";
	}
	
	
	public List<Ocorrencia> listar() {
		return dao.listar();
	}
	
	public String cadastrar() {
		
		try {
			if (ocorrencia.getCodigo() == 0) {
				dao.cadastrar(ocorrencia);
				adicionarMensagem("Cadastrado com sucesso!");
			}else {
				dao.alterar(ocorrencia);
				adicionarMensagem("Atualizado com sucesso!");
			}
			dao.commit();
			return "listar-ocorrencia?faces-redirect=true";
		} catch (CommitException e) {
			e.printStackTrace();
			adicionarMensagem("Erro...");
			return "ocorrencia";
		}
	}
	
	public void adicionarMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
}
