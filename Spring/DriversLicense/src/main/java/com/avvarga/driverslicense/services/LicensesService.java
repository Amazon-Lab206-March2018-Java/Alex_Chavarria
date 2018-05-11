package com.avvarga.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avvarga.driverslicense.models.License;
import com.avvarga.driverslicense.repositories.LicensesRepository;

@Service
public class LicensesService {

	private LicensesRepository lRepository;
	public LicensesService (LicensesRepository lRepository) {
		this.lRepository = lRepository;
	}
	
	public void addLicense(License license) {
		lRepository.save(license);
	}
	
	public License findById(Long id) {
		Optional <License> oLicense= lRepository.findByPerson_id(id);
		return oLicense.get();
	}
	
	public List<License> findAll(){
		return lRepository.findAll();
	}
	
}
