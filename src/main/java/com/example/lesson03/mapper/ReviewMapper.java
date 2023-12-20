package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;


@Repository
public interface ReviewMapper {

	// <SELECT>
	// input:id / output:Review
	public Review selectReview(int id); // BO로부터 id input
	
	// <INSERT>
	// input: Review / output: 성공한 행의 갯수(int)
	public int insertReview(Review review);
	// 어차피 파라미터 1개라 @Param 필요 없다
	// 알아서 성공한 행 갯수 리턴한다
	
	// <INSERT> -> 파라미터가 그래도 온 경우 => map으로 XML에 들어간다
	public int insertReviewAsField(
			// 하나의 Map이 된 것 => @Param
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	// <UPDATE>
	// input: id, review / output: int
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	// <DELETE>
	// input: id / output: int(여기선 이걸로) or X(여기서도 output 선택 가능.) 
	public int deleteReviewById(int id);
	// Param이 한개라서 어노테이션 불필요.
}
