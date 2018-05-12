package com.avvarga.dojosandninjas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.avvarga.dojosandninjas.models.Ninja;
import com.avvarga.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private NinjaRepository nRepository;
	
	public NinjaService (NinjaRepository nRepository) {
		this.nRepository = nRepository;
	}

	public void addNinja(@Valid Ninja ninja) {
		nRepository.save(ninja);
	}

	public List<Ninja> findByDojo_id(Long id) {
		return nRepository.findByDojo_id(id);
	}
}
