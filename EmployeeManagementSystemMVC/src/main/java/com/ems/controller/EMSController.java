package com.ems.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ems.dto.EmployeeDTO;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.InvalidDataException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EMSController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/addemployee", method = RequestMethod.GET)
	public String addEmployeePage() {
		return "addemployee";
	}

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") EmployeeDTO employee) throws InvalidDataException {
		employeeService.addEmployee(employee);
		return "addemployee";
	}

	@RequestMapping(value = "/updateemployee", method = RequestMethod.GET)
	public String updateEmployeePage() {
		return "updateemployee";
	}

	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee) throws EmployeeNotFoundException {
		employeeService.updateEmployee(employee);
		return "updateemployee";
	}
	
	
//	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
//	public ModelAndView updateEmployeeFetch(int id) throws EmployeeNotFoundException {
//		Employee emp = employeeService.searchEmployee(id);
//		ModelAndView mav = new ModelAndView("updateemployee");
//		mav.addObject("emp",emp);
//		return mav;
//	}
	
	
	@RequestMapping(value = "/deleteemployee", method = RequestMethod.GET)
	public String deleteEmployeePage() {
		return "deleteemployee";
	}

	@RequestMapping(value = "/deleteemployee", method = RequestMethod.POST)
	public String deleteEmployee(@ModelAttribute("employee") Employee employee) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(employee.getId());
		return "redirect:/viewemployee";
	}
	
	@RequestMapping(value = "/viewemployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee() {
		List<Employee> empList = new ArrayList<Employee>() ;
		empList = employeeService.getAllEmployess();
		ModelAndView mav = new ModelAndView("viewemployees");
		mav.addObject("employeeList",empList);
		return mav;
	}
}
