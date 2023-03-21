package com.ex.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ex.lesson03.model.Review;

@Repository
public interface ReviewMapper {
	public Review selectReview(@Param("id") int id);
}
