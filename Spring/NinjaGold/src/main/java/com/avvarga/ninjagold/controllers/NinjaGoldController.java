package com.avvarga.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/")
	public String index () {
		return "index.jsp";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path="/process_money", method=RequestMethod.POST)
	public String processMoney (@RequestParam String building, Model m, HttpSession session) throws Exception {
		int min = 0;
		int max = 0;
		if (session.getAttribute("activities")==null) {
			session.setAttribute("total", 0);
			session.setAttribute("activities", new ArrayList<Map>());
		}
			switch (building) {
				case "farm":{
		            min = 10;
		            max = 20;
		        }break;
		        case "cave":{
		        	min = 5;
		        	max = 10;		            
		        }break;
		        case "house":{
		        	min = 2;
		        	max = 5;		            
		        }break;
		        case "casino":{
		        	min = -50;
		        	max = 50;		            
		        }break;
			}
			
			Random rng = new Random();
			int earnings = rng.nextInt ( max + 1 - min) + min;
			int gold = (int) session.getAttribute("total") + earnings;
			session.setAttribute("total", gold);
			ArrayList<Map> activities = new ArrayList<Map>();
			activities = (ArrayList<Map>) session.getAttribute("activities");
			Map<String,String> message = new HashMap<String,String>();
			SimpleDateFormat currentDate = new SimpleDateFormat("EEE, d MMM yyyy h:mm a");
	        String date = currentDate.format(new Date());
			if (earnings<0) {
				message.put("message","You entered the "+ building +" and lost "+earnings+" gold; " + date);
				message.put("color", "red");
			}
			else {
				message.put("message","You entered the "+ building +" and earned "+earnings+" gold; "+ date);
				message.put("color", "green");
			}
		activities.add(0,message);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("activities");
		session.setAttribute("total",0);
		return "redirect:/";
	}
}
