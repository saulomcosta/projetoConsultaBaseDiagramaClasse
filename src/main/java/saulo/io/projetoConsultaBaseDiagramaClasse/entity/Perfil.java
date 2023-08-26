package saulo.io.projetoConsultaBaseDiagramaClasse.entity;

import java.util.List;

import jakarta.persistence.*;
import saulo.io.projetoConsultaBaseDiagramaClasse.enun.StatusPerfil;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private StatusPerfil statusPerfil;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Funcionalidades> funcionalidades;

	public Perfil() {
	}

	public Perfil(String nome, StatusPerfil statusPerfil) {

		this.nome = nome;
		this.statusPerfil = statusPerfil;
	
	}
	
	public Perfil(String nome, StatusPerfil statusPerfil, List<Funcionalidades> funcionalidades) {

		this.nome = nome;
		this.statusPerfil = statusPerfil;
		this.funcionalidades = funcionalidades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusPerfil getStatusPerfil() {
		return statusPerfil;
	}

	public void setStatusPerfil(StatusPerfil statusPerfil) {
		this.statusPerfil = statusPerfil;
	}

	public List<Funcionalidades> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidades> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
