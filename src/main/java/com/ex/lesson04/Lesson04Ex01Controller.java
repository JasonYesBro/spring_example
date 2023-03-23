package com.ex.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.lesson04.bo.UserBO;

/**
 * @author jasonmilian
 * String 을 return 하면 View를 찾을 수 있도록(경로)
 */
@RequestMapping("/lesson04/ex01")
@Controller // jsp view
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// http://localhost/lesson04/ex01/add_user_view (네이밍 규칙 view를 마지막에 붙이면 view로 감)
	@RequestMapping( path="/add_user_view", method = RequestMethod.GET )
	public String addUserView() {
		// /WEB-INF/jsp/lesson04/addUser.jsp
		// 뷰의 경로를 리턴할 뿐이다!
		return "lesson04/addUser";
	}
	
	// http://localhost/lesson04/ex01/add_user 데이터 처리를 하는 주소임
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// insert DB
		// 필드 Insert 방식으로 구현
		userBO.addUserAsField(name, yyyymmdd, email, introduce);
		
		// 결과 jsp view  먼저 requestParam 이 잘 들어오고 결과화면으로 잘 가는지 확인을 한다.	
		return "lesson04/afterAddUser";
	}
	
}
