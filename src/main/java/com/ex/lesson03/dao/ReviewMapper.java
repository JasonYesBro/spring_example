package com.ex.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ex.lesson03.model.Review;

@Repository
public interface ReviewMapper {
	public Review selectReview(@Param("id") int id);
	
	// DB 와 가까운 레이어이기 때문에 메서드명 insert -> insert가 수행되고 나면 알아서 mybatis 가 수행결과 개수를 알려줌
	public int insertReview(Review review);
	
	// @Param 어노테이션이 있기 때문에 하나의 Map 객체가 넘어가는 것과 같음.
	// 여러개의 파라미터가 넘어가기 때문에 @Param 어노테이션 붙인다.
	// @Param으로 넘어가는 value와 mapper.xml 에 들어가는 데이터 값과 무조건 같아야함!
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point,
			@Param("review") String review);

	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);

	// 한개일 경우 @Param 필요없음
	public void deleteReviewById(int id); 
	
}
