package com.avvarga.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avvarga.dojooverflow.models.Tag;
import com.avvarga.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	private TagRepository tRepo;
	
	public TagService (TagRepository tRepo) {
		this.tRepo = tRepo;
	}

	public Tag findTagBySubject(String subject) {
		tRepo.findTagBySubject(subject);
		return null;
	}

	public Tag findTag(String subject) {
		return tRepo.findTagBySubject(subject);
	}

	public void newTag(String string) {
		Tag newTag = new Tag(string)
		tRepo.save(newTag);
	}
}
