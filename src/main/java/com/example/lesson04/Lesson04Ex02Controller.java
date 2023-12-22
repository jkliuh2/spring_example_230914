package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// submit 버튼 누름 -> DB insert -> 가입된 학생 정보 화면(view)
	@PostMapping("/add-student")
	public String addStudent(
			Model model,
			@ModelAttribute Student student) { // 아예 RequestParam을 객체로 한번에 받는다
		// 태그의 name 속성 파라미터와 이름이 같은 필드에 매핑
		// -> 실무에서는 RequestParam으로 하는 편(객체로 받으면 객체의 빈 공간이 많으니까. 명확하게 떨어지는게 좋다고 한다)
		
		// DB에 insert
		studentBO.addStudent(student);
		// xml에서 pk값 가져오기 세팅을 한 덕에 student의 id 필드에 insert된 후 생성된 id값(pk)이 들어갔다.
		
		
		// DB에서 방금 가입된 사용자 select
		// student에 있는 pk값(id)로 select 실행
		int id = student.getId();
		student = studentBO.getStudentById(id);
		// 덮어써도 상관은 없지만, 찝찝하면 새로 객체를 만들어도 무관
		
		// Model 객체에 담는다
		model.addAttribute("student", student);
		
		// 화면 뿌리기 => 테이블
		return "lesson04/afterAddStudent";
	}
}
