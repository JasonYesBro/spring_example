package com.ex.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex03?id=23&review=너무 맛있었어서 3배 아니 5배로 드림 돈이 남아돌아요 ㅎ
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
		
		int rowCnt = reviewBO.updateReviewById(id, review);
		
		return "변경 완료 : " + rowCnt;
	}

}
