package com.example.lesson04.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson04.domain.Student;

@Repository
public interface StudentMapper {

	// insert
	public void insertStudent(Student student);
	
	// select
	public Student selectStudentById(int id);
}
