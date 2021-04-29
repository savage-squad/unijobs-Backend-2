package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.model.Anuncio;
import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.Avaliacao;
import br.uniamerica.unijobs.model.Curso;
import br.uniamerica.unijobs.model.Imagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImagemDao {
    private Connection conn = ConnectionFactory.getConnection();

    public void create(Imagem imagem) {
        String sql = "insert into imagens " +
                "(url, id_anuncio)" +
                " values (?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, imagem.getUrl());
            stmt.setInt(1, imagem.getAnuncio().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Imagem> findAll() throws SQLException {
        String sql = "SELECT * FROM imagens";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Imagem> imagens = new ArrayList<>();
        while (rs.next()) {
            Anuncio anuncio = new Anuncio();
            imagens.add(new Imagem(rs.getInt(1),rs.getString(2), anuncio));
        }
        rs.close();
        stmt.close();
        conn.close();
        return imagens;
    }

    public void edit(Imagem imagem) {
        String sql = "update imagens set url=?, id_anuncio=?" +
                "where id_imagem=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, imagem.getUrl());
            stmt.setInt(1, imagem.getAnuncio().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy(Imagem imagem) {
        try {
            PreparedStatement stmt = conn.prepareStatement("delete " +
                    "from imagens where id_imagem=?");
            stmt.setInt(1, imagem.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}