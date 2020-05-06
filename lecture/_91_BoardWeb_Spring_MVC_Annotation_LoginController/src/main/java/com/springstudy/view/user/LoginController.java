package com.springstudy.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springstudy.biz.user.UserVO;
import com.springstudy.biz.user.impl.UserDAOImpl;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do")
	public String login(UserVO vo, UserDAOImpl userDAO) {
		System.out.println("로그인 처리");

		UserVO user = userDAO.getUser(vo);

		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}

	}
}
