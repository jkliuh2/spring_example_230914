package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// <SELECT>
	// input : id  / output : Review(id=5에 해당하는 딱 하나)
	public Review getReview(int id) { // Controller에서 들어온 input
		return reviewMapper.selectReview(id); // Mapper에 id가 들어감
	}
	
	// <INSERT>
	// input: Review / output: 성공한 행의 갯수(int)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// <INSERT_2>
//	addReviewAsField(4, "콤비네이션R", "바다", 5.0, "역시 맛있다!")
	public int addReviewAsField(
			int storeId, String menu, 
			String userName, Double point, String review) {
		
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// <UPDATE>
	// input: id, review / output: int(성공 행 개수)
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
}
