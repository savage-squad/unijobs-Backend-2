package br.uniamerica.unijobs.dao;

import br.uniamerica.unijobs.factory.ConnectionFactory;
import br.uniamerica.unijobs.model.TipoProduto;
import br.uniamerica.unijobs.model.TipoServico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoServicoDao {

    //pega conexao do banco de dados por um metodo estatico da classe ConexaoDao
    private Connection connection;
    public TipoServicoDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public List<TipoServico> findAll() throws SQLException {
        String sql = "SELECT * FROM tipos_servico";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        // declarando e instanciando uma lista de tipos produtos
        List<TipoServico> tiposServicos = new ArrayList<>();

        while(rs.next()){
            tiposServicos.add(new TipoServico(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        rs.close();
        stmt.close();
        return tiposServicos;
    }

    public TipoServico find(Integer id){
        String sql = "SELECT * FROM tipos_servicos WHERE id_tipoServico = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            TipoServico tipoServico = new TipoServico();
            if(rs.next()){
                tipoServico.setId(rs.getInt(1));
                tipoServico.setNome(rs.getString(2));
                tipoServico.setDescricao(rs.getString(3));
            }
            return tipoServico;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoServico create(TipoServico tipoServico){
        String sql = "INSERT INTO tipos_servico (nome, descricao) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,tipoServico.getNome());
            stmt.setString(2,tipoServico.getDescricao());

            stmt.execute();
            stmt.close();

            return tipoServico;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(TipoServico tipoServico){
        String sql = "UPDATE tipos_servico set nome=?, descricao=? where id_tipoServico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,tipoServico.getNome());
            stmt.setString(2,tipoServico.getDescricao());
            stmt.setInt(3,tipoServico.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(TipoServico tipoServico){
        String sql = "DELETE FROM tipos_servico WHERE id_tipoServico = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1,tipoServico.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
