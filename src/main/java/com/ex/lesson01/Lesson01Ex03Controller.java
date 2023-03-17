package com.ex.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // jsp 로 응답할 때는 RestController는 되지 않는다. 뷰화면을 뿌릴 때는 just Only Controller!
public class Lesson01Ex03Controller {
	
	@RequestMapping("/lesson01/ex03")
	public String ex03() {
		// @ResponseBody 없이 단독 @Controller만 사용되는 경우
		// return String(view 경로) ViewResolver 에 의해 jsp 경로를 찾는다.
		
		// 내가 응답할 jsp view의 경로가 온다. 이때 prefix 와 suffix가 적용이됨 (application.properties) 적용이 된 경로를 제외한 String을 반환함.
		return "lesson01/ex03"; 
		
	}
}
