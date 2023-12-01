package com.springApi.springApi.Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.Services.IEmployeeServices;

/**
 * Employee Controller.
 */
@RestController
public class EmployeeController {

	private Logger logger = Logger.getLogger("MyControllerLogger");
	@Autowired
	private IEmployeeServices employeeServices;
	
	/**
	 * This is sample API method.
	 * @return String "This is Home"
	 */
	@GetMapping("/home")
	public String home() {
		return "This is Home";
	}
	
	/**
	 * This method returns all employees from DB.
	 * @return all employee details.
	 * @throws Exception 
	 */
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		List<Employee> employee = new ArrayList<>();
		try {
			employee = employeeServices.getEmployee();
			if(employee == null) throw new NullPointerException("Cant find any employee details");
		}
		catch (Exception ex) { throw ex; }
		return employee;
	}
	
	/**
	 * This method returns employee based on Id.
	 * @param id
	 * @return Employee Details
	 */
	@GetMapping("/employee/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		Employee employee;
		try {
			employee = employeeServices.getEmployee(id);
			if(employee == null) throw new NullPointerException("Cant find any employee for id : "+id);
		}
		catch (Exception ex) { throw ex; }
		return employee;
	}

	/**
	 * This method adds an employee details to DB.
	 * @param employee
	 * @return Added employee details
	 */
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employeeDetail;
		try {
			employeeDetail = employeeServices.addEmployee(employee);
			if(employeeDetail == null) throw new NullPointerException("Unable to insert employee for id : "+employee.getId());
		}
		catch (Exception ex) { throw ex; }
		return employeeDetail;
	}
	
	/**
	 * This method to update employee details from DB.
	 * @param employee
	 * @return Updated Employee Details.
	 */
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee employeeDetail;
		try {
			employeeDetail = employeeServices.updateEmployee(employee);
			if(employeeDetail == null) throw new NullPointerException("Unable to update employee details for id : "+employee.getId());
		}
		catch (Exception ex) { throw ex; }
		return employeeDetail;
	}
	
	/**
	 * This method deletes employee details from DB based on Id.
	 * @param id
	 */
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable long id) {
		long employeeId;
		try {
			employeeId = employeeServices.deleteEmployee(id);
			if(employeeId > 0) throw new NullPointerException("Failed to Delete employee with id : "+id);
		}
		catch (Exception ex) { throw ex; }
		return "Employee "+ employeeId +" Deleted Successfully!";
	}
	
	/**
	 * This is sample method to work with lambda in Java.
	 * @return Anything
	 */
	@GetMapping("/getMap")
	public Map<String, Integer> Testing() {
		Pair<String, Integer> pairVariable = new Pair<String, Integer>("String",1);
		String stringFromPair = pairVariable.getValue0();
		int integerFromPair = pairVariable.getValue1();
		List<String> list = Arrays.asList("item1", "item2", "item3");
		logger.info("List is : "+list);
		logger.info("StringFromPair is : "+stringFromPair);
		logger.info("IntFromPair is : "+integerFromPair);
		Map<String, Integer> map = IntStream.range(0, list.size()).boxed().collect(Collectors.toMap(list::get, i -> i));
		return map;
	}
}
