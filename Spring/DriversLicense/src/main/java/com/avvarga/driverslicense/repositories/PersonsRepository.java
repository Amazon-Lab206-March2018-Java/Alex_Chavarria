package com.avvarga.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.driverslicense.models.Person;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Long>{
	List <Person> findAll();
}
