package gmc.learning.swaggerdemo.services;

import java.util.List;

import gmc.learning.swaggerdemo.models.Employee;

public interface EmployeeService {	
	public List<Employee> getAllEmployees(Boolean activation);
	public Employee getAEmployee(String employeeId);
	public Employee createEmployee(Employee data);
	public Employee updateEmployee(Employee updatedData);
	public void deleteEmployee(String employeeId);
}
