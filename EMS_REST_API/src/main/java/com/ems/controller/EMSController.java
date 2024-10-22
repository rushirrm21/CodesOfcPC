package com.ems.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.exception.InvalidDataException;
import com.ems.model.Employee;
import com.ems.pojo.EmployeeInputModel;
import com.ems.pojo.EmployeeOutputModel;
import com.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EMSController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeInputModel employeeInputModel) throws InvalidDataException{
		Employee emp = new Employee();
		emp = employeeService.addEmployee(employeeInputModel);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}

	@PutMapping("/updateemployee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") int employeeId,@RequestBody @Valid Employee employee ) throws EmployeeNotFoundException, com.ems.exception.InvalidDataException {
		employee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(employee , HttpStatus.OK);
	}

	@DeleteMapping("/deleteemployee/{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("employeeId") int employeeId) throws EmployeeNotFoundException{
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>(null , HttpStatus.OK);
	}
	
	@GetMapping("/viewemployee")
	public ResponseEntity<List<EmployeeOutputModel>>  viewEmployee() {
		List<EmployeeOutputModel> empList = new ArrayList<>() ;
		empList = employeeService.getAllEmployess();
		return new ResponseEntity<>(empList , HttpStatus.OK);
	}
}
