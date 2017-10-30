package com.uni7.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uni7.estudo.model.Planejamento;
import com.uni7.estudo.repository.Materias;
import com.uni7.estudo.repository.Planejamentos;

@Controller
@RequestMapping("/planejamentos")
public class PlanejamentoController {

	@Autowired
	private Planejamentos planejamentos;
	@Autowired
	private Materias materias;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("planejamento/CadastroPlanejamento");
		modelAndView.addObject("materias", materias.findAll());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Planejamento planejamento) {
		this.planejamentos.save(planejamento);
		return "redirect:/planejamentos";
	}
	
}
