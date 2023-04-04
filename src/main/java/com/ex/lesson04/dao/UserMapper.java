package com.ex.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ex.lesson04.model.User;

@Repository
public interface UserMapper {

	public void insertUser(
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce
			);
	
	public User selectLatestUser();

	// 0: 중복이 아님 1: 중복임(갯수가 존재하는 것)
	public boolean existUserByName(String name);
}
