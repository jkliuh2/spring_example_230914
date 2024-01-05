package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(String name, String phoneNumber, 
			String email, String dreamJob) {
		
		// BO에서 Entity 객체를 생성 ->
		// Builder 기능으로 객체 생성
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략가능
				.build();
		
		return studentRepository.save(student);
		// 내부적으로 insert한 다음 select도 시켜준다
	}
	
	
	/////////////////// 밑으로는 Mybatis
	
	// insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// select
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
