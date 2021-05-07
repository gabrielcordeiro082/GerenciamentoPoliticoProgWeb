package br.edu.cesmac.nolapi.domain;

import javax.persistence.*;

@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartido;
	private String nome;
	private String cargo;
	private String numero;

	@OneToMany
	private Candidato candidato;

	public Partido() {
	}
	
	public Partido(Long idPartido, String nome, String cargo, String numero) {
		this.idPartido = idPartido;
		this.nome = nome;
		this.cargo = cargo;
		this.numero = numero;

	}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}
