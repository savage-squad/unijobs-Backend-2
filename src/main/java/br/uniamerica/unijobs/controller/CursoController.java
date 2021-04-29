package br.uniamerica.unijobs.controller;

import br.uniamerica.unijobs.dao.CursoDao;
import br.uniamerica.unijobs.model.Curso;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/curso")

public class CursoController {
    private List<Curso> cursos;
    {
        CursoDao cursoDao = new CursoDao();
        try {
            cursos = cursoDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @GET
    @Path("oi")
//    @Produces("application/json")
    public Response oi(){
        return Response.ok(new Gson().toJson("Oi")).build();
    }

    @GET
    @Path("listacursos")
    @Produces("application/json")
    public Response listacursos(){
        return Response.ok(new Gson().toJson(cursos)).build();
    }

    @GET
    @Path("{idCurso}")
    @Produces("application/json")
    public Response listacurso(@PathParam("idCurso") Integer idCurso){
        CursoDao cursoDao = new CursoDao();
        return Response.ok(new Gson().toJson(cursoDao.find(idCurso))).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvarcurso(Curso curso){
        CursoDao cursoDao = new CursoDao();
        Curso curso_criado = cursoDao.create(curso);
        if (curso_criado != null)
            return Response.ok(new Gson().toJson(curso_criado)).build();
        return Response.serverError().build();
    }

    @PUT
    @Path("{id_curso}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response atualizacurso(@PathParam("id_curso") Integer id_curso, Curso curso){
        CursoDao cursoDao = new CursoDao();
        Curso curso_atualizado = cursoDao.edit(curso);
        return Response.ok(new Gson().toJson(curso_atualizado)).build();
    }

    @DELETE
    @Path("{id_curso}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deletacurso(@PathParam("id_curso") Integer id_curso){
        CursoDao cursoDao = new CursoDao();
        String curso_deletado = cursoDao.destroy(id_curso);
        return Response.ok(new Gson().toJson(curso_deletado)).build();
    }}
