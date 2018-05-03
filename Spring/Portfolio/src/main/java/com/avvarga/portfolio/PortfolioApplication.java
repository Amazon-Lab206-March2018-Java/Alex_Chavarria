package com.avvarga.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
	@RequestMapping ("/")
	public String index() {
		return "forward:/index.html";
	}
	
	@RequestMapping ("/me")
	public String me() {
		return "forward:/me.html";
	}
	
	@RequestMapping ("/projects")
	public String projects() {
		return "forward:/projects.html";
	}
}
