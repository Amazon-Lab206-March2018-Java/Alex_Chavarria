package com.avvarga.loginandreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.loginandreg.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
	User findByEmail (String email);

}
