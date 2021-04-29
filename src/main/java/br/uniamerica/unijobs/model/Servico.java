package br.uniamerica.unijobs.model;

import java.util.ArrayList;

public class Servico extends Anuncio{
	private Integer id;
	private TipoServico tipoServico;
	
	public Servico() {
	
	}

	public Servico(Integer id, Usuario usuario, String titulo, String descricao, Double preco, String miniatura, Boolean ativo, ArrayList<Avaliacao> avaliacoes, ArrayList<Imagem> imagens, Integer id1, TipoServico tipoServico) {
		super(id, usuario, titulo, descricao, preco, miniatura, ativo, avaliacoes, imagens);
		this.id = id1;
		this.tipoServico = tipoServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Servico{" +
				"id=" + id +
				", tipoServico=" + tipoServico +
				'}';
	}


}
