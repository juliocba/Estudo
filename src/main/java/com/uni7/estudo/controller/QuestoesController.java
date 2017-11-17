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

import com.uni7.estudo.model.Questao;
import com.uni7.estudo.repository.Questoes;

@Controller
@RequestMapping("/questoes")
public class QuestoesController {

	@Autowired
	private Questoes questoes;
	private String ultimaMateria = "";

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("questao/CadastroQuestao");
		modelAndView.addObject("questoes", questoes.findAll());
		Questao q = new Questao();
		q.setMateria(ultimaMateria);
		modelAndView.addObject(q);
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(@Valid Questao questao, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "questao/CadastroQuestao";
		}
		
		this.questoes.save(questao);
		attributes.addFlashAttribute("mensagem", "Questão salva com sucesso!");
		ultimaMateria = questao.getMateria();
		return "redirect:/questoes";
	}
	
}
