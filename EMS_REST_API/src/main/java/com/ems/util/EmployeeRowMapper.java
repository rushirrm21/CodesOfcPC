package com.ems.util;

import com.ems.model.Employee;
import com.ems.pojo.EmployeeOutputModel;

public class EmployeeRowMapper {

	public EmployeeOutputModel convertToEmployeeOutputModel(Employee employee) {
		EmployeeOutputModel out = new EmployeeOutputModel();
		System.out.println(employee.getId());
		out.setId(employee.getId());
		out.setEmail(employee.getEmail());
		out.setFName(employee.getFName());
		out.setLName(employee.getLName());
		out.setDeptId(employee.getDepartment().getDeptId());
		out.setDeptName(employee.getDepartment().getDeptName());
		return out;
	}
	
}
