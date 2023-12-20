package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// id=24 행을 삭제할 것임.
	// url: http://localhost/lesson03/ex04?id=24
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam("id") int id) {
		
		reviewBO.deleteReviewById(id);
		// 어차피 BO에서 리턴이 없다(void) 따라서 int로 받을 수 없다.
		
		return "삭제 성공"; // 이번엔 그냥 성공한 행 없이 리턴할 것임.
	}
}
