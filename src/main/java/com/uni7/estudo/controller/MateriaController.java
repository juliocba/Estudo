package com.uni7.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uni7.estudo.model.Materia;
import com.uni7.estudo.repository.Materias;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private Materias materias;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("materia/CadastroMateria");
		modelAndView.addObject("materias", materias.findAll());
		modelAndView.addObject(new Materia());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Materia materia) {
		this.materias.save(materia);
		return "redirect:/materias";
	}
	
}
