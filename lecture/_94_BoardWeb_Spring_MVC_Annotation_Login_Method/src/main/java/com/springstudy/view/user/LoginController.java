package com.springstudy.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springstudy.biz.user.UserVO;
import com.springstudy.biz.user.impl.UserDAOImpl;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		// Command 객체를 request에 저장해준다
		// ${userVO.id}
		// ${userVO.password}
		// 이렇게 login.jsp에서 사용가능하다.
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAOImpl userDAO) {
		System.out.println("로그인 인증 처리...");
		UserVO user = userDAO.getUser(vo);
		if (user != null)
			return "getBoardList.do";
		else
			return "login.jsp";
	}

}
