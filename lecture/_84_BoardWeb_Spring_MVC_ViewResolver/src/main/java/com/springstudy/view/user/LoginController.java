package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springstudy.biz.user.UserDAO;
import com.springstudy.biz.user.UserVO;
import com.springstudy.biz.user.impl.UserDAOImpl;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		ModelAndView mav = new ModelAndView();
		/*viewResolver에 의해 아래처럼 경로가 만들어진다.
		 /WEB-INF/board/getBoardList.do.jsp
		 /WEB-INF/board/login.jsp.jsp
		   
		 현재 viewResolver의 대상은
		 getBoard.jsp와 getBoardList.jsp이고
		 나머지는 적용을 받지 않아야 한다. 
		 
		 redirect: 를 앞에 추가해주면
		 viewResolver의 적용을 받지 않는다.
		 */
		if(user != null){
			mav.setViewName("redirect:getBoardList.do");
			//mav.setViewName("getBoardList.do");
		}
		else{			
			mav.setViewName("redirect:login.jsp");
			//mav.setViewName("login.jsp");
		}	
		
		return mav;
	}
}






