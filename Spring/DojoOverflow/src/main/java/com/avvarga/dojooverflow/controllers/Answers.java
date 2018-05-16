package com.avvarga.dojooverflow.controllers;

import org.springframework.stereotype.Controller;

import com.avvarga.dojooverflow.services.AnswerService;

@Controller
public class Answers {
	
	private final AnswerService aServ;
	
	public Answers (AnswerService aServ) {
		this.aServ = aServ;
	}
}
