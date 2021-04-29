package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {
    private Connection conn = ConnectionFactory.getConnection();

    public Curso create(Curso curso) {
        String sql = "insert into cursos (nome) values (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, curso.getNome());
            stmt.executeUpdate();

            ResultSet cursoGerado = stmt.getGeneratedKeys();

            if(cursoGerado.next()){
                Integer idCurso = cursoGerado.getInt(1);
                curso.setId(idCurso);
            }

            stmt.close();
            return curso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Curso> findAll() throws SQLException {
        String sql = "SELECT * FROM cursos";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Curso> cursos = new ArrayList<>();
        while (rs.next()) {
            cursos.add(new Curso(rs.getInt(1),rs.getString(2)));
        }
        rs.close();
        stmt.close();
        conn.close();
        return cursos;
    }

    public Curso edit(Curso curso) {
        String sql = "update cursos set nome=?" +
                " where id_curso=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getId());
            stmt.executeUpdate();

            ResultSet cursoGerado = stmt.getGeneratedKeys();

            if(cursoGerado.next()){
                Integer id_curso = cursoGerado.getInt(1);
                curso.setId(id_curso);
            }

            stmt.close();
            return curso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Curso find(Integer id){
        String sql = "SELECT * FROM cursos WHERE id_curso = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Curso curso = new Curso();
            if(rs.next()){
                curso.setId(rs.getInt(1));
                curso.setNome(rs.getString(2));
            }
            return curso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String destroy(Integer id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM cursos WHERE id_curso = ?");
            stmt.setInt(1, id);
            Curso curso = this.find(id);

            stmt.execute();
            stmt.close();
            return "Curso: " +curso.getNome()+ " Deletado.";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
