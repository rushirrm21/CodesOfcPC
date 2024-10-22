package com.dds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dds.entity.Student;
import com.dds.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addNewStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) throws Exception {
		if (this.findStudent(student.getId())) {
			return studentRepository.save(student);
		}
		throw new Exception("Student Not Found");
	}

	@Override
	public Student deleteStudent(int id) throws Exception {
		if (this.findStudent(id)) {
			Student s= studentRepository.findById(id).orElse(null);
			studentRepository.deleteById(id);
			return s;
		}
		throw new Exception("Student Not Found");
	}

	@Override
	public List<Student> showAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public boolean findStudent(int id) {
		if (studentRepository.findById(id).orElse(null) != null) {
			return true;
		}
		return false;
	}
}
