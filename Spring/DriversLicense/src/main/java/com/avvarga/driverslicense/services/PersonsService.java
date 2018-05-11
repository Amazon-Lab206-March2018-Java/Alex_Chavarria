package com.avvarga.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avvarga.driverslicense.models.Person;
import com.avvarga.driverslicense.repositories.PersonsRepository;

@Service
public class PersonsService {

	private PersonsRepository pRepository;
	public PersonsService (PersonsRepository pRepository) {
		this.pRepository = pRepository;
	}
	public void addPerson(Person person) {
		pRepository.save(person);
	}
	public List<Person> findAll() {
		return pRepository.findAll();
	}
	public Person findById(Long id) {
		Optional <Person> oPerson = pRepository.findById(id);
		return oPerson.get();
	}

}
