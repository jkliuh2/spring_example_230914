package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드 위에 붙은 Path보다 먼저 읽혀진다
@Controller // Spring bean(객체)으로 등록. 이게 없으면 밑의 것들은 아무 의미X
public class Lesson01Ex01Controller {

	// String을 브라우저에 출력
	// url: http://localhost/lesson01/ex01/1
	@RequestMapping("/1") // 여기로 들어오는 요청 매핑
	@ResponseBody // 리턴되는 값을 Response Body로 넣어서 보낸다. => HTML
	public String ex01_1() {
		return "<h2>예제1번</h2>문자열을 Response Body로 보내는 예제";
	}
	
	// Map 출력 => JSON(String) 출력
	// url: http://localhost/lesson01/ex01/2 => 맨 뒤만 다름 
	@RequestMapping("/2") // => 공통부분 class에 앞부분 써놓음.
	public @ResponseBody Map<String, Object> ex01_2() {
		// @ResponseBody 위치가 여기도 가능. 하지만 /1 처럼 올리는게 좋다.
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 4);
		map.put("파인애플", 32);
		map.put("블루베리", 10);
		map.put("코코넛", 4);
		
		// map을 리턴하면 json으로 나타난다.
		// why?) web starter에 jackson 라이브러리가 포함되어 있기 때문
		// @ResponseBody + Map 이 같이 있어서 JSON으로 리턴되는 설정이 적용.
		return map;
	}
}
