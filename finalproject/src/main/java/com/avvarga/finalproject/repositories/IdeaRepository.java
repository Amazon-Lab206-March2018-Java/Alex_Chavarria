package com.avvarga.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.finalproject.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository <Idea, Long> {
	List<Idea> findAll();

	@Query("SELECT i FROM Idea i JOIN i.liked l ORDER BY COUNT(l) ASC")
	List<Idea> findAllByOrderByCountAsc();

}
