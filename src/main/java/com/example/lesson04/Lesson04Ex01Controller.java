package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // jsp를 내리는 경우, ResponseBody가 있으면 안된다.★
public class Lesson04Ex01Controller {

////// 필드
	@Autowired
	private UserBO userBO;
	
	
//////메소드
	
	// 회원가입 화면(view)
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // jsp view 경로
		// application.properties 에 설정된 접두, 접미 주소 제외한 경로
	}
	
	// 회원가입 insert 진행 => 입력 성공 화면 띄우기
	// 무조건 Post만 받아야 한다.
	@PostMapping("/add-user") // 무조건 Post 방식만 허용하는 RequestMapping
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 가입 완료한 화면 JSP 경로 리턴
		return "lesson04/afterAddUser"; // 가입 완료 화면 경로
		// 중간 확인을 하려면 DB insert 문 작성하지 않고, 여기부터 해 보고 테스트 하자
	}
	
	
	// 최근에 가입된 한 명의 유저
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view") // Get 만 허용
	public String latestUserView(Model model) { // Model: view 화면에 데이터를 넘겨주는 객체
		
		// DB Select => 이것 때문에 DTO 필요
		User user = userBO.getLatestUser();
		
		// Model 주머니에 데이터를 담는다. => 나중에 jsp에서 꺼내 쓴다.
		model.addAttribute("result", user); // 키-value
		model.addAttribute("title", "최근 가입된 유저 정보"); // 다른 정보들도 얼마든지 담을 수 있다.
		
		// jsp 경로 리턴
		return "lesson04/latestUser"; // 결과 화면 jsp
	}
}
