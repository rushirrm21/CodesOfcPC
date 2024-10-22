package com.dds.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dds.entity.Student;
import com.dds.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addnewstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
	Student s =	studentService.addNewStudent(student);
	return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws Exception{
		Student s =	studentService.updateStudent(student);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) throws Exception{
		Student s = studentService.deleteStudent(id);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
	
	@GetMapping("/getallstudents")
	public ResponseEntity<List<Student>> getallStudents(){
		List<Student> sList = studentService.showAllStudents();
		return new ResponseEntity<List<Student>>(sList,HttpStatus.OK);
		}

}
