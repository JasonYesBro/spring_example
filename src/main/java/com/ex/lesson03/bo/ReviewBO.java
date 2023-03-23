package com.ex.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	// input : Review   output : 성공한 행의 개수 int
	// BO 서비스 레이어이기 때문에 메서드명 add 임
	public int addReview(Review review) {
		
		return reviewMapper.insertReview(review);
	}

	// 관례적으로 컬럼명과 변수명 동일시 함
	// point는 null 이 허용이기 때문에 Wrapper 클래스로 정의
	public int addReviewAsField(int storeId111, String menu111, String userName111, Double point111, String review111) {
		
		return reviewMapper.insertReviewAsField(storeId111, menu111, userName111, point111, review111);
	}

	// 메서드명 mapper쪽과 같음
	public int updateReviewById(int id, String review) {
		
		return reviewMapper.updateReviewById(id, review);
	}

	
	/**
	 * @param id
	 * 삭제하는 쿼리문일 경우 반환타입이 void임
	 */
	public void deleteReviewById(int id) {
		
		reviewMapper.deleteReviewById(id);
	}
}
