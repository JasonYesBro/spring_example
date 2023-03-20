package com.ex.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.lesson02.bo.UsedGoodsBO;
import com.ex.lesson02.model.UsedGoods;

// responseBody가 포함
@RestController
public class Lesson02Ex01RestController {
	
	// bo에서 불러와야하는데 그 또한 스프링빈이기 때문에 @Autowired -> DI
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		
		return usedGoodsList; // 내가 반환하는 것은 List이지만 실제로는 responseBody에 담겨 JSON String 형태로 응답함
	}
	
}


