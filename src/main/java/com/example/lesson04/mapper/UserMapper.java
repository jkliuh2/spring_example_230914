package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper {

	// insert
	public int insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	// 최근 가입자 Select
	public User selectLatestUser();
	
	// 중복확인 눌렀을 때, 중복 확인하는 메소드
	public boolean isDuplicationByName(String name);
}
