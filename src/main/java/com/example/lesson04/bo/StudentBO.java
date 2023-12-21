package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	// insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// select
	public Student getStudent(Student student) {
		return studentMapper.selectStudent(student);
	}
}
