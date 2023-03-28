package com.ex.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		//List<String>
		List<String> fruitList = new ArrayList<>();
		fruitList.add("수박");
		fruitList.add("바나나");
		fruitList.add("참외");
		fruitList.add("포도");
		fruitList.add("멜론");
		
		model.addAttribute("fruits", fruitList);
		//List<Map>
		List<Map<String, Object>> userList = new ArrayList<>();
		
		Map<String, Object> user = new HashMap<>();
		user.put("name", "전승현");
		user.put("age", 28);
		user.put("hobby", "축구");
		
		userList.add(user);
		
		user = new HashMap<>();
		user.put("name", "심규호");
		user.put("age", 28);
		user.put("hobby", "게임");
		
		userList.add(user);
		
		model.addAttribute("users", userList);
		
		return "lesson05/ex02";
	}
}
