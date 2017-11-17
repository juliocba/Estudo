package com.uni7.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni7.estudo.model.Materia;

public interface Materias extends JpaRepository<Materia, Long> {
	
}
