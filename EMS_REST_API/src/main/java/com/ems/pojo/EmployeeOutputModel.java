package com.ems.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOutputModel {

	private int id;
	private String fName;
	private String lName;
	private String email;
	private int deptId;
	private String deptName;

}
