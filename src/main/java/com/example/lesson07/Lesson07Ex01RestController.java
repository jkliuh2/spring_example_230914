package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Ex01RestController {
	// `new_student` 테이블 이용
	
	@Autowired
	private StudentBO studentBO;

	// c: create
	// url: http://localhost/lesson07/ex01/1
	@GetMapping("/ex01/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "bada@naver";
		String dreamJob = "개발자";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
		// JPA는 insert 시킨 그 객체를 바로 가져올 수 있다.
		// 방금 insert된 pk id도 바로 얻어낼 수 있다.
	}
}
