package br.uniamerica.unijobs.controller;

import br.uniamerica.unijobs.dao.TipoUsuarioDao;
import br.uniamerica.unijobs.model.TipoUsuario;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/tipos_usuarios")
public class TipoUsuarioController {
    private List<TipoUsuario> tipos_usuarios;
    {
        TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
        try {
            tipos_usuarios = tipoUsuarioDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public Response tipos_usuarios(){
        return Response.ok(new Gson().toJson(tipos_usuarios)).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response show(@PathParam("id") Integer id) {
        TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
        return Response.ok(new Gson().toJson(tipoUsuarioDao.find(id))).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(TipoUsuario tipoUsuario){
        TipoUsuarioDao tipoUsuariodao = new TipoUsuarioDao();
        TipoUsuario tipoUsuario_criado = tipoUsuariodao.create(tipoUsuario);
        return Response.ok(new Gson().toJson(tipoUsuario_criado)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") Integer id, TipoUsuario tipoUsuario){
        TipoUsuarioDao tipoUsuariodao = new TipoUsuarioDao();
        tipoUsuario.setId(id);
        TipoUsuario tipoUsuario_atualizado = tipoUsuariodao.update(tipoUsuario);
        return Response.ok(new Gson().toJson(tipoUsuario_atualizado)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") Integer id){
        TipoUsuarioDao tipoUsuariodao = new TipoUsuarioDao();
        String tipoUsuario_deletado = tipoUsuariodao.delete(id);
        return Response.ok(new Gson().toJson(tipoUsuario_deletado)).build();
    }
}
