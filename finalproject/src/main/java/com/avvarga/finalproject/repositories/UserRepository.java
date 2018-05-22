package com.avvarga.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.finalproject.models.User;

@Repository
public interface UserRepository extends CrudRepository <User,Long> {
	List <User> findAll();
	
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = ?1")
	List<User> findByRole(String string);
}
