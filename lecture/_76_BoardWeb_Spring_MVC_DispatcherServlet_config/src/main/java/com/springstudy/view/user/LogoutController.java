package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springstudy.view.controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");

		// 1. 브라우저와 연결된 세션 객체를 초기화한다
		HttpSession session = request.getSession();
		session.invalidate();

		// 2. 세션 초기화 후, 로그인 화면으로 이동
		return "login";
	}
}






