package com.uni7.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.uni7.estudo.model.Questao;
import com.uni7.estudo.repository.Questoes;

@Controller
public class CartoesController {

	@Autowired
	private Questoes questoes;

	@GetMapping("/cartoes")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cartao/Cartao");
		modelAndView.addObject("questoes", questoes.retornaMateriaCount());
		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView add(Questao questao) {

		ModelAndView mv = new ModelAndView("questao/CadastroQuestao");
		mv.addObject("questao", questao);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(questoes.findOne(id));
	}

	@GetMapping("/delete/{materia}")
	public String delete(@PathVariable("materia") String materia) {

		questoes.deletaQuestoesPorMateria(materia);

		return "redirect:/cartoes";
	}

}
