package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {

	// insert
	public void insertStudent(Student student);
	
	// select
	public Student selectStudentById(int id);
}
