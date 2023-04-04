package com.ex.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.lesson04.bo.UserBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	// http://localhost/lesson06/ex01/add_user_view
	@GetMapping("/ex01/add_user_view")
	public String addUserView() {
		
		return "lesson06/addUser";
	}
	
	// Ajax 통신으로 오는 요청 결과는 반드시 String 이다.
	// @ResponseBody 반드시 있어야 한다.
	@PostMapping("/ex01/add_user")
	@ResponseBody 
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		//insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "성공";
	}
	
	@GetMapping("/ex01/result_view")
	public String resultView() {
		return "lesson06/result";
	}
	
	// http://localhost/lesson06/ex02/add_member_view
	@GetMapping("/ex02/add_member_view")
	public String addNameView() {
		return "lesson06/addMember";
	}
	
	/**
	 * boolean 타입을 이용하여 중복여부를 반환함.
	 * @param name
	 * @return Map<String, Boolean>
	 */
	@GetMapping("/ex02/is_duplication")
	@ResponseBody
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", userBO.existUserByName(name)); // 변수에 저장 했다가 쓰는 방식을 선호
		
		return result;
	}
}

















