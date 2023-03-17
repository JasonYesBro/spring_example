package com.ex.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 공통으로 들어갈 url을 따로 뺴서 동작하게끔 설정함
@Controller
public class Lesson01Ex01Controller {
		
	@RequestMapping("/1") // url path 매핑
	@ResponseBody // 순서 상관 없음 리턴되는 String이 통쨰로 ResponseBody에 담긴다.
	public String ex01_1() {
		String text = "예제 1번 <br> 문자열을 responsebody에 보내는 예제";
		
		return text;
	}
	
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	//@ResponseBody
	public @ResponseBody Map<String, Object> ex01_2() { // 데이터타입 앞에 어노테이션이 올수 있지만 구 방식임
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("망고", 1);
		map.put("사과", 2);
		map.put("수박", 5);
		map.put("참외", 3);
		
		// map 을 리턴하였지만 json 형태로 값이 넘어감
		// boot-starter-web 안에 있는 jackson lib 가 있어서 json으로 자동으로 변환해주어 동작함
		return map;
	}
}
