package com.avvarga.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.dojosandninjas.models.Dojo;
import com.avvarga.dojosandninjas.models.Ninja;
import com.avvarga.dojosandninjas.services.DojoService;
import com.avvarga.dojosandninjas.services.NinjaService;

@Controller
public class Controllers {
	
	private final DojoService dService;
	private final NinjaService nService;
	
	public Controllers (DojoService dService, NinjaService nService) {
		this.nService = nService;
		this.dService = dService;
	}
	
	@RequestMapping("/")
	public String index () {
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo (@ModelAttribute ("dojo") Dojo dojo) {
		return "dojos.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo (@Valid @ModelAttribute ("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojos.jsp";
		} else {
			dService.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping ("/ninjas/new")
	public String newNinja (@ModelAttribute ("ninja") Ninja ninja, Model m) {
		m.addAttribute("dojos", dService.findAll());
		return "ninjas.jsp";
	}
	
	@PostMapping ("/ninjas/new")
	public String createNinja (@Valid @ModelAttribute ("ninja") Ninja ninja, BindingResult result, @RequestParam ("dojo") Long id) {
		if (result.hasErrors()) {
			return "ninjas.jsp";
		} else {
			nService.addNinja(ninja);
			return "redirect:/dojos/"+id;
		}
	}
	
	@RequestMapping ("/dojos/{id}")
	public String showDojos (@PathVariable ("id") Long id, Model m) {
		m.addAttribute("ninjas", nService.findByDojo_id(id));
		return "info.jsp";
	}
}
