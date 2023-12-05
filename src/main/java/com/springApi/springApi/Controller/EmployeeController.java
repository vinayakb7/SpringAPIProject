package com.springApi.springApi.Controller;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springApi.springApi.Entities.Employee;
import com.springApi.springApi.Entities.Results;
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
	public ResponseEntity<Results<List<Employee>>> getEmployee() {
		Results<List<Employee>> result = new Results<List<Employee>>();
		try {
			result = employeeServices.getEmployee();
			return getResult(result);
		}
		catch (Exception ex) { throw ex; }
	}
	
	/**
	 * This method returns employee based on Id.
	 * @param id
	 * @return Employee Details
	 */
	@GetMapping("/employee/{id}")
	public ResponseEntity<Results<Employee>> getSingleEmployee(@PathVariable int id) {
		Results<Employee> result = new Results<Employee>();
		try {
			result = employeeServices.getEmployee(id);
			return getResult(result);
		}
		catch (Exception ex) { throw ex; }
	}

	/**
	 * This method adds an employee details to DB.
	 * @param employee
	 * @return Added employee details
	 */
	@PostMapping("/employee")
	public ResponseEntity<Results<Employee>> addEmployee(@RequestBody Employee employee) {
		Results<Employee> result = new Results<Employee>();
		try {
			result = employeeServices.addEmployee(employee);
			return getResult(result);
		}
		catch (Exception ex) { throw ex; }
	}
	
	/**
	 * This method to update employee details from DB.
	 * @param employee
	 * @return Updated Employee Details.
	 */
	@PutMapping("/employee")
	public ResponseEntity<Results<Employee>> updateEmployee(@RequestBody Employee employee) {
		Results<Employee> result = new Results<Employee>();
		try {
			result = employeeServices.updateEmployee(employee);
			return getResult(result);
		}
		catch (Exception ex) { throw ex; }
	}
	
	/**
	 * This method deletes employee details from DB based on Id.
	 * @param id
	 */
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Results<Long>> deleteEmployee(@PathVariable long id) {
		Results<Long> result = new Results<Long>();
		try {
			result = employeeServices.deleteEmployee(id);
			return getResult(result);
		}
		catch (Exception ex) { throw ex; }
	}
	
	/**
	 * Method to return ResponseEntity based on response.
	 * if response is success then it return 200 and it fails then it returns 400.
	 * @param <T>
	 * @param result
	 * @return ResponseEntity
	 */
	private <T> ResponseEntity<Results<T>> getResult(Results<T> result){
		if(result.IsSuccessfull) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
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
