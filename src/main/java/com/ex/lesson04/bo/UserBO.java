package com.ex.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.lesson04.dao.UserMapper;
import com.ex.lesson04.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	public void addUser(String name, String yyyymmdd, String email ,String introduce) {
		
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	public User getLastestUser() {
		
		return userMapper.selectLatestUser();
		
	}
	
	// input : name, output : boolean
	public boolean existUserByName(String name) {
		return userMapper.existUserByName(name);
	}
	
	
}
