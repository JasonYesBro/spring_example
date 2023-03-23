package com.ex.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex04?id=22
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam("id") int id) {
		
		// BO의 메서드를 호출하여 삭제를 요청
		reviewBO.deleteReviewById(id);
		
		// 문자열로 확인만
		return "삭제완료";
	}
}
