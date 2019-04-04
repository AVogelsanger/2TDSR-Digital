package br.com.fiap.service;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.VendaTO;

public class VendaService {

	private static final String URL = "http://localhost:8080/15-Exercicio01-WS-Restful-server/rest/venda";
	private Client client = Client.create();


	public void remover(int codigo) {
		WebResource webResource = client.resource("URL");
		
		ClientResponse response = webResource.delete(ClientResponse.class);
		if (response.getStatus() == 204) {
			System.out.println("Sucesso! ");
		}else{
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}


	public void atualizar(VendaTO v) {
		WebResource webResource = client.resource("URL");

		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, v);
		if (response.getStatus() == 200) {
			System.out.println("Sucesso! ");
		}else{
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}


	public void cadastrar(VendaTO v) {
		WebResource webResource = client.resource("URL");

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, v);
		if (response.getStatus() == 201) {
			System.out.println("Sucesso! " + response.getLocation());
		}else{
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}



	public VendaTO pesquisar() {
		WebResource resource = client.resource("URL");

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() == 200){
			VendaTO venda = response.getEntity(VendaTO.class);
			System.out.println(venda.getId());
		}else{
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}
		return response.getEntity(VendaTO.class);
	}



	public List<VendaTO> listar() {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() == 200){

			VendaTO[] vendas = response.getEntity(VendaTO[].class);
			for (VendaTO vendaTO : vendas) {
				System.out.println(vendaTO.getId());
			}
		}else{
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}

		return null;
	}

}
