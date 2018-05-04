package com.avvarga.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHumans {

	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String data, Model m) {
		if (data==null) {
			m.addAttribute("name","Human");
		}
		else {
			m.addAttribute("name", data);
		}
        return "index.jsp";
    }
	
}
