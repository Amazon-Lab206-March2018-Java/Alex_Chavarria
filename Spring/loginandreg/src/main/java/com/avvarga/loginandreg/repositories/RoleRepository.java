package com.avvarga.loginandreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.loginandreg.models.Role;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long>{

	List<Role> findByName(String string);
	

}
