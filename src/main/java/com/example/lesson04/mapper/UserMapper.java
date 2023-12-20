package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.domain.User;

@Repository
public interface UserMapper {

	// insert
	public int insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	// 최근 가입자 Select
	public User selectLatestUser();
}
