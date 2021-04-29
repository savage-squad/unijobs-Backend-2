package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDao {
    //pega conexao do banco de dados por um metodo estatico da classe ConnectionFactory

    private static Connection connection;

    public ServicoDao() {
        this.connection = ConnectionFactory.getConnection();
    }


    public List<Servico> findAll() throws SQLException {
        String sql = "SELECT * FROM servicos";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();


        // declarando e instanciando uma lista de servicos
        List<Servico> servicos = new ArrayList<>();

        while (rs.next()) {
            servicos.add(new Servico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getBoolean(6)));
        }
        rs.close();
        stmt.close();
        return servicos;
    }
    public static Servico find(Integer id) {
        String sql = "SELECT * FROM servicos WHERE id_servico =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Servico servico = new Servico();
            if (rs.next()) {
                servico.setId(rs.getInt(1));
                servico.setTitulo(rs.getString(2));
                servico.setDescricao(rs.getString(3));
                servico.setPreco(rs.getDouble(4));
                servico.setMiniatura(rs.getString(5));
                servico.setAtivo(rs.getBoolean(6));
            }
            return servico;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public Servico create(Servico servico) {
//        String sql;
//        sql = "INSERT INTO servicos (titulo, descricao, preco,miniatura,ativo) VALUES (?, ?, ?, ?, ? ";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// declara para statement que ele tem de retornar as chaves auto geradas
//
//            stmt.setString(1, servico.getTitulo());
//            stmt.setString(2, servico.getDescricao());
//            stmt.setDouble(3, servico.getPreco());
//            stmt.setString(4, servico.getMiniatura());
//            stmt.setBoolean(5, servico.getAtivo());
//            stmt.executeUpdate();
//            ResultSet servicoGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas
//            if (servicoGerado.next()) {
//                Integer id_servico = servicoGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
//                servico.setId(id_servico);
//            }
//            stmt.close();
//            return servico;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//    public Servico update(Servico servico) {
//        String sql = "UPDATE servicos set titulo=?, descricao=?, preco=?, miniatura=?, ativo=? WHERE id_servico";
//        try {
//            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//                stmt.setString(1, servico.getTitulo());
//                stmt.setString(2, servico.getDescricao());
//                stmt.setDouble(3, servico.getPreco());
//                stmt.setString(4, servico.getMiniatura());
//                stmt.setBoolean(5, servico.getAtivo());
//                stmt.setInt(6, servico.getId());
//
//                stmt.executeUpdate();
//
//                ResultSet servicoGerado = stmt.getGeneratedKeys();
//
//                if (servicoGerado.next()) {
//                    Integer id_servico = servicoGerado.getInt(1);
//                    servico.setId(id_servico);
//                }
//                stmt.close();
//                return servico;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String delete(Integer id) {
        String sql = "DELETE FROM servicos WHERE id_servico = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            return "Servico: " + id + "Removido com sucesso! ";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
