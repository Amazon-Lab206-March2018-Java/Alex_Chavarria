package com.avvarga.dojosurvey.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveys {
	
	@RequestMapping("/")
	public String index () {
		return "index.jsp";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
    public String login (@RequestParam Map <String,String> requestParams, Model m) throws Exception {
		m.addAttribute("name", requestParams.get("name"));
		m.addAttribute("location", requestParams.get("location"));
		m.addAttribute("language", requestParams.get("language"));
		m.addAttribute("comment", requestParams.get("comment"));
		return "result.jsp";
	}
    
}
