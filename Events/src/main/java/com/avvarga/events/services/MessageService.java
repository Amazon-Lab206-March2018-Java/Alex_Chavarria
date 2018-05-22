package com.avvarga.events.services;

import org.springframework.stereotype.Service;

import com.avvarga.events.models.Message;
import com.avvarga.events.repositories.MessageRepo;

@Service
public class MessageService {
	
	private final MessageRepo mr;
	public MessageService(MessageRepo mr) {
		this.mr = mr;
	}
	
	public void saveMessage(Message m) {
		mr.save(m);
	}
}
