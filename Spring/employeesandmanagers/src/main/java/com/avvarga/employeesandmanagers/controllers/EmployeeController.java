package com.avvarga.employeesandmanagers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avvarga.employeesandmanagers.models.Employee;
import com.avvarga.employeesandmanagers.services.EmployeeService;

@Controller
public class EmployeeController {
	private final EmployeeService eServ;
	
	public EmployeeController (EmployeeService eServ) {
		this.eServ = eServ;
	}
	
	@RequestMapping ("/")
	public void index() {
		Employee man1 = new Employee("Alex","Chavarria");
		Employee emp1 = new Employee("Javier","Villalobos");
		Employee emp2 = new Employee("Victor","Chanto");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		man1.setEmployees(employees);
		emp1.setManager(man1);
		emp2.setManager(man1);
		eServ.createEmployee(man1);
		eServ.createEmployee(emp1);
		eServ.createEmployee(emp2);
		System.out.println("Employees");
		for (Employee employee : man1.getEmployees()) {
			System.out.println(employee.getFirstName() + " " + employee.getLastName());
		}
		System.out.println("Manager");
		System.out.println(emp1.getManager().getFirstName() + " " + emp1.getManager().getLastName());
	}
}
