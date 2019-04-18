package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.to.EmpresaTO;

public class EmpresaRepository {
	
	private static final String URL = "http://localhost:8080/12-WS-Restful/rest/empresa";
	private Client client = Client.create();
	
	
	public void remover(int codigo) throws ResponseException {
		WebResource resource = client.resource(URL).path(Integer.toString(codigo));
		
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if (resp.getStatus() != 204) {
			throw new ResponseException();
		}
	}
	
	
	public void atualizar(EmpresaTO e) throws ResponseException {
		WebResource resource = client.resource(URL).path(Integer.toString(e.getCodigo())); 
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, e);
		
		if (resp.getStatus() != 200) {
			throw new ResponseException();
		}
		
	}
	
	
	public void cadastrar(EmpresaTO e) throws ResponseException {
		WebResource resource = client.resource(URL); 
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, e);
		
		if (resp.getStatus() != 201) {
			throw new ResponseException();
		}
	}
	
	
	public EmpresaTO pesquisar(int codigo)throws ResponseException{
		//Client client = Client.create();
		WebResource resource = client.resource(URL).path(Integer.toString(codigo));
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (resp.getStatus() != 200) {
			throw new ResponseException();
		}

		return resp.getEntity(EmpresaTO.class);
	}
	 

	public List<EmpresaTO> listar() throws ResponseException{
		//Client client = Client.create();
		WebResource resource = client.resource(URL);
		
		//Chamar o webservice
	    ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	    
	    //valida se deu certo
	    if (resp.getStatus() != 200) {
			throw new ResponseException();
		}
	    
	    //Recuperar as empresas do webservice
	    EmpresaTO[] vetor = resp.getEntity(EmpresaTO[].class);
	    return Arrays.asList(vetor); // transforma um vetor em lista
	}
}
