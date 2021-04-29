package br.uniamerica.unijobs.model;

import java.util.ArrayList;

public class Universidade {
	private Integer id;
	private String nome;
	private String cnpj;
	private ArrayList<Curso> cursos;
	
	public Universidade() {	
	}

	public Universidade(Integer id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cursos = cursos;
	}

	public Universidade(Integer id, String nome, String cnpj, ArrayList<Curso> cursos) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cursos = cursos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Universidade{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cnpj='" + cnpj + '\'' +
				", cursos=" + cursos +
				'}';
	}

}
