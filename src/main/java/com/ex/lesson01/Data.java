package com.ex.lesson01;


public class Data {
	// field
	private int id;
	private String name;	
	
	// method
	public int getId() {
		return this.id;
		
	}
	
	// 외부에서 파라미터로 전해지는 값을 은닉화한 필드인 id변수에 할당함
	public void setId(int id) {		
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
