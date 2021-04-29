package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.TipoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoProdutoDao {

    //pega conexao do banco de dados por um metodo estatico da classe ConexaoDao
    private Connection connection;
    public TipoProdutoDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public List<TipoProduto> findAll() throws SQLException {
        String sql = "SELECT * FROM tipos_produto";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        // declarando e instanciando uma lista de tipos produtos
        List<TipoProduto> tiposProdutos = new ArrayList<>();

        while(rs.next()){
            tiposProdutos.add(new TipoProduto(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        rs.close();
        stmt.close();
        return tiposProdutos;
    }

    public TipoProduto find(Integer id){
        String sql = "SELECT * FROM tipos_produto WHERE id_tipoProduto = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            TipoProduto tipoProduto = new TipoProduto();
            if(rs.next()){
                tipoProduto.setId(rs.getInt(1));
                tipoProduto.setNome(rs.getString(2));
                tipoProduto.setDescricao(rs.getString(3));
            }
            return tipoProduto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoProduto create(TipoProduto tipoProduto){
        String sql = "INSERT INTO tipos_produto (nome, descricao) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // declara pro statement que ele tem de retornar as chaves auto geradas

            stmt.setString(1,tipoProduto.getNome());
            stmt.setString(2,tipoProduto.getDescricao());

            stmt.executeUpdate();

            ResultSet tipoProdutoGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas

            if(tipoProdutoGerado.next()){
                Integer idTipoProduto = tipoProdutoGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
                tipoProduto.setId(idTipoProduto);
            }

            stmt.close();
            return tipoProduto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoProduto update(TipoProduto tipoProduto){
        String sql = "UPDATE tipos_produto set nome=?, descricao=? where id_tipoProduto=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,tipoProduto.getNome());
            stmt.setString(2,tipoProduto.getDescricao());
            stmt.setInt(3,tipoProduto.getId());

            stmt.executeUpdate();

            ResultSet tipoProdutoGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas

            if(tipoProdutoGerado.next()){
                Integer idTipoProduto = tipoProdutoGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
                tipoProduto.setId(idTipoProduto);
            }

            stmt.close();
            return tipoProduto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String delete(Integer id){
        String sql = "DELETE FROM tipos_produto WHERE id_tipoProduto = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            return "Produto: " +id+ "Deletado.";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
