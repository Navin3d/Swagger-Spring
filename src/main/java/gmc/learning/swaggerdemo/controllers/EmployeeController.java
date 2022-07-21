package gmc.learning.swaggerdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmc.learning.swaggerdemo.models.Employee;
import gmc.learning.swaggerdemo.services.EmployeeService;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	private ResponseEntity<List<Employee>> getAllEmployees() {
		
		List<Employee> allEmployees = employeeService.getAllEmployees(true);
		
		return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
	}
	
	@GetMapping("/{employeeId}")
	private ResponseEntity<Employee> getAEmployee(@PathVariable String employeeId) {
		Employee aEmployee = employeeService.getAEmployee(employeeId);
		
		return ResponseEntity.status(HttpStatus.OK).body(aEmployee);
	}
	
	@PostMapping
	private ResponseEntity<Employee> createEmployee(@RequestBody Employee newData) {
		Employee createdEmployee = employeeService.createEmployee(newData);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
	}
	
	@PutMapping
	private ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedData) {
		Employee updatedEmployee = employeeService.updateEmployee(updatedData);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
	}
	
	@DeleteMapping("/{employeeId}")
	private ResponseEntity<String> deleteAEmployee(@PathVariable String employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body("Employee data deleted...");
	}

}
