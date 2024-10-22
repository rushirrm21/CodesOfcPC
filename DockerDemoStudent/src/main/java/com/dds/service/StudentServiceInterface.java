package com.dds.service;

import java.util.List;

import com.dds.entity.Student;

public interface StudentServiceInterface {

	public Student addNewStudent(Student student);
	
	public Student updateStudent(Student student) throws Exception;
	
	public Student deleteStudent(int id) throws Exception;
	
	public List<Student> showAllStudents();
	
	public boolean findStudent(int id);
	
}
