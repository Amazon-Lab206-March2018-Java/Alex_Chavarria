package com.avvarga.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository <Question, Long>{
	List<Question> findAll();
}
