package com.springApi.springApi.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.Repository.EmployeeRepository;

/**
 * Service Class for Employee.
 */
@Service
public class EmployeeServices implements IEmployeeServices {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public EmployeeServices() {
	}
	
	/**
	 * This method returns employee from DB.
	 */
	@Override
	public List<Employee> getEmployee() {
		List<Employee> employees;
		try {
			employees = employeeRepo.findAll();
			if(employees == null) throw new NullPointerException("Employee details not found!");
		}
		catch(Exception ex) { throw ex; }
		return employees;
	}

	/**
	 * This method returns employee details based on Id.
	 */
	@Override
	public Employee getEmployee(long id) {
		Employee employee;
		try {
			employee = employeeRepo.findById(id).get();
			if(employee == null) throw new NullPointerException("Employee details not found with id : " + employee.getId());
		}
		catch(Exception ex) { throw ex; }
		return employee;
	}

	/**
	 * This method inserts employee details to DB.
	 */
	@Override
	public Employee addEmployee(Employee employee) {
		Employee employeeDetail = null;
		try {
			employeeDetail = employeeRepo.save(employee);
			if(employeeDetail == null) throw new NullPointerException("Failed to insert Employee details for employee : "+ employee.getName());
		}
		catch (Exception ex) { throw ex; }
		return employeeDetail;
	}
	
	/**
	 * This method updates employee details from DB.
	 */
	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employeeDetail;
		try {
			employeeDetail = employeeRepo.save(employee);
			if(employeeDetail == null) throw new NullPointerException("Failed to update Employee details for employee : " + employee.getName());
		}
		catch (Exception ex) { throw ex; }
		return employeeDetail;
	}

	/**
	 * This method deletes employee from DB based on Id.
	 */
	@Override
	public long deleteEmployee(long parseLong) {
		Employee employee;
		try {
			employee = employeeRepo.findById(parseLong).get();
			if(employee == null) throw new NullPointerException("Employee details not found with id : " + employee.getId());
			else employeeRepo.delete(employee);
		}
		catch(Exception ex) { throw ex; }
		return employee.getId();
	}
}
