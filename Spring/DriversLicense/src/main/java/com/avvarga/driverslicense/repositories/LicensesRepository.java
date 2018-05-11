package com.avvarga.driverslicense.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.driverslicense.models.License;

@Repository
public interface LicensesRepository extends CrudRepository<License, Long> {
	List <License> findAll();

	Optional<License> findByPerson_id(Long id);
}
