package com.springApi.springApi.Services;

import java.util.List;

import com.springApi.springApi.Entities.Employee;

public interface IEmployeeServices {
	public List<Employee> getEmployee();
	public Employee getEmployee(long id);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public long deleteEmployee(long parseLong);
}
