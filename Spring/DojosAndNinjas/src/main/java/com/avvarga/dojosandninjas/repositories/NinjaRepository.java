package com.avvarga.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long> {
	List<Ninja> findAll();

	List<Ninja> findByDojo_id(Long id);
}
