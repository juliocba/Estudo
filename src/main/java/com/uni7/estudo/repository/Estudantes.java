package com.uni7.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni7.estudo.model.Estudante;

public interface Estudantes extends JpaRepository<Estudante, Long> {

}
