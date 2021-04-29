package br.uniamerica.unijobs.controller;

import br.uniamerica.unijobs.dao.TipoProdutoDao;
import br.uniamerica.unijobs.model.TipoProduto;
import com.google.gson.Gson;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@PermitAll
@Path("/tipos_produtos")
public class TipoProdutoController {
    private List<TipoProduto> tipos_produtos;
    {
        TipoProdutoDao tipoProdutoDao = new TipoProdutoDao();
        try {
            tipos_produtos = tipoProdutoDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public Response tipos_produtos(){
        return Response.ok(new Gson().toJson(tipos_produtos)).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response show(@PathParam("id") Integer id) {
        TipoProdutoDao tipoProdutoDao = new TipoProdutoDao();
        return Response.ok(new Gson().toJson(tipoProdutoDao.find(id))).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(TipoProduto tipoProduto){
        TipoProdutoDao tipoProdutodao = new TipoProdutoDao();
        TipoProduto produto_criado = tipoProdutodao.create(tipoProduto);
        return Response.ok(new Gson().toJson(produto_criado)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") Integer id, TipoProduto tipoProduto){
        TipoProdutoDao tipoProdutodao = new TipoProdutoDao();
        TipoProduto produto_atualizado = tipoProdutodao.update(tipoProduto);
        return Response.ok(new Gson().toJson(produto_atualizado)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") Integer id){
        TipoProdutoDao tipoProdutodao = new TipoProdutoDao();
        String produto_deletado = tipoProdutodao.delete(id);
        return Response.ok(new Gson().toJson(produto_deletado)).build();
    }
}
