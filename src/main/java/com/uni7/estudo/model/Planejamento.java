package com.uni7.estudo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "planejamento")
public class Planejamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 50, message = "Tamanho máximo de 50 caracteres")
	private String nome;
	@Column(nullable = false)
	@NotBlank(message="Data é obrigatório")
	private Date dataDaProva;
	@OneToMany
	@NotBlank(message="Matéria é obrigatório")
	private List<Materia> materias;
	@Column(nullable = false)
	@NotBlank(message="Data de início é obrigatório")
	private Date inicioPlanejamento;
	@Column(nullable = false)
	@NotBlank(message="Data de fim é obrigatório")
	private Date finalPlanejamento;

	public Planejamento() {
	}

	public Planejamento(Long id, String nome, Date dataDaProva, List<Materia> materias) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDaProva = dataDaProva;
		this.materias = materias;
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

	public Date getDataDaProva() {
		return dataDaProva;
	}

	public void setDataDaProva(Date dataDaProva) {
		this.dataDaProva = dataDaProva;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Date getInicioPlanejamento() {
		return inicioPlanejamento;
	}

	public void setInicioPlanejamento(Date inicioPlanejamento) {
		this.inicioPlanejamento = inicioPlanejamento;
	}

	public Date getFinalPlanejamento() {
		return finalPlanejamento;
	}

	public void setFinalPlanejamento(Date finalPlanejamento) {
		this.finalPlanejamento = finalPlanejamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planejamento other = (Planejamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
