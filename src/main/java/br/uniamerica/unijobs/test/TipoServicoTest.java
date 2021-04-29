package br.uniamerica.unijobs.test;

import br.uniamerica.unijobs.dao.TipoServicoDao;
import br.uniamerica.unijobs.model.TipoServico;

import java.sql.SQLException;
import java.util.List;

public class TipoServicoTest {
    public static void main(String[] args) throws SQLException {
        TipoServicoDao tipoServicoDao = new TipoServicoDao();

        TipoServico informatica = new TipoServico("Informatica", "Serviços relacionados a informatica");
        informatica = tipoServicoDao.create(informatica);


        System.out.println(informatica.toString());

        informatica.setDescricao("Serviços relacionados a tecnologia de informação");

        tipoServicoDao.update(informatica);

        List<TipoServico> tiposServicos = tipoServicoDao.findAll(); //deve retornar uma lista

        for (TipoServico tipoServico : tiposServicos){
            System.out.println(tipoServico);
        }

    }
}
