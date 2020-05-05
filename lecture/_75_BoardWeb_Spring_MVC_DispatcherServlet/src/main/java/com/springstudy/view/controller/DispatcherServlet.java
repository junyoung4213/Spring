package com.springstudy.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;
import com.springstudy.biz.user.UserDAO;
import com.springstudy.biz.user.UserVO;
import com.springstudy.biz.user.impl.UserDAOImpl;

//@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트 요청 path 정보를 추출한다
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. handlerMapping에서 path에 해당하는 Controller
		// 객체를 검색한다
		Controller ctrl = handlerMapping.getController(path);

		// 3. 담당 객체를 실행한다
		String viewName = ctrl.handleRequest(request, response);

		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색
		String view = null;
		if (!viewName.contains(".do")) // jsp 파일인 경우
			view = viewResolver.getView(viewName);
		else // .do 일 경우
			view = viewName;

		// 5. 화면 이동 처리
		response.sendRedirect(view);
	}
}
