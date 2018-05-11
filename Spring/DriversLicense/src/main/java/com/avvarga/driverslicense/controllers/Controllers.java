package com.avvarga.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avvarga.driverslicense.models.License;
import com.avvarga.driverslicense.models.Person;
import com.avvarga.driverslicense.services.LicensesService;
import com.avvarga.driverslicense.services.PersonsService;

@Controller
public class Controllers {
	
	private final PersonsService pService;
	private final LicensesService lService;
	
	public Controllers (PersonsService pService, LicensesService lService) {
		this.pService = pService;
		this.lService = lService;
	}
	
	@RequestMapping ("/")
	public String index() {
		return "redirect:/persons/new";
	}
	
	@RequestMapping ("/persons/new")
	public String newPerson(@ModelAttribute ("person") Person person) {
		return "person.jsp";
	}
	
	@PostMapping ("/persons/new")
	public String createPerson (@Valid @ModelAttribute ("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "person.jsp";
		} else {
			pService.addPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping ("/licenses/new")
	public String newLicense(@ModelAttribute ("license") License license, Model m) {
		m.addAttribute("persons", pService.findAll());
		m.addAttribute("licenseNumber", String.format("%05o", 1+lService.findAll().size()));
		return "license.jsp";
	}
	
	@PostMapping ("/licenses/new")
	public String createLicense (@Valid @ModelAttribute ("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "license.jsp";
		} else {
			lService.addLicense(license);
			return "redirect:/licenses/new";
		}
	}
	@RequestMapping ("/persons/{id}")
	public String showPersons (@PathVariable ("id") Long id, Model m) {
		m.addAttribute("person", pService.findById(id));
		m.addAttribute("license", lService.findById(id));
		return "profile.jsp";
	}
}
