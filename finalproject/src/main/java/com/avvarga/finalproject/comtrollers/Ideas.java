package com.avvarga.finalproject.comtrollers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.avvarga.finalproject.models.Idea;
import com.avvarga.finalproject.models.User;
import com.avvarga.finalproject.services.IdeaService;
import com.avvarga.finalproject.services.UserService;

@Controller
public class Ideas {

		private IdeaService iServ;
		private UserService uServ;
		
		public Ideas (IdeaService iServ, UserService uServ) {
			this.iServ = iServ;
			this.uServ = uServ;
		}
		
		@RequestMapping("/ideas/new")
		public String newIdeas(@ModelAttribute("idea")Idea idea) {
			return "newIdeas.jsp";
		}
		
		@PostMapping ("/ideas/new")
		public String createIdea(@Valid @ModelAttribute ("idea") Idea idea, BindingResult result, Model m, HttpSession session, Principal p) {
			if (result.hasErrors()) {
				return "newIdeas.jsp";
			} else {
				User user = uServ.findByUsername(p.getName());
				idea.setIdeaCreator(user);
				iServ.createIdea(idea);
				return "redirect:/ideas";
			}
		}
		
		@RequestMapping("/ideas/{id}")
		public String showIdea(@PathVariable("id") Long id, Model m, Principal p) {
			m.addAttribute("idea", iServ.findById(id));
			m.addAttribute("currentUser", uServ.findByUsername(p.getName()));
			return "showIdeas.jsp";
		}
		
		@RequestMapping ("/ideas/{id}/edit")
		public String editIdea(@PathVariable ("id") Long id, Model m, @ModelAttribute ("idea") Idea idea, Principal p) {
			if(uServ.findByUsername(p.getName()) == iServ.findById(id).getIdeaCreator()){
				m.addAttribute("idea", iServ.findById(id));	
				return "editIdeas.jsp";
			} else {
				return "redirect:/ideas";
			}
		}
		
		@PostMapping ("/ideas/{id}/edit")
		public String saveIdea (@Valid @ModelAttribute ("idea") Idea idea, BindingResult r, @PathVariable("id") Long id, Principal p) {
			System.out.println("there are errors");
			if(r.hasErrors()) {
				return "editIdeas.jsp";
			}
				Idea i = iServ.findById(id);
				i.setContent(idea.getContent());
				iServ.updateIdea(i);
				return "redirect:/ideas";
			
		}
		
		@RequestMapping ("/ideas/{id}/delete")
		public String deleteIdea (@PathVariable("id") Long id, Principal p) {
			if(uServ.findByUsername(p.getName()) == iServ.findById(id).getIdeaCreator()) {
				Idea idea = iServ.findById(id);
				iServ.deleteIdea(idea);
			}
			return "redirect:/ideas";				
		}
		
		@RequestMapping ("/ideas/{id}/like")
		public String likeIdea(@PathVariable("id") Long id, Principal p) {
			Idea idea = iServ.findById(id);
			User user = uServ.findByUsername(p.getName());
			List<User> liked = idea.getLiked();
			liked.add(user);
			idea.setLiked(liked);
			iServ.updateIdea(idea);
			return "redirect:/ideas";
			
		}
		
		@RequestMapping("/ideas/{id}/unlike")
		public String unlikeIdea (@PathVariable ("id") Long id, Principal p) {
			Idea idea = iServ.findById(id);
			User user = uServ.findByUsername(p.getName());
			List<User> liked = idea.getLiked();
			liked.remove(user);
			idea.setLiked(liked);
			iServ.updateIdea(idea);
			return "redirect:/ideas";
		}
		
}
