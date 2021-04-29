package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.TipoUsuario;
import br.uniamerica.unijobs.model.Usuario;
import br.uniamerica.unijobs.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    //pega conexao do banco de dados por um metodo estatico da classe ConexaoDao
    private Connection connection;
    public UsuarioDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public List<Usuario> findAll() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        // declarando e instanciando uma lista de usuarios
        List<Usuario> usuarios = new ArrayList<>();

        while(rs.next()){
            TipoUsuario tipoUsuario = new TipoUsuarioDao().find(rs.getInt(1));
            usuarios.add(new Usuario(rs.getInt(1),
                rs.getString(2),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                tipoUsuario)
            );
        }

        rs.close();
        stmt.close();
        return usuarios;
    }

    public Usuario find(Integer id){
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Usuario usuario = new Usuario();
            if(rs.next()){
                TipoUsuario tipoUsuario = new TipoUsuarioDao().find(rs.getInt(1));

                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setRa(rs.getString("ra"));
                usuario.setTipoUsuario(tipoUsuario);
            }
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario create(Usuario usuario){
        String sql = "INSERT INTO usuarios (email, senha, nome, celular, ra, id_tipoUsuario) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // declara pro statement que ele tem de retornar as chaves auto geradas

            stmt.setString(1,usuario.getEmail());
            stmt.setString(2,usuario.getSenha());
            stmt.setString(3,usuario.getNome());
            stmt.setString(4,usuario.getCelular());
            stmt.setString(5,usuario.getRa());
            stmt.setInt(6, usuario.getTipoUsuario().getId());

            stmt.executeUpdate();

            ResultSet usuarioGerado = stmt.getGeneratedKeys(); // Pega as chaves auto-geradas

            if(usuarioGerado.next()){
                Integer idUsuario = usuarioGerado.getInt(1); // pega o Int da coluna 1 do ResultSet
                usuario.setId(idUsuario);
            }

            stmt.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario update(Usuario usuario){
        String sql = "UPDATE usuarios set email=?, senha=?, nome=?, celular=?, ra=?, id_tipoUsuario=? where id_usuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,usuario.getEmail());
            stmt.setString(2,usuario.getSenha());
            stmt.setString(3,usuario.getNome());
            stmt.setString(4,usuario.getCelular());
            stmt.setString(5,usuario.getRa());
            stmt.setInt(6, usuario.getTipoUsuario().getId());
            stmt.setInt(7, usuario.getId());


            stmt.executeUpdate();

            ResultSet usuarioGerado = stmt.getGeneratedKeys();

            if(usuarioGerado.next()){
                Integer idUsuario = usuarioGerado.getInt(1);
                usuario.setId(idUsuario);
            }

            stmt.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String delete(Integer id){
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try {
            Usuario usuarioDeletado = new UsuarioDao().find(id);
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            return "Usuario: " + usuarioDeletado.getNome() + " Deletado.";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
