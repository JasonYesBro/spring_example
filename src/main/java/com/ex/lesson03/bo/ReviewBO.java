package com.ex.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.lesson02.model.UsedGoods;
import com.ex.lesson03.dao.ReviewMapper;
import com.ex.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// Integer 는 null이 허용임 int로 받아야 null이 반드시 아님
	// BO입장에서 id는 무조건 있어야 하므로!
	public Review getReview(int id) {
		
		return reviewMapper.selectReview(id);
	}
}
