package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {
	
	@Autowired // Dependency Injection(DI): 의존성 주입 / Spring bean을 가져와서 사용하겠다! 라는 뜻.
	private UsedGoodsMapper usedGoodsMapper;
	
	
	// input: X(그냥 요청만 들어왔으니까)  (Controller에게 받아온다)
	// output: List<UsedGoods> (Controller에게 준다)(Repository에게 받은 것을)
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
		// Mapper의 메소드 => Controller에게 [Repository에서 받은 것]을 바로 넘긴다.
		
		// 왜 이렇게까지?) <유지보수>
	}
}
