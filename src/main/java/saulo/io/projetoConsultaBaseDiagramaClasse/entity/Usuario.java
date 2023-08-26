package saulo.io.projetoConsultaBaseDiagramaClasse.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String email;

	/*
	 * EAGER -> Carregamento instantaneo das associoações LEAZY -> Carregamento por
	 * demanda
	 */
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Perfil> perfils;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

}
