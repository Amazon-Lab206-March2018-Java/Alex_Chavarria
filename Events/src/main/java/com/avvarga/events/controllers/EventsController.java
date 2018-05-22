package com.avvarga.events.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.events.models.Event;
import com.avvarga.events.models.Message;
import com.avvarga.events.models.User;
import com.avvarga.events.services.EventService;
import com.avvarga.events.services.MessageService;
import com.avvarga.events.services.UserService;

@Controller
public class EventsController {
	
	private final EventService es;
	private final UserService us;
	private final MessageService ms;
	private String[] states = new String[] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

	public EventsController(EventService es, UserService us, MessageService ms) {
		this.es = es;
		this.us = us;
		this.ms = ms;
	}
	
	@PostMapping("/events/create")
	public String create_event(@Valid @ModelAttribute("new_event") Event event, BindingResult res, Model m, Principal p) {
		User u = us.findByEmail(p.getName());
		if (res.hasErrors()) {
			m.addAttribute("states", states);
			m.addAttribute("instate", es.findInState(u.getState()));
	        m.addAttribute("outofstate", es.findOutOfState(u.getState()));
			m.addAttribute("currentUser", u);
			return "dashboard.jsp";
		}else {
			event.setHost(u);
			es.saveEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/events/{id}/join/{user_id}")
	public String join_event(@PathVariable("id") Long id, @PathVariable("user_id") Long user_id, Principal p) {
		Event event = es.findEvent(id);
		User user = us.findUser(user_id);
		List<User> guests = event.getAttendees();
		guests.add(user);
		event.setAttendees(guests);
		es.saveEvent(event);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/cancel")
	public String cancel_rsvp(@PathVariable("id") Long id, Principal p) {
		User user = us.findByEmail(p.getName());
		Event event = es.findEvent(id);
		List<User> guests = event.getAttendees();
		guests.remove(user);
		event.setAttendees(guests);
		es.saveEvent(event);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
	public String edit_event(@PathVariable("id") Long id, Model m) {
		m.addAttribute("states", states);
		m.addAttribute("event", es.findEvent(id));
		return "edit.jsp";
	}
	
	@PostMapping("/events/{id}/update")
	public String update_event(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult res, Model m) {
		if (res.hasErrors()) {
			m.addAttribute("states", states);
			return "edit.jsp";
		}else {
			es.saveEvent(event);
			return "redirect:/events/"+id;
		}
		
	}
	
	@RequestMapping("/events/{id}")
	public String show_event(@PathVariable("id") Long id, Model m) {
		m.addAttribute("event", es.findEvent(id));
		return "show.jsp";
	}
	
	@RequestMapping("/events/{id}/delete")
	public String delete_event(@PathVariable("id") Long id) {
		es.destroyEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/messages/create")
	public String create_message(@PathVariable("id") Long id, @RequestParam("comment") String comment, Principal p) {
		User user = us.findByEmail(p.getName());
		Event event = es.findEvent(id);
		Message mess = new Message();
		mess.setComment(comment);
		mess.setEvent(event);
		mess.setUser(user);
		ms.saveMessage(mess);
		return "redirect:/events/"+id;
	}
}
