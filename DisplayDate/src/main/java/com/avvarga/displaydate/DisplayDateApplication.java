package com.avvarga.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
        SimpleDateFormat fmt = new SimpleDateFormat("EEEE', the 'd ' of ' MMMM ',' yyyy");
        String str = fmt.format(new Date());
    	model.addAttribute("date", str);
        return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
        SimpleDateFormat fmt = new SimpleDateFormat("h':'mm a");
        String str = fmt.format(new Date());
    	model.addAttribute("time", str);
        return "time.jsp";
    }
}
