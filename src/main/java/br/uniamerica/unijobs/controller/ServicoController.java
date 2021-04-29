package br.uniamerica.unijobs.controller;

import br.uniamerica.unijobs.dao.ServicoDao;
import br.uniamerica.unijobs.model.Servico;
import com.google.gson.Gson;
import com.sun.mail.iap.Response;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import java.sql.SQLException;
import java.util.List;

//@PermitAll
//@Path("/servicos")
public class ServicoController {
//    private List<Servico> servicos;
//
//    {
//        ServicoDao servicoDao = new ServicoDao();
//        try {
//            servicos = servicoDao.findAll();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

//    @GET
//    @Path("/{id}")
//    @Produces("application/json")
//    public Response show(@PathParam("id") Integer id) {
//        ServicoDao servicoDao = new ServicoDao();
//        return Response.ok(new Gson().toJson(ServicoDao.find(id))).build();
//    }

//    @PUT
//    @Path("/{id}")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response update(@PathParam("id") Integer id, Servico servico) {
//        ServicoDao servicoDao = new ServicoDao();
//        Servico servico_atualizado = servicoDao.update(servico);
//        return Response.ok(new Gson().toJson(servico_atualizado)).build();
//
//    }
//    @DELETE
//    @Path("/{id}")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public  Response update(@PathParam("id") Integer id){
//        ServicoDao servicoDao = new ServicoDao();
//        String servico_apagado = servicoDao.delete(id);
//        return Response.ok(new Gson().toJson(servico_apagado)).build();
//    }
}