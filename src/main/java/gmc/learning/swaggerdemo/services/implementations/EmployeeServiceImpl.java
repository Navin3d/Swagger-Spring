package gmc.learning.swaggerdemo.services.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.learning.swaggerdemo.dao.EmployeeRepository;
import gmc.learning.swaggerdemo.models.Employee;
import gmc.learning.swaggerdemo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees(Boolean activation) {
		List<Employee> allEmployees = employeeRepository.findByIsEnabled(activation);
;		return allEmployees;
	}

	@Override
	public Employee getAEmployee(String employeeId) {
		Employee foundEmployee = employeeRepository.findById(employeeId).get();
		return foundEmployee;
	}

	@Override
	public Employee createEmployee(Employee data) {
		Employee saved = employeeRepository.save(data);
		return saved;
	}

	@Override
	public Employee updateEmployee(Employee updatedData) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Employee existing = getAEmployee(updatedData.getEmployeeId());
		modelMapper.map(updatedData, existing);
		Employee saved = employeeRepository.save(existing);
		return saved;
	}

	@Override
	public void deleteEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
