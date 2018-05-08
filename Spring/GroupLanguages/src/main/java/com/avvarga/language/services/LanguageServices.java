package com.avvarga.language.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.avvarga.language.models.Language;

@Service
public class LanguageServices {
	
	ArrayList<Language> languages = new ArrayList<Language>();
	
	public void addLanguage ( Language language ) {
		languages.add(language);
	}
	
	public ArrayList<Language> showLanguages(){
		return languages;
	}
	
	public Language showLanguage (String index) {
		return languages.get(Integer.parseInt(index));
	}
	
	public void updateLanguage (String index, Language language) {
		languages.set(Integer.parseInt(index), language);
	}
	
	public void deleteLanguage (String index, Language language) {
		languages.remove(Integer.parseInt(index));
	}
}
