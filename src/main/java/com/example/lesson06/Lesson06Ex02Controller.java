package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원 가입 화면
	// url: http://localhost/lesson06/ex02/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "lesson06/ex02AddUser";
	}
	
	// 중복 확인 - AJAX 요청
	@ResponseBody // AJAX는 반드시 이게 있어야 한다.
	@GetMapping("/is-duplication-name")
	public Map<String, Object> isDuplicationName(@RequestParam("name") String name) {
		
		// DB select -> 중복확인 => boolean을 받아오면 된다.
		boolean is_duplication = userBO.isDuplicationByName(name);
		
		// 응답값 만들기
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200); // 성공
		result.put("is_duplication", is_duplication); // 중복 여부(T/F)
		
		// 응답 보내기
		return result;
	}
	
}
