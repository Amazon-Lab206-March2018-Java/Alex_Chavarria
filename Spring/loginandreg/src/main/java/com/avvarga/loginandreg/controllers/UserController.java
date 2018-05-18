package com.avvarga.loginandreg.controllers;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.loginandreg.models.User;
import com.avvarga.loginandreg.services.UserService;
import com.avvarga.loginandreg.validator.UserValidator;

@Controller
public class UserController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController (UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session, HttpServletRequest request) {
    	userValidator.validate(user, result);
        if (result.hasErrors()) {
        	System.out.println(result);
            return "index.jsp";
        } else {
        	if (userService.findUserByRole("ROLE_ADMIN") == null) {
        		userService.saveUserWithAdminRole(user);
        	} else {
        		userService.saveWithUserRole(user);
        	}
        	try {
				request.login(user.getEmail(), user.getPasswordConfirmation());
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return "redirect:/";        		
        }
    }
    
    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "index.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "dashboard.jsp";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.findAll());
        return "adminPage.jsp";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteUser (@PathVariable("id") Long id ) {
    	userService.deleteById(id);
    	return "redirect:/admin";
    }
    
    @RequestMapping("/makeAdmin/{id}")
    public String makeAdmin (@PathVariable("id") Long id) {
    	User user = userService.findById(id);
    	userService.setAdmin(user);
    	return "redirect:/admin";
    }
}

