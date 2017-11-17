package com.uni7.estudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uni7.estudo.model.MateriaQuestoes;
import com.uni7.estudo.model.Questao;

public interface Questoes extends JpaRepository<Questao, Long> {

	@Query(value = "select new com.uni7.estudo.model.MateriaQuestoes(q.materia, count(q)) from Questao q group by q.materia")
	List<MateriaQuestoes> retornaMateriaCount();

	@Modifying
	@Query(value = "delete from questao where materia = ?1", nativeQuery = true)
	void deletaQuestoesPorMateria(String materia);

}
