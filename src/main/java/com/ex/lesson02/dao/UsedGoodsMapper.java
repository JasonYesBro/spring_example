package com.ex.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.lesson02.model.UsedGoods;


/**
 * @author jasonmilian
 * DB에 가장 가까운 영역
 * interface임
 */
@Repository
public interface UsedGoodsMapper {

	/**
	 * 변수명 쿼리문으로 작성하면 됨
	 * @return List<UsedGoods>
	 */
	public List<UsedGoods> selectUsedGoodsList();
}
