package com.ems.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ems.dto.EmployeeDTO;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.exception.InvalidDataException;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EMSController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/login")
	public String getUserLogin() {
	return "login";
	}

	@GetMapping("/addemployee")
	public String addEmployeePage() {
		return "addemployee";
	}

	@PostMapping("/addemployee")
	public String addEmployee(@ModelAttribute("employee") EmployeeDTO employee) throws InvalidDataException {
		System.out.println("In add employee");
		employeeService.addEmployee(employee);
		return "addemployee";
	}

	@GetMapping("/updateemployee")
	public String updateEmployeePage() {
		return "updateemployee";
	}

	@PostMapping("/updateemployee")
	public String updateEmployee(@ModelAttribute("employee") EmployeeDTO employee) throws EmployeeNotFoundException, com.ems.exception.InvalidDataException {
		employeeService.updateEmployee(employee);
		return "updateemployee";
	}
		
	@GetMapping("/deleteemployee")
	public String deleteEmployeePage() {
		return "deleteemployee";
	}

	@PostMapping("/deleteemployee")
	public String deleteEmployee(@ModelAttribute("employee") Employee employee) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(employee.getId());
		return "redirect:/";
	}
	
	
	@GetMapping("/")
	public ModelAndView viewEmployee() {
		List<Employee> empList = new ArrayList<Employee>() ;
		empList = employeeService.getAllEmployess();
		ModelAndView mav = new ModelAndView("viewemployees");
		mav.addObject("employeeList",empList);
		return mav;
	}
	
	@PostMapping("/logout")
	public String logoutAdmin() {
		return "login";
	}
}
