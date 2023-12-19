package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex02RestController {
	
	@Autowired // 이미 만든 것이 있다.
	private ReviewBO reviewBO;

	// url: http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() { // insert 끝나고 문장 리턴할 것임
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("서동옥");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요~");
		
		// BO에 insert 요청
		int rowCount = reviewBO.addReview(review);
		// insert 후 성공한 row 수를 리턴받는다.
		// 중간에(BO같은 곳에서) 숫자를 빼먹을 수도 있다(void). 이 경우 숫자 전달이 안됨
		
		return "성공한 행의 개수: " + rowCount; // String+int => String
	}
	
	
	// input 존재. 파라미터를 그냥 내려보낼 것이다.
	// url: http://localhost/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02_1() {
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "바다", 5.0, "역시 맛있다!");
		return "성공한 행의 개수: " + rowCount;
	}
}
