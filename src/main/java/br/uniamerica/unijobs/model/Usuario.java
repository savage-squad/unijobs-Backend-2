package br.uniamerica.unijobs.model;

public class Usuario extends Pessoa{
	private Integer id;
	private String email;
	private String senha;
	private TipoUsuario tipoUsuario;

	public Usuario() {
		
	}

	public Usuario(String nome, String celular, String ra, Universidade universidade, Curso curso, Integer id, String email, String senha, TipoUsuario tipoUsuario) {
		super(nome, celular, ra, universidade, curso);
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

    public Usuario(int id, String email, String nome, String celular, String ra) {
		super(nome, celular, ra, null, null);
		this.email = email;
		this.id = id;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				", tipoUsuario=" + tipoUsuario +
				'}';
	}

}
