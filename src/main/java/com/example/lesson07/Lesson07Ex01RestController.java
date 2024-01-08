package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	// `new_student` 테이블 이용
	
	@Autowired
	private StudentBO studentBO;

	// c: create
	// url: http://localhost/lesson07/ex01/1
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "bada@naver";
		String dreamJob = "개발자";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
		// JPA는 insert 시킨 그 객체를 바로 가져올 수 있다.
		// 방금 insert된 pk id도 바로 얻어낼 수 있다.
	}
	
	
	// U: Update
	// url: http://localhost/lesson07/ex01/2
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 5번인 dreamJob 변경
		int id = 5;
		String dreamJob = "디자이너";
		
		// input으로 보내는 것: id=5, dreamJob="디자이너"
		return studentBO.updateStudentDreamJobById(id, dreamJob);
	}
	
	
	// D: Delete
	// url: http://localhost/lesson07/ex01/3
	@GetMapping("/3")
	public String delete() {
		// delete는 돌아오는게 없음. 그냥 String으로 "삭제완료" 리턴할것임
		
		// id:5 삭제
		studentBO.deleteStudentById(5);
		
		return "삭제 완료";
	}
}
