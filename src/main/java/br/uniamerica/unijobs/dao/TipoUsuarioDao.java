package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.TipoUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioDao {

    //pega conexao do banco de dados por um metodo estatico da classe ConexaoDao
    private Connection connection;
    public TipoUsuarioDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public List<TipoUsuario> findAll() throws SQLException {
        String sql = "SELECT * FROM tipos_usuarios";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        // declarando e instanciando uma lista de tipos_usuarios
        List<TipoUsuario> tipos_usuarios = new ArrayList<>();

        while(rs.next()){
            tipos_usuarios.add(new TipoUsuario(rs.getInt(1), rs.getString(2)));
        }

        rs.close();
        stmt.close();
        connection.close();
        return tipos_usuarios;
    }

    public TipoUsuario find(Integer id){
        String sql = "SELECT * FROM tipos_usuarios WHERE id_tipoUsuario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            TipoUsuario tipo_usuario = new TipoUsuario();
            if(rs.next()){
                tipo_usuario.setId(rs.getInt(1));
                tipo_usuario.setTipo(rs.getString(2));
            }
            return tipo_usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoUsuario create(TipoUsuario tipo_usuario){
        String sql = "INSERT INTO tipos_usuarios (nome) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // declara pro statement que ele tem de retornar as chaves auto geradas

            stmt.setString(1,tipo_usuario.getTipo());

            stmt.executeUpdate();

            ResultSet tipo_usuarioGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas

            if(tipo_usuarioGerado.next()){
                Integer idTipoUsuario = tipo_usuarioGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
                tipo_usuario.setId(idTipoUsuario);
            }

            stmt.close();
            return tipo_usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoUsuario update(TipoUsuario tipo_usuario){
        String sql = "UPDATE tipos_usuarios set nome=? where id_tipoUsuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,tipo_usuario.getTipo());
            stmt.setInt(2,tipo_usuario.getId());

            stmt.executeUpdate();

            ResultSet tipo_usuarioGerado = stmt.getGeneratedKeys();

            if(tipo_usuarioGerado.next()){
                Integer idTipoUsuario = tipo_usuarioGerado.getInt(1);
                tipo_usuario.setId(idTipoUsuario);
            }

            stmt.close();
            return tipo_usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String delete(Integer id){
        String sql = "DELETE FROM tipos_usuarios WHERE id_tipoUsuario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            return "Tipo Usuario: " +id+ "Deletado.";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
