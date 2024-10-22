package com.ems.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.dto.EmployeeDTO;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.exception.InvalidDataException;
import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public void addEmployee(EmployeeDTO employee) throws InvalidDataException {
		try {
			Employee convertedentity = this.modelMapper.map(employee, Employee.class);
			employeeRepository.save(convertedentity);
		} catch (Exception exception) {
			throw new InvalidDataException("INVALID DATA ENTERED");
		}
	}
	
	public void updateEmployee(EmployeeDTO employee) throws EmployeeNotFoundException, InvalidDataException {
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		try {
			Employee convertedentity = this.modelMapper.map(employee, Employee.class);
			employeeRepository.save(convertedentity);
		} catch (Exception exception) {
			throw new InvalidDataException("INVALID DATA ENTERED");
		}
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> getAllEmployess() {
		List<Employee> empList = employeeRepository.findAll();
		return empList;
	}
	
	public Employee searchEmployee(int id) throws EmployeeNotFoundException {
		Employee emp = employeeRepository.findById(id).orElse(null);
		if(emp==null) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		return emp;
	}
}
