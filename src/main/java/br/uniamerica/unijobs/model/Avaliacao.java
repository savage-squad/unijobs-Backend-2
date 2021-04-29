package br.uniamerica.unijobs.model;

public class Avaliacao {
	private Integer id;
	private int nota;
	private Anuncio anuncio;
	
	public Avaliacao() {
	
	}

	public Avaliacao(Integer id, int nota, Anuncio anuncio) {
		this.id = id;
		this.nota = nota;
		this.anuncio = anuncio;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Avaliacao{" +
				"id=" + id +
				", nota=" + nota +
				", anuncio=" + anuncio +
				'}';
	}
}
