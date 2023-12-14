package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	// @ResponseBody가 포함되는 경우, 조금 다른 부분이 있다. 주의★

	// url: http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController 사용해 String을 리턴해본다.";
	}
	
	// url: http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; // => JSON으로 리턴
	}
	
	
	// url: http://localhost/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() { // 내가 만든 class Data / 같은 package안에 있어서 오류X
		Data data = new Data(); // 일반 자바 bean(객체)
		data.setId(10);
		data.setName("서동옥");
		
		return data; // 일반 bean 객체도 JSON으로 변환된다.
		// Data의 필드가 일종의 key, value 관계처럼 작동 => JSON
	}
	
	
	// 상태코드번호 지정을 내가 임의로 바꾼다.(앞으로는 안쓸꺼지만 일단 알아두자)
	// url: http://localhost/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		// ResponseEntity: 상태코드번호 지정할 수 있는 클래스
		// <Data>: 리턴되는 타입
		
		Data data = new Data();
		data.setId(11);
		data.setName("바다");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // OK-200. INTERNAL_SERVER_ERROR-500
		// data:리턴하는 것
		// HttpStatus: 상태코드
	}
}
