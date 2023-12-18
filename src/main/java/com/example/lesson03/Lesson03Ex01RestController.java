package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
// new_review 테이블에서 id=5 딱 한 건만 가져올 것이다.
	
	@Autowired
	private ReviewBO reviewBO;
	
	// url: http://localhost/lesson03/ex01
	// url: http://localhost/lesson03/ex01?id=7 // id=7이라는 request가 브라우저부터 들어옴
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
//			@RequestParam(value = "id") int id) { 
//		 // id를 requestparam으로 받는다 + null 비허용★(필수 파라미터)
			
//			@RequestParam(value = "id", required = true) int id) {
//		 // 위와 같음. required=true는 생략되어 있다고 보면 된다.
		
//			@RequestParam(value = "id", required = false) Integer id) {
//		// Null 허용★ (비 필수 파라미터) 
//		// => 그냥 이렇게만 하면 BO에서 에러(input이 NULL인 것을 받을 수 없어서 NPE)
//		if (id == null) {
//			id = 1; // null로 와도 BO로 input을 넣기 위해 기본값을 1로 세팅한 것
//		}
		
//			@RequestParam(value = "id", defaultValue = "1") int id) {
//		// 비필수 + 디폴트값 1 => 위의 if문을 추가한 구문
		
			@RequestParam("id") int id) { // (필수 파라미터)
		// required, defaultValue도 사용하지 않을 경우 이렇게 간단하게 사용할 수 있다.
		
		return reviewBO.getReview(id); // BO쪽에 id가 들어간다
	}
}
