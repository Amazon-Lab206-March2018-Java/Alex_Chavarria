package com.avvarga.finalproject.comtrollers;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.finalproject.models.User;
import com.avvarga.finalproject.services.IdeaService;
import com.avvarga.finalproject.services.UserService;
import com.avvarga.finalproject.validators.UserValidator;

@Controller
public class Users {

	private UserService uServ;
	private UserValidator uVal;
	private IdeaService iServ;
	
	public Users (UserService uServ, UserValidator uVal, IdeaService iServ) {
		this.uServ = uServ;
		this.uVal = uVal;
		this.iServ = iServ;
	}
	
	@RequestMapping ("/login")
	public String login (@ModelAttribute ("user") User user, @RequestParam (value="error", required=false) String error, @RequestParam (value="logout", required=false) String logout, Model m) {
		if (error != null) {
			m.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			m.addAttribute("logoutMessage", "Logout successful!");
		}
		return "index.jsp";
	}
	
	@PostMapping ("/registration")
	public String registration (@Valid @ModelAttribute("user") User user, BindingResult result, Model m, HttpSession session, HttpServletRequest request) {
		uVal.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			if (uServ.findUserByRole("ROLE_ADMIN") == null) {
				uServ.saveUserWithAdminRole(user);
			} else {
				uServ.saveUserWithUserRole(user);
			}
			try {
				request.login(user.getEmail(), user.getPasswordConfirmation());
			} catch (ServletException e) {
				e.printStackTrace();
			}
			return "redirect:/";
		}
	}
	
	@RequestMapping(value= {"/", "/ideas"})
	public String index (Principal principal, Model m) {
		String username = principal.getName();
		m.addAttribute("currentUser", uServ.findByUsername(username));
		m.addAttribute("ideas", iServ.findAll());
		return "ideas.jsp";
	}
}
