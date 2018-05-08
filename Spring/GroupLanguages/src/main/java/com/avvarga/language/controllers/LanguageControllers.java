package com.avvarga.language.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avvarga.language.models.Language;
import com.avvarga.language.services.LanguageServices;

@Controller
public class LanguageControllers {
	
	private final LanguageServices languageService;
	public LanguageControllers(LanguageServices languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index (@ModelAttribute ("language") Language language, Model m) {
		m.addAttribute("languages", languageService.showLanguages());
		return "index.jsp";
	}
	
    @PostMapping("/languages/new")
    public String createBook(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        }else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    
	@RequestMapping ("/languages/{index}")
	public String show(@PathVariable String index, Model m) {
		m.addAttribute("language", languageService.showLanguage(index));
		return "show.jsp";
	}
	
	@RequestMapping ("/languages/edit/{index}")
	public String edit(@PathVariable String index, Model m, @ModelAttribute ("language") Language language) {
		m.addAttribute("language", languageService.showLanguage(index));
		return "edit.jsp";
	}
	
	@RequestMapping ("/languages/edit/{index}/submit")
	public String submit(@Valid @ModelAttribute ("language") Language language, BindingResult result, @PathVariable String index, Model m) {
		if (result.hasErrors()) {
            return "index.jsp";
        }else{
        	languageService.updateLanguage(index, language);
        	return "redirect:/languages";
        }
	}
	
	@RequestMapping ("/languages/delete/{index}")
	public String delete (@PathVariable String index, @ModelAttribute ("language") Language language) {
		languageService.deleteLanguage(index, language);
		return "redirect:/languages";
	}
}
