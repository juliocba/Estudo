package com.uni7.estudo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uni7.estudo.model.Estudante;
import com.uni7.estudo.repository.Estudantes;

@Controller
@RequestMapping("/estudantes")
public class EstudantesController {

	@Autowired
	private Estudantes estudantes;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("estudante/CadastroEstudante");
		modelAndView.addObject("estudantes", estudantes.findAll());
		modelAndView.addObject(new Estudante());
		return modelAndView;
	}
	
	@RequestMapping("/lista")
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("estudante/ListaEstudantes");
		modelAndView.addObject("estudantes", estudantes.findAll());
		modelAndView.addObject(new Estudante());
		return modelAndView;
	}

	@PostMapping
	public String salvar(@Valid Estudante estudante, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "estudante/CadastroEstudante";
		}
		if (!StringUtils.pathEquals(estudante.getSenha(), estudante.getConfirmacaoSenha())) {
			ObjectError error = new ObjectError("senha", "Senhas não são iguais!");
			result.addError(error);
			return "estudante/CadastroEstudante";
		}
		this.estudantes.save(estudante);
		attributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");
		return "redirect:/estudantes";
	}
	
}
