package com.avvarga.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
    	
    	if (session.getAttribute("counter")==null) {
    		session.setAttribute("counter", 0);
    	}
    	else {
    		int counter = (int) session.getAttribute("counter");
    		counter++;
    		session.setAttribute("counter", counter);
    	}
    	
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
    public String counter(Model model) {
        return "counter.jsp";
    }
}
