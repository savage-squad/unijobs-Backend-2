package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    //pega conexao do banco de dados por um metodo estatico da classe ConexaoDao
    private Connection connection;
    public ProdutoDao(){
        this.connection = ConnectionFactory.getConnection();
    }

//    public List<Produto> findAll() throws SQLException {
//        String sql = "SELECT * FROM produtos";
//        PreparedStatement stmt = connection.prepareStatement(sql);
//        ResultSet rs = stmt.executeQuery();
//
//        // declarando e instanciando uma lista de  produtos
//        List<Produto> Produtos = new ArrayList<>();
//
//        while(rs.next()){
//            Produtos.add(new Produto(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
//        }
//
//        rs.close();
//        stmt.close();
//        return Produtos;
//    }

//    public Produto find(Integer id){
//        String sql = "SELECT * FROM produtos WHERE id_Produto = ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            Produto Produto = new Produto();
//            if(rs.next()){
//                Produto.setId(rs.getInt(1));
//                Produto.setNome(rs.getString(2));
//                Produto.setDescricao(rs.getString(3));
//            }
//            return Produto;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Produto create(Produto Produto){
//        String sql = "INSERT INTO produtos (nome, descricao) VALUES (?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // declara pro statement que ele tem de retornar as chaves auto geradas
//
//            stmt.setString(1,Produto.getNome());
//            stmt.setString(2,Produto.getDescricao());
//
//            stmt.executeUpdate();
//
//            ResultSet ProdutoGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas
//
//            if(ProdutoGerado.next()){
//                Integer idProduto = ProdutoGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
//                Produto.setId(idProduto);
//            }
//
//            stmt.close();
//            return Produto;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public Produto update(Produto Produto){
//        String sql = "UPDATE produtos set nome=?, descricao=? where id_Produto=?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//            stmt.setString(1,Produto.getNome());
//            stmt.setString(2,Produto.getDescricao());
//            stmt.setInt(3,Produto.getId());
//
//            stmt.executeUpdate();
//
//            ResultSet ProdutoGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas
//
//            if(ProdutoGerado.next()){
//                Integer idProduto = ProdutoGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
//                Produto.setId(idProduto);
//            }
//
//            stmt.close();
//            return Produto;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public String delete(Integer id){
//        String sql = "DELETE FROM produtos WHERE id_Produto = ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//
//            stmt.setInt(1, id);
//
//            stmt.execute();
//            stmt.close();
//            return "Produto: " + id + "Deletado.";
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
