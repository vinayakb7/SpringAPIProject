package com.springApi.springApi.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.Entities.Results;
import com.springApi.springApi.Repository.EmployeeRepository;

/**
 * Service Class for Employee.
 */
@Service
public class EmployeeServices extends AServices implements IEmployeeServices {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public EmployeeServices() {
	}
	
	/**
	 * This method returns employee from DB.
	 */
	@Override
	public Results<List<Employee>> getEmployee() {
		Results<List<Employee>> result = new Results<List<Employee>>();
		try {
			List<Employee> employees = employeeRepo.findAll();
			result = getResultObject(employees, employees.isEmpty());
		}
		catch(Exception ex) { 
			throw ex; 
			}
		return result;
	}

	/**
	 * This method returns employee details based on Id.
	 */
	@Override
	public Results<Employee> getEmployee(long id) {
		Results<Employee> result = new Results<Employee>();
		try {
			Employee employee = null;
			if(employeeRepo.existsById(id)) {
				employee = employeeRepo.findById(id).get();
				}
			result = getResultObject(employee, employee == null);
		}
		catch(Exception ex) { throw ex; }
		return result;
	}

	/**
	 * This method inserts employee details to DB.
	 */
	@Override
	public Results<Employee> addEmployee(Employee employee) {
		Results<Employee> result = new Results<Employee>();
		try {
			Employee employeeDetail = employeeRepo.save(employee);
			result = getResultObject(employeeDetail, employeeDetail == null);
		}
		catch (Exception ex) { throw ex; }
		return result;
	}
	
	/**
	 * This method updates employee details from DB.
	 */
	@Override
	public Results<Employee> updateEmployee(Employee employee) {
		Results<Employee> result = new Results<Employee>();
		try {
			Employee employeeDetail = employeeRepo.save(employee);
			result = getResultObject(employeeDetail, employeeDetail == null);
		}
		catch (Exception ex) { throw ex; }
		return result;
	}

	/**
	 * This method deletes employee from DB based on Id.
	 */
	@Override
	public Results<Long> deleteEmployee(long id) {
		Results<Long> result = new Results<Long>();
		try {
			Employee employee = null;
			if(employeeRepo.existsById(id)) {
				employee = employeeRepo.findById(id).get();
				employeeRepo.delete(employee);
				}
			result = getResultObject(employee.getId(), employee == null);
		}
		catch(Exception ex) { throw ex; }
		return result;
	}
}
