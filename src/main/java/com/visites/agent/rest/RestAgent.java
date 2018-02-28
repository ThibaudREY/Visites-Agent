package com.visites.agent.rest;

import com.visites.agent.repository.AgentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("agent")
public class RestAgent {


    @POST
    @Produces({MediaType.TEXT_PLAIN})
    public Response Create(
            @QueryParam("first_name") String first_name,
            @QueryParam("last_name") String last_name,
            @QueryParam("telephone") String telephone
    ) {

        AgentRepository ir = new AgentRepository();

        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(telephone);

        return Response.status(200).entity(ir.Create(first_name, last_name, telephone)).build();

    }


    @DELETE
    @Path("/{id}")
    public Response Delete(@PathParam("id") int id) {

        AgentRepository ir = new AgentRepository();

        ir.Delete(id);

        return Response.status(200).entity("Acknoleged: true").build();

    }

    @PUT
    @Path("/{id}")
    public Response Update(
            @QueryParam("id") int id,
            @QueryParam("first_name") String first_name,
            @QueryParam("last_name") String last_name,
            @QueryParam("telephone") String telephone
    ) {

        AgentRepository ir = new AgentRepository();

        ir.Update(id, first_name, last_name, telephone);

        return Response.status(200).entity("Acknoleged: true").build();

    }

    @GET
    @Path("/{id}")
    public Response Read(@PathParam("id") int id) {

        AgentRepository ir = new AgentRepository();

        return Response.status(200).entity(ir.Read(id)).build();

    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response ReadAll() {

        AgentRepository ir = new AgentRepository();

        return Response
                .status(200).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(ir.All()).build();

    }

}
