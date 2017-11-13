package com.uni7.estudo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uni7.estudo.model.Planejamento;
import com.uni7.estudo.repository.Materias;
import com.uni7.estudo.repository.Planejamentos;

@Controller
@RequestMapping("/")
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
	
	@RequestMapping("planejamentos")
	public String novo(Planejamento planejamento) {
		return "planejamento/CadastroPlanejamento";
	}

	@PostMapping
	public String salvar(@Valid Planejamento planejamento, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(planejamento);
		}
		this.planejamentos.save(planejamento);
		attributes.addFlashAttribute("mensagem", "Planejamento salvo com sucesso!");
		return "redirect:/planejamentos";
	}

}
