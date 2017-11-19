package com.uni7.estudo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uni7.estudo.model.Questao;
import com.uni7.estudo.repository.Questoes;

@Controller
public class CartoesController {

	@Autowired
	private Questoes questoes;

	private int quantidadePerguntas = 0;
	private int quantidadeDificeis = 0;
	private int quantidadeFaceis = 0;
	private String nomeMateria = "";
	private List<Questao> questoesAleatorias = new ArrayList<>();

	@GetMapping("/")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cartao/Cartao");
		modelAndView.addObject("questoesCont", questoes.retornaMateriaCount());
		return modelAndView;
	}

	@GetMapping("/questionario")
	public ModelAndView mostraQuestionario(List<Questao> questoes) {
		String pergunta = "";
		String resposta = "";
		if (quantidadePerguntas == 0)
			quantidadePerguntas = questoes.size();

		if (!questoes.isEmpty()) {
			pergunta = questoes.get(0).getPergunta();
			resposta = questoes.get(0).getResposta();
		}

		ModelAndView mv = new ModelAndView("questionario/Questionario");
		mv.addObject("questoes", questoes);
		mv.addObject("nomeMateria", nomeMateria);
		mv.addObject("pergunta", pergunta);
		mv.addObject("resposta", resposta);
		mv.addObject("quantidadePerguntas", quantidadePerguntas);
		mv.addObject("quantidadeDificeis", quantidadeDificeis);
		mv.addObject("quantidadeFaceis", quantidadeFaceis);

		return mv;
	}

	@PostMapping(value = "/quest", params = "quest=dificil")
	public ModelAndView dificil() {
		quantidadePerguntas -= 1;
		quantidadeDificeis += 1;
		
		Questao questao = questoesAleatorias.get(0);
		questao.setDificil("S");
		questao.setFacil(null);
		
		questoes.save(questao);
		questoesAleatorias.remove(0);
		return mostraQuestionario(questoesAleatorias);
	}

	@PostMapping(value = "/quest", params = "quest=facil")
	public ModelAndView facil() {
		quantidadePerguntas -= 1;
		quantidadeFaceis += 1;
		
		Questao questao = questoesAleatorias.get(0);
		questao.setDificil(null);
		questao.setFacil("S");
		
		questoes.save(questao);
		questoesAleatorias.remove(0);
		return mostraQuestionario(questoesAleatorias);
	}

	@GetMapping("/questionario/{materia}")
	public ModelAndView abreQuestionario(@PathVariable("materia") String materia) {
		nomeMateria = materia;

		quantidadePerguntas = 0;
		quantidadeDificeis = 0;
		quantidadeFaceis = 0;
		
		List<Questao> listaCarregada = questoes.findByMateria(materia);
		Collections.shuffle(listaCarregada);
		questoesAleatorias = listaCarregada;

		return mostraQuestionario(questoesAleatorias);
	}

	@GetMapping("/delete/{materia}")
	public String delete(@PathVariable("materia") String materia, RedirectAttributes attributes) {
		questoes.deletaQuestoesPorMateria(materia);
		attributes.addFlashAttribute("mensagem", "Cartão deletado com sucesso!");
		return "redirect:/cartoes";
	}

}
