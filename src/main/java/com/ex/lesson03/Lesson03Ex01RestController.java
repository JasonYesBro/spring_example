package com.ex.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex.lesson03.bo.ReviewBO;
import com.ex.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {
	
	// Autowired 로 DI 했기 때문에 null일 수 없음
	@Autowired
	private ReviewBO reviewBO;
	
	/**
	 * @param id
	 * @return Review
	 */
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			// @RequestParam(value="id") int id // 기본 필수 파라미터
			// @RequestParam(value="id", required = true) int id // 필수 파라미터이기 때문에 required 속성을 추가함(추가하지 않으면 default가 필수임)
			// @RequestParam(value="id", required = false) Integer id // 비필수 파라미터 -> null이 허용이기 때문에 Integer
			// @RequestParam(value="id", defaultValue = "1") int id // 비필수 이지만 결국은 default로 1 값이 넘어가기 때문에 int
			) { // 파라미터가 null일 수 없음
		// json으로 반환
		return reviewBO.getReview(id);
		//return null;
	}
}
