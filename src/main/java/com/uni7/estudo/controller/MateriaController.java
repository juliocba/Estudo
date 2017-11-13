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

import com.uni7.estudo.model.Materia;
import com.uni7.estudo.repository.Materias;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private Materias materias;
	
	@GetMapping("/lista")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("materia/CadastroMateria");
		modelAndView.addObject("materias", materias.findAll());
		modelAndView.addObject(new Materia());
		return modelAndView;
	}
	
	@RequestMapping("/novo")
	public String novo(Materia materia) {
		return "materia/CadastroMateria";
	}

	@PostMapping
	public String salvar(@Valid Materia materia, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(materia);
		}
		this.materias.save(materia);
		attributes.addFlashAttribute("mensagem", "Matéria salva com sucesso!");
		return "redirect:/materias";
	}
	
}
