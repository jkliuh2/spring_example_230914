package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {

	@Autowired // DI: 스프링 빈 의존성 주입 => BO에서 온 놈을 받아야 하니까 필요!
	private UsedGoodsBO usedGoodsBO;
	
	// url : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		// map으로 가능하지만, List로 사용 (여러 건이라 List)
		// <> 안에는 DB 테이블 명
		return usedGoodsBO.getUsedGoodsList(); // response => JSON
		// BO의 메소드
	}
}

// 실험 커밋용 주석