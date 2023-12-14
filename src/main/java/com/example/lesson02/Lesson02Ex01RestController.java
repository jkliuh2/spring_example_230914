package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {

	// url : http://localhost/lesson02/ex01
	@RequestMapping("/localhost/lesson02/ex01")
	public List<UsedGoods> ex01() {
		// map으로 가능하지만, List로 사용 (여러 건이라 List)
		// <> 안에는 DB 테이블 명
		return ; // response => JSON
	}
}

// 실험 커밋용 주석