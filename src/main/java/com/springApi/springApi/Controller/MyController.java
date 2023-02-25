package com.springApi.springApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.Services.EmployeeServices;

@RestController
public class MyController {

	@Autowired
	private EmployeeServices employeeServices;
	
	@GetMapping("/home")
	public String home() {
		return "This is Home";
	}
	
	//getEmployee
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return this.employeeServices.getEmployee();
	}
	
	//getSingleEmployee
	@GetMapping("/employee/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		return this.employeeServices.getEmployee(id);
	}
	
	//AddEmployee
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeServices.addEmployee(employee);
	}
	
	//UpdateEmployee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(long id) {
		this.employeeServices.deleteEmployee(id);
	}
}
