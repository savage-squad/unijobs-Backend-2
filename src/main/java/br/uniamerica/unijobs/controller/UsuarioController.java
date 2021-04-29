package br.uniamerica.unijobs.controller;

import br.uniamerica.unijobs.dao.UsuarioDao;
import br.uniamerica.unijobs.model.*;
import com.google.gson.Gson;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@PermitAll
@Path("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios;
    {
        UsuarioDao usuarioDao = new UsuarioDao();
        try {
            usuarios = usuarioDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public Response usuarios(){
        return Response.ok(new Gson().toJson(usuarios)).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response show(@PathParam("id") Integer id) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return Response.ok(new Gson().toJson(usuarioDao.find(id))).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario_criado = usuarioDao.create(usuario);
        return Response.ok(new Gson().toJson(usuario_criado)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") Integer id, Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario_atualizado = usuarioDao.update(usuario);
        return Response.ok(new Gson().toJson(usuario_atualizado)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") Integer id){
        UsuarioDao usuarioDao = new UsuarioDao();
        String usuario_deletado = usuarioDao.delete(id);
        return Response.ok(new Gson().toJson(usuario_deletado)).build();
    }
}
