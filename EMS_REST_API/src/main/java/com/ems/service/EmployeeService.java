package com.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.exception.InvalidDataException;
import com.ems.model.Department;
import com.ems.model.Employee;
import com.ems.pojo.EmployeeInputModel;
import com.ems.pojo.EmployeeOutputModel;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.util.EmployeeRowMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Employee addEmployee(EmployeeInputModel employeeInputModel) throws InvalidDataException {
		Department dept = departmentRepository.findById(employeeInputModel.getDeptId()).orElse(null);
		Employee emp = new Employee();
		try {	
			emp.setDepartment(dept);
			emp.setEmail(employeeInputModel.getEmail());
			emp.setFName(employeeInputModel.getFName());
			emp.setLName(employeeInputModel.getLName());
		}
		catch(Exception e) {
		throw new InvalidDataException("INVALID DATA");
	}
			return employeeRepository.save(emp);
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException, InvalidDataException {
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		try {
			return employeeRepository.save(employee);
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
	
	public List<EmployeeOutputModel> getAllEmployess() {
		List<Employee> empList = employeeRepository.findAll();
		List<EmployeeOutputModel> output= new ArrayList<>();
		EmployeeRowMapper mapper = new EmployeeRowMapper();
		for( Employee e:empList) {
			EmployeeOutputModel out = mapper.convertToEmployeeOutputModel(e);
			output.add(out);
		}
		 return output;
	}
	
}
