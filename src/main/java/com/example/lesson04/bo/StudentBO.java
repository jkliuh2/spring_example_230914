package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	
	
	// JPA로 Update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// select
		// id에 해당하는 그 정보
		StudentEntity student = studentRepository.findById(id).orElse(null);
		// id에 해당하는 엔티티 하나 가져온다. +) 그 정보 없으면 null로 가져온다. => 이거 없으면 타입이 Optional<>이라서 안됨.
		
		// update - save
		if (student != null) {
			student = student.toBuilder() // 기존 필드값들은 유지하고, 일부 필드만 변경 - toBuilder()
			.dreamJob(dreamJob)
			.build(); // ★★★ 반드시 객체에 다시 저장해야한다.
			
			// update
			student = studentRepository.save(student);
		}
		return student; // student or null
	}
	
	
	// JPA로 Delete
	public void deleteStudentById(int id) {
		// delete는 리턴 없으니 void
		
		// 삭제할 대상 select
		// 방법1) 
		/*
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			studentRepository.delete(student); // delete 실행
		} */
		
		// 방법2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id); // 아예 Optional로 가져옴
		studentOptional.ifPresent(s -> studentRepository.delete(s)); // ★ 람다 문법
		// studentOptional이 s, s가 존재하면(not null) delete(s)를 실행한다는 뜻
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
