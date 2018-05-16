package com.avvarga.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avvarga.countries.services.ApiService;

@Controller
public class Controllers {
	
	private final ApiService serv;
	public Controllers (ApiService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/")
	public String index () {
//		serv.findCountriesSlovene();
//		System.out.println("-------------------------------------");
//		serv.showCitiesPerCountry();
//		System.out.println("-------------------------------------");
//		serv.mexicanCitiesOver500k();
//		System.out.println("-------------------------------------");
//		serv.languagesPerCountryOver89();
//		System.out.println("-------------------------------------");
//		serv.countriesSmaller500PopulationOver100k();
//		System.out.println("-------------------------------------");
//		serv.countriesWithConstitutionalMonarchy();
//		System.out.println("-------------------------------------");
//		serv.citiesBuenosairesOver500k();
		System.out.println("-------------------------------------");
		serv.citiesPerRegion();
		System.out.println("-------------------------------------");
		return "index";
	}
}
