package br.uniamerica.unijobs.model;

import java.util.ArrayList;

public class Produto extends Anuncio{
	private Integer id;
	private TipoProduto tipoProduto;
	
	public Produto() {
		
	}

	public Produto(Integer id, Usuario usuario, String titulo, String descricao, Double preco, String miniatura,
				   Boolean ativo, ArrayList<Avaliacao> avaliacoes, ArrayList<Imagem> imagens, Integer id_produto, TipoProduto tipoProduto) {
		super(id, usuario, titulo, descricao, preco, miniatura, ativo, avaliacoes, imagens);
		this.id = id_produto;
		this.tipoProduto = tipoProduto;
	}

	public Produto(Integer id) {
	
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"id=" + id +
				", tipoProduto=" + tipoProduto +
				", titulo=" + getTitulo() +
				", descricao=" + getDescricao() +
				", preco=" + getPreco() +
				", miniatura=" + getMiniatura() +
				", ativo=" + getAtivo() +
				", avaliacoes=" + getAvaliacoes() +
				", imagens=" + getImagens() +
				", id1=" + getId() +
				'}';
	}
}
