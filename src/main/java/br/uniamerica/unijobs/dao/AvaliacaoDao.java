package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.model.Anuncio;
import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDao {
    private Connection conn = ConnectionFactory.getConnection();

    public void create(Avaliacao avaliacao) {
        String sql = "insert into avaliacoes " +
                "(nota, id_anuncio)" +
                " values (?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, avaliacao.getNota());
            stmt.setInt(2, avaliacao.getAnuncio().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Avaliacao> findAll() throws SQLException {
        String sql = "SELECT * FROM avaliacoes";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Avaliacao> avaliacoes = new ArrayList<>();
        while (rs.next()) {
            Anuncio anuncio = new Anuncio();
            avaliacoes.add(new Avaliacao(rs.getInt(1), rs.getInt(2), anuncio));
        }
        rs.close();
        stmt.close();
        conn.close();
        return avaliacoes;
    }

    public void edit(Avaliacao avaliacao) {
        String sql = "update avaliacoes set nota=?, id_anuncio=?" +
                " where id_avaliacao=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, avaliacao.getNota());
            stmt.setInt(2, avaliacao.getAnuncio().getId());
            stmt.setInt(3, avaliacao.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy(Avaliacao avaliacao) {
        try {
            PreparedStatement stmt = conn.prepareStatement("delete " +
                    "from avaliacoes where id_avaliacao=?");
            stmt.setInt(1, avaliacao.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
