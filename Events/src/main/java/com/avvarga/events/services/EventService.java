package com.avvarga.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avvarga.events.models.Event;
import com.avvarga.events.repositories.EventRepository;

@Service
public class EventService {
	
	private final EventRepository er;
	public EventService(EventRepository er) {
		this.er = er;
	}
	
	public void saveEvent(Event e) {
		er.save(e);
	}
	
	public List<Event> findInState(String state){
		return er.findByState(state);
	}
	
	public List<Event> findOutOfState(String state){
		return er.findByStateNotIn(state);
	}
	
	public Event findEvent(Long id) {
		return er.findById(id).get();
	}
	
	public void destroyEvent(Long id) {
		er.deleteById(id);
	}
}
