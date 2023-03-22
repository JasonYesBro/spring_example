package com.ex.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.lesson03.bo.ReviewBO;
import com.ex.lesson03.model.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// localhost/lesson03/ex02/1
	@RequestMapping("/1") 
	public String ex02_1() {
		
		// 리뷰 자바 객체 생성
		Review review = new Review();
		
		review.setStoreId(7);
		review.setMenu("엽떡 매운맛");
		review.setUserName("jason");
		review.setPoint(4.5);
		review.setReview("개매웠어요 ㅋㅅㅋ");
		
		// 자동으로 DI 된 스프링객체인 reviewBO의 메서드를 불러와 인자로 java객체인 review를 전달함
		int rowCount = reviewBO.addReview(review);
		
		return "성공된 행의 개수 : " + rowCount;
	}

	// localhost/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		
		// 오버로딩할 메서드
		int rowCount = reviewBO.addReviewAsField( 4, "콤비네이션XL", "이재용", 5.0, "맛있어서 돈 따블로 드립니다."); 
		
		return "성공 행 개수 : " + rowCount;
		
	}
	
	
	
	
	
}
