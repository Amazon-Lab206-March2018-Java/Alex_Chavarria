package com.avvarga.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avvarga.dojooverflow.models.Question;
import com.avvarga.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository qRepo;
	
	public QuestionService (QuestionRepository qRepo) {
		this.qRepo = qRepo;
	}

	public List<Question> findAll() {
		return qRepo.findAll();
	}

	public Question add(Question question) {
		return qRepo.save(question);
	}

	public Question findById(Long id) {
		Optional<Question> question = qRepo.findById(id);
		return question.get();
	}
}
