package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper // DB와 가장 가까운 놈
public interface UsedGoodsMapper {

	// input : X (BO로부터 받아오는 것)
	// output : (Service한테 주는 것) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList(); // xml의 select에 들어가는 메소드명
	// interface니까 이렇게만.
}
