package com.ex.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // ResponseBody가 포함되어있는 어노테이션임 @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	
	@RequestMapping("/3")
	public String ex01_3() {
		
		String text = "<h3>@RestController를 사용해서 String 을 리턴해본다.</h3>";
		
		return text;
	}
	
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("wqeq", "as32aa");
		map.put("qweqq", "as213aa");
		map.put("fsad", "asa21a");
		
		return map;
	}
	
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // 일반 자바 bean 객체임
		data.setId(1);
		data.setName("jason");
		
		return data; // json String이 되어나감 RestController 안에있는 Responsebody -> jackson lib 를 통해 json 으로 변환
	}
	
	@RequestMapping("/6")
	// spring에 내장되어있는 객체
	public ResponseEntity<Data> ex01_6() {

		Data data = new Data();
		data.setId(1);
		data.setName("jason");
		
		// 파라미터 첫번째 arg에는 내가 넣고 싶은 데이터 타입을 원하는것으로 넣는다. 두번째 arg에는 상태코드를 넘겨준다. HttpStatus의 field 중 원하는 code로 넘기는게 가능
		//return new ResponseEntity<>(data, HttpStatus.OK);
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
