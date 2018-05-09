package com.avvarga.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avvarga.language.models.Language;
import com.avvarga.language.repositories.LanguageRepo;

@Service
public class LanguageServices {
	
	private LanguageRepo languageRepo;
	public LanguageServices (LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public void addLanguage ( Language language ) {
		languageRepo.save(language);
	}
	
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
	
	public Language showLanguage (Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		return optionalLanguage.get();
	}
	
	public void updateLanguage (Language language) {
		languageRepo.save(language);
	}
	
	public void deleteLanguage (Long id) {
		languageRepo.deleteById(id);
	}
}
