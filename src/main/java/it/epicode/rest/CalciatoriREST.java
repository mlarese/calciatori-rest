package it.epicode.rest;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.epicode.model.Calciatore;

@Path("/calciatore")
public class CalciatoriREST {
	private static List<Calciatore> calciatori = new ArrayList<Calciatore>();
	public CalciatoriREST() {
		// TODO Auto-generated constructor stub
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response insert(Calciatore c) {
		calciatori.add(c);
		
		return Response.status(200).entity("Calciatore inserito").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id) {
		try {
			Calciatore c = calciatori.get(id-1);
			return Response.status(200).entity(c).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.status(200).entity(calciatori).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(int id, Calciatore c) {
		try {
			calciatori.add(id-1, c);
			return Response.status(200).entity("Modifica eseguita").build();
		} catch (Exception e) {
			return Response.status(500).entity("Modifica non seguita").build();
		}
	}
	
}
