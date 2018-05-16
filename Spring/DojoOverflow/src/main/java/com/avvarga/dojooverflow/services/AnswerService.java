package com.avvarga.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.avvarga.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	private AnswerRepository aRepo;
	
	public AnswerService (AnswerRepository aRepo) {
		this.aRepo = aRepo;
	}
}
