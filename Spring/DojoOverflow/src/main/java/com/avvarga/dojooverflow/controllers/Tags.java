package com.avvarga.dojooverflow.controllers;

import org.springframework.stereotype.Controller;

import com.avvarga.dojooverflow.services.TagService;

@Controller
public class Tags {
	
	private final TagService tServ;
	
	public Tags (TagService tServ) {
		this.tServ = tServ;
	}
}
