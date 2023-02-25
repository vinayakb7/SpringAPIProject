package com.springApi.springApi.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.dao.EmployeeDao;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeServicesImpl() {
	}
	
	@Override
	public List<Employee> getEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
		return employeeDao.findById(id).get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(long parseLong) {
		Employee entity = employeeDao.findById(parseLong).get();
		employeeDao.delete(entity);
	}
	
	

}
