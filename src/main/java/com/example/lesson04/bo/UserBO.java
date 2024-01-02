package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	// 회원 가입 insert 메소드
	// input: 파라미터들 여러개 / output: X 
	public void addUser(String name, String yyyymmdd, 
			String email, String introduce) {
		
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// 최신 가입자 select 메소드
	// input: X / output: User(있거나 or NULL)
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	// 중복확인 눌렀을 때, 중복 확인하는 메소드
	// input:name / output:boolean (true:중복, false:중복X)
	public boolean isDuplicationByName(String name) {
		return userMapper.isDuplicationByName(name);
	}
}
