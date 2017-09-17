package com.uni7.estudo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante implements Serializable {

	private static final long serialVersionUID = 916349308031381255L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String objetivo;
	private Integer quantidadeMateria;

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

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Integer getQuantidadeMateria() {
		return quantidadeMateria;
	}

	public void setQuantidadeMateria(Integer quantidadeMateria) {
		this.quantidadeMateria = quantidadeMateria;
	}

}
