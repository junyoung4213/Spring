package com.springstudy.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springstudy.view.user.LoginController;

// url과 담당 클래스를 매핑시키는 역할
public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do",new LoginController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
