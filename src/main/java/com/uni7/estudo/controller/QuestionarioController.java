package com.uni7.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.uni7.estudo.repository.Questoes;

@Controller
public class QuestionarioController {

	@Autowired
	private Questoes questoes;

}
