package com.example.lesson03.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;


@Repository
public interface ReviewMapper {

	public Review selectReview();
	// id=5 딱 한건이라 ListX
}
