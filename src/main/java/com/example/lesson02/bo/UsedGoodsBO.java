package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {

	// input: X(그냥 요청만 들어왔으니까)  (Controller에게 받아온다)
	// output: List<UsedGoods> (Controller에게 준다)(Repository에게 받은 것을)
	public List<UsedGoods> getUsedGoodsList() {
		return ;
	}
}
