package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.VendaDAO;
import br.com.fiap.ws.dao.impl.VendaDAOImpl;
import br.com.fiap.ws.entity.Venda;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/venda")
public class VendaResource {

	private VendaDAO dao;

	public VendaResource() {

		dao = new VendaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}


	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo){
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Venda venda, @PathParam("id") int codigo){

		try {
			venda.setId(codigo);
			dao.atualizar(venda);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.ok().build();
	}


	//GET rest/empresa/1
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Venda buscar(@PathParam("id") int codigo) {

		return dao.buscar(codigo);
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Venda venda, @Context UriInfo uriInfo) {


		try {
			dao.cadastrar(venda);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(venda.getId()));

		return Response.created(builder.build()).build();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venda> buscar(){
		return dao.listar();
	}

}
