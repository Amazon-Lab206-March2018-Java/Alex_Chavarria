package com.avvarga.employeesandmanagers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.employeesandmanagers.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee,Long> {
	List<Employee> findAll();

	@Query("SELECT e FROM Employee e WHERE firstName = ?1 AND lastName = ?2")
	Employee findByFullName(String fName, String sName);
}
