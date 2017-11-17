package com.uni7.estudo.model;

public class MateriaQuestoes {

	private String materia;
	private Long questoes;

	public MateriaQuestoes(String materia, Long questoes) {
		this.materia = materia;
		this.questoes = questoes;
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
	

}
