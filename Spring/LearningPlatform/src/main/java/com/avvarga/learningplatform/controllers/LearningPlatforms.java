package com.avvarga.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearningPlatforms {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
	public String assignment(@PathVariable String chapter, @PathVariable String assignmentNumber, Model m) {
		switch (assignmentNumber) {
			case "0345":{
				m.addAttribute("message","Coding Forms");
			}break;
			case "2342":{
				m.addAttribute("message","Fortran to Binary");
			}break;
		}
		return "assignment.jsp";
	}
	
	@RequestMapping("/m/{chapter}/0553/{lessonNumber}")
	public String lesson(@PathVariable String chapter, @PathVariable String lessonNumber, Model m) {
		switch (lessonNumber) {
			case "0733":{
				m.addAttribute("message","Setting up your servers");
			}break;
			case "0342":{
				m.addAttribute("message","Punch Cards");
			}break;
			case "0348":{
				m.addAttribute("message","Advanced Fortran Intro");
			}break;
		}
		return "lesson.jsp";
	}
}
