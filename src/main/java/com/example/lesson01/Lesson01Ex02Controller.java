package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 최종적으로. JSP로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안된다!!!(@RestController도 안된다)
public class Lesson01Ex02Controller {

	// url: http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // Request path 주소
	public String ex02() { // 리턴 타입은 String으로 해야한다.
		// return 되는 String은 jsp의 경로이다.(@ResponseBody 없을 때)
		
//		return "/WEB-INF/jsp/lesson01/ex02.jsp"; // application.properties에 설정을 안하면 써야하는 주소
		return "lesson01/ex02"; // 이것만 써줘도 된다.(설정을 했으니까) 
		// Response view 경로
	}
}
