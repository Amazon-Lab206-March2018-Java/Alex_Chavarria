package com.avvarga.events.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.events.models.Event;
import com.avvarga.events.models.User;
import com.avvarga.events.services.EventService;
import com.avvarga.events.services.UserService;
import com.avvarga.events.validator.UserValidator;

@Controller
public class UsersController {
	
	private final UserService userService;
	private String[] states = new String[] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
	private final UserValidator userValidator;
	private final EventService eventService;
	public UsersController(UserService userService, UserValidator userValidator, EventService eventService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService = eventService;
	}
	
	@RequestMapping("/login")
    public String login_reg(@ModelAttribute("new_user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model m) {
        if (error != null) {
        	m.addAttribute("error", "Invalid Email/Password Combination");
        } else if (logout != null) {
        	m.addAttribute("logout", "Logged out successfully!");
        }
        
		m.addAttribute("states", states);
		return "index.jsp";
    }
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("new_user") User user, BindingResult result, Model model, HttpSession session) {
		System.out.println("here");
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			model.addAttribute("states", states);
			return "index.jsp";
		}else {
			userService.saveWithUserRole(user);
	        return "redirect:/login";
		}
	}
	
	@RequestMapping(value = {"/","/events"})
    public String home(Principal principal, Model model, @ModelAttribute("new_event") Event event) {
        // 1
        String username = principal.getName();
        User u = userService.findByEmail(username);
        model.addAttribute("states", states);
        model.addAttribute("instate", eventService.findInState(u.getState()));
        model.addAttribute("outofstate", eventService.findOutOfState(u.getState()));
        model.addAttribute("currentUser", u);
        return "dashboard.jsp";
    }
}
