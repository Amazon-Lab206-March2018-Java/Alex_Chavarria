package com.avvarga.employeesandmanagers.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avvarga.employeesandmanagers.models.Employee;
import com.avvarga.employeesandmanagers.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository eRepo;
	public EmployeeService (EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	public Employee findByName(String fName, String sName) {
		return eRepo.findByFullName(fName,sName);
	}
	
	public void createEmployee (Employee employee) {
		eRepo.save(employee);
	}

	public Employee findById (Long id) {
		Optional<Employee> employee = eRepo.findById(id);
		if (employee == null) {
			return null;
		} else {
			return employee.get();
		}
	}
	
}
