package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input : id  / output : Review(id=5에 해당하는 딱 하나)
	public Review getReview(int id) { // Controller에서 들어온 input
		return reviewMapper.selectReview(id); // Mapper에 id가 들어감
	}
}
