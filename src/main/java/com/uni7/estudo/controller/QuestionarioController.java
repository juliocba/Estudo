package com.uni7.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uni7.estudo.repository.Questoes;

@Controller
public class QuestionarioController {

	@Autowired
	private Questoes questoes;

	@GetMapping("/questionario")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("questionario/Questionario");
		modelAndView.addObject("questoes", questoes.retornaMateriaCount());
		return modelAndView;
	}

}
