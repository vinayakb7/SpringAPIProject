package com.springApi.springApi.Services;

import java.util.List;

import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.Entities.Results;

public interface IEmployeeServices {
	
	public Results<List<Employee>> getEmployee();
	
	public Results<Employee> getEmployee(long id);
	
	public Results<Employee> addEmployee(Employee employee);
	
	public Results<Employee> updateEmployee(Employee employee);
	
	public Results<Long> deleteEmployee(long parseLong);
}
