package com.avvarga.dojosandninjas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.avvarga.dojosandninjas.models.Dojo;
import com.avvarga.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private DojoRepository dRepository;
	
	public DojoService (DojoRepository dRepository) {
		this.dRepository = dRepository;
	}

	public void addDojo(@Valid Dojo dojo) {
		dRepository.save(dojo);
	}

	public List<Dojo> findAll() {
		return dRepository.findAll();
	}

}
