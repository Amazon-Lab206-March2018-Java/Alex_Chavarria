package com.avvarga.language.controllers;

import javax.transaction.Transactional;
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
		m.addAttribute("languages", languageService.allLanguages());
		return "index.jsp";
	}
	
    @PostMapping("/languages/new")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        }else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    
	@RequestMapping ("/languages/{id}")
	public String show(@PathVariable Long id, Model m) {
		m.addAttribute("language", languageService.showLanguage(id));
		return "show.jsp";
	}
	
	@RequestMapping ("/languages/edit/{id}")
	public String edit(@PathVariable Long id, Model m, @ModelAttribute ("language") Language language) {
		m.addAttribute("language", languageService.showLanguage(id));
		return "edit.jsp";
	}
	
	@Transactional
	@PostMapping ("/languages/edit/{id}")
	public String submit(@Valid @ModelAttribute ("language") Language language, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
            return "index.jsp";
        }else{
        	language.setId(id);
        	languageService.updateLanguage(language);
        	return "redirect:/languages";
        }
	}
	
	@RequestMapping ("/languages/delete/{id}")
	public String delete (@PathVariable ("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
