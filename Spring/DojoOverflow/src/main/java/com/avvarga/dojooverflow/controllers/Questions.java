package com.avvarga.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.dojooverflow.models.Answer;
import com.avvarga.dojooverflow.models.Question;
import com.avvarga.dojooverflow.models.Tag;
import com.avvarga.dojooverflow.services.QuestionService;
import com.avvarga.dojooverflow.services.TagService;

@Controller
public class Questions {
	
	private final QuestionService qServ;
	private final TagService tServ;
	
	public Questions (QuestionService qServ, TagService tServ) {
		this.qServ = qServ;
		this.tServ = tServ;
	}
	
	@RequestMapping("/")
	public String index () {
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions")
	public String qDashboard (Model m) {
		m.addAttribute("questions", qServ.findAll());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion (@ModelAttribute ("q") Question question) {
		return "newquestion.jsp";
	}
	
	@PostMapping ("/questions/new")
	public String createQuestion (@Valid @ModelAttribute ("q") Question question, 
			@RequestParam("tags") String tagsGiven,
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return "newquestion.jsp";
		} else {
			String[] tagsList = tagsGiven.split(","); //Splits the input in an array
			List<String> tagsAdded = new ArrayList<String>(Arrays.asList(tagsList)); // converts the array to a list
			if (result.hasErrors() || tagsAdded.size()>3) {
				if(tagsAdded.size()>3) {
					ObjectError error = new ObjectError("tagsGivenMore", "Must be less than 3 tags");
					result.addError(error);
				}
	            return "newQuestion.jsp";
	        }
			Question questiontoAdd = qServ.add(question);
			List<Tag> tags = new ArrayList<Tag>();
			for (int x = 0; x<tagsAdded.size(); x++) { //iterates through the list of the inserted tags
				if(tServ.findTag(tagsAdded.get(x)) == null){ //compares if the tag is already in the db
					tServ.newTag(tagsAdded.get(x)); // if not in DB, adds the tag
					tags.add(tServ.findTag(tagsAdded.get(x))); // adds to the list that we will link to the question
				}else {
					tags.add(tServ.findTag(tagsAdded.get(x)));
				}
			}
			questiontoAdd.setTags(tags);
			qServ.add(questiontoAdd);
			return "redirect:/questions";
		}
	}
	
	@RequestMapping ("/questions/{id}")
	public String showQuestion (@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model m) {
		m.addAttribute("question", qServ.findById(id));
		return "profile.jsp";
	}
}
