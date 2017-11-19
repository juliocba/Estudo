package com.uni7.estudo.model;

public class MateriaQuestoes {

	private String materia;
	private Long questoes;
	private Long dificeis;
	private Long faceis;

	public MateriaQuestoes(String materia, Long questoes, Long dificeis, Long faceis) {
		this.materia = materia;
		this.questoes = questoes;
		this.dificeis = dificeis;
		this.faceis = faceis;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Long getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Long questoes) {
		this.questoes = questoes;
	}

	public Long getDificeis() {
		return dificeis;
	}

	public void setDificeis(Long dificeis) {
		this.dificeis = dificeis;
	}

	public Long getFaceis() {
		return faceis;
	}

	public void setFaceis(Long faceis) {
		this.faceis = faceis;
	}
	

}
