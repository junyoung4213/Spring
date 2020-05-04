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

		// 2. 클라이언트 요청 path에 따라 분기한다
		if (path.equals("/logout.do"))
			logout(request, response);
		else if (path.equals("/updateBoard.do"))
			updateBoard(request, response);
		else if (path.equals("/deleteBoard.do"))
			deleteBoard(request, response);
		else {
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

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("로그아웃 처리");

		// 1. 브라우저와 연결된 세션 객체를 초기화한다
		HttpSession session = request.getSession();
		session.invalidate();

		// 2. 세션 초기화 후, 로그인 화면으로 이동
		response.sendRedirect("login.jsp");
	}


	private void updateBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("글 수정 처리");

		// 1. 수정할 사용자 정보 추출
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		System.out.println("seq : " + seq);

		// 2. DB에 데이터 수정
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAOImpl();
		boardDAO.updateBoard(vo);

		// 3. 수정된 정보 리스트 확인
		response.sendRedirect("getBoardList.do");
	}

	private void deleteBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("글 삭제 처리");

		// 1. 삭제한 seq번호 추출
		String seq = request.getParameter("seq");

		// 2. DB에서 seq에 해당하는 정보 삭제
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAOImpl();
		boardDAO.deleteBoard(vo);

		// 3. 새로운 정보 DB에서 꺼내서 목록 보여주기
		response.sendRedirect("getBoardList.do");
	}

}
