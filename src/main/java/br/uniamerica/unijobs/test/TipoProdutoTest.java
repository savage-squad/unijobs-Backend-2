package br.uniamerica.unijobs.test;

import br.uniamerica.unijobs.dao.TipoProdutoDao;
import br.uniamerica.unijobs.model.TipoProduto;

import java.sql.SQLException;
import java.util.List;

public class TipoProdutoTest {
    public static void main(String[] args) throws SQLException {
        TipoProdutoDao tipoProdutoDao = new TipoProdutoDao();

        TipoProduto gastronomia = new TipoProduto("Gastronomia", "produtos relacionados a culinaria e gastronomia");
        gastronomia = tipoProdutoDao.create(gastronomia);


        System.out.println(gastronomia.toString());

//        TipoProduto roupas = tipoProdutoDao.find(2);
//        System.out.println(roupas);
//        gastronomia.setDescricao("só uns lanches na vdd");
//
//        tipoProdutoDao.update(gastronomia);
//
//        List<TipoProduto> tiposProdutos = tipoProdutoDao.findAll(); //deve retornar uma lista
//
//        for (TipoProduto tipoProduto : tiposProdutos){
//            System.out.println(tipoProduto);
//        }

    }
}
