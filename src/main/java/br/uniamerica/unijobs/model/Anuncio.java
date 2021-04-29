package br.uniamerica.unijobs.model;

import java.util.ArrayList;

public class Anuncio {
	private Integer id;
	private Usuario usuario;
	private String titulo;
	private String descricao;
	private Double preco;
	private String miniatura;
	private Boolean ativo;
	private Integer prazo;
	private ArrayList<Avaliacao> avaliacoes;
	private ArrayList<Imagem> imagens;

	public Anuncio() {
	}

	public Anuncio(Integer id, Usuario usuario, String titulo, String descricao, Double preco, String miniatura,
				   Boolean ativo, Integer prazo, ArrayList<Avaliacao> avaliacoes, ArrayList<Imagem> imagens) {
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.miniatura = miniatura;
		this.ativo = ativo;
		this.prazo = prazo;
		this.avaliacoes = avaliacoes;
		this.imagens = imagens;
	}

	public Anuncio(Integer id, String titulo, String descricao, Double preco, String miniatura, Boolean ativo, Integer prazo, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.miniatura = miniatura;
		this.ativo = ativo;
		this.prazo = prazo;
	}

	public Anuncio(Integer id, Usuario usuario, String titulo, String descricao, Double preco, String miniatura, Boolean ativo, ArrayList<Avaliacao> avaliacoes, ArrayList<Imagem> imagens) {
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.miniatura = miniatura;
		this.ativo = ativo;
		this.avaliacoes = avaliacoes;
		this.imagens = imagens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getMiniatura() {
		return miniatura;
	}

	public void setMiniatura(String miniatura) {
		this.miniatura = miniatura;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public ArrayList<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(ArrayList<Imagem> imagens) {
		this.imagens = imagens;
	}

	@Override
	public String toString() {
		return "Anuncio{" +
				"id=" + id +
				", usuario=" + usuario +
				", titulo='" + titulo + '\'' +
				", descricao='" + descricao + '\'' +
				", preco=" + preco +
				", miniatura='" + miniatura + '\'' +
				", ativo=" + ativo +
				", avaliacoes=" + avaliacoes +
				", imagens=" + imagens +
				'}';
	}
}
