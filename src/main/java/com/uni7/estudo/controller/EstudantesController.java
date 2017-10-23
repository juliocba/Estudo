package com.uni7.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uni7.estudo.model.Estudante;
import com.uni7.estudo.repository.Estudantes;

@Controller
@RequestMapping("/estudantes")
public class EstudantesController {

	@Autowired
	private Estudantes estudantes;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("estudante/ListaEstudantes");
		modelAndView.addObject("estudantes", estudantes.findAll());
		modelAndView.addObject(new Estudante());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Estudante estudante) {
		this.estudantes.save(estudante);
		return "redirect:/estudantes";
	}
	
	@RequestMapping("/novo")
	public String novo(Estudante estudante) {
		return "estudante/CadastroEstudante";
	}

}
