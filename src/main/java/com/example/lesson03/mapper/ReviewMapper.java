package com.example.lesson03.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;


@Repository
public interface ReviewMapper {

	// input:id / output:Review
	public Review selectReview(int id); // BO로부터 id input
}
