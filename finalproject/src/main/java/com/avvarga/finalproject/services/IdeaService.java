package com.avvarga.finalproject.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.avvarga.finalproject.models.Idea;
import com.avvarga.finalproject.repositories.IdeaRepository;

@Service
public class IdeaService {

	private IdeaRepository iRepo;
	
	public IdeaService (IdeaRepository iRepo) {
		this.iRepo = iRepo;
	}

	public void createIdea(@Valid Idea idea) {
		iRepo.save(idea);
		
	}

	public List<Idea> findAll() {
		return iRepo.findAll();
	}

	public Idea findById(Long id) {
		return iRepo.findById(id).get();
	}

	public void updateIdea(Idea idea) {
		iRepo.save(idea);
		
	}

	public void deleteIdea(Idea idea) {
		iRepo.delete(idea);
		
	}

	public List<Idea> findAllByOrderByCountAsc() {
		return iRepo.findAllByOrderByCountAsc();
	}

}
