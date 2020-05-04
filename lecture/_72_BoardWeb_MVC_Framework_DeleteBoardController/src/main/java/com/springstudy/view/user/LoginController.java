package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springstudy.biz.user.UserDAO;
import com.springstudy.biz.user.UserVO;
import com.springstudy.biz.user.impl.UserDAOImpl;
import com.springstudy.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB에 접속해서 사용자가 있는지 확인
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAOImpl();
		UserVO user = userDAO.getUser(vo);
		
		// 사용자가 DB에 있을 때
		// .do면 DispatcherServlet으로 전송
		if(user != null){
			return "getBoardList.do";
		}
		// 사용자가 DB에 없을 때
		// 확장자가 없으면 jsp파일
		else{
			return "login";
		}	
	}
}






