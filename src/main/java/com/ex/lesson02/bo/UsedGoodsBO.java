package com.ex.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.lesson02.dao.UsedGoodsMapper;
import com.ex.lesson02.model.UsedGoods;

// 비즈니스 객체임
/**
 * @author jasonmilian
 *	business Object
 */
@Service
public class UsedGoodsBO {
	
	// mapper interface를 불러와야 함. 스프링 빈 객체는 java bean이 아니기 때문에 스프링컨테이너에 가득 들어있는 spring bean 을 불러오는 dependency Injection 인 @Autowired를 추가해줌
	// 스프링컨테이너에 있는 스프링빈을 주입한다.라고 말하는 것임
	@Autowired
	private UsedGoodsMapper usedGoodsMapper;
	
	/**
	 * input x
	 * @return List<UsedGoods>
	 */
	public List<UsedGoods> getUsedGoodsList() {
		// 주입받은 스프링빈을 통해 쿼리문을 수행할 수 있는것임
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList;
	}
}
