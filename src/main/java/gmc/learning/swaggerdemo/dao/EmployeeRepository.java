package gmc.learning.swaggerdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.learning.swaggerdemo.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	public List<Employee> findByIsEnabled(Boolean isEnabled);
}
