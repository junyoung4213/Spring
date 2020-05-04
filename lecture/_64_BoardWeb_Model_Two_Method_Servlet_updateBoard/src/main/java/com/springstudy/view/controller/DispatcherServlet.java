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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트 요청 path 정보를 추출한다
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. 클라이언트 요청 path에 따라 분기한다
		if (path.equals("/login.do")) {
			login(request, response);
		} else if (path.equals("/logout.do")) {
			logout(request, response);
		} else if (path.equals("/insertBoard.do")) {
			insertBoard(request, response);
		} else if (path.equals("/updateBoard.do")) {
			updateBoard(request, response);
		} else if (path.equals("/deleteBoard.do")) {
			deleteBoard(request, response);
		} else if (path.equals("/getBoard.do")) {
			getBoard(request, response);
		} else if (path.equals("/getBoardList.do")) {
			getBoardList(request, response);
		}
	}

	// login.jsp가 처리해달라고 요청하는 업무 담당
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		if (user != null) {
			response.sendRedirect("getBoardList.do");
		}
		// 사용자가 DB에 없을 때
		else {
			response.sendRedirect("login.jsp");
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
	}

	private void insertBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("글 등록 처리");

		// 1. 글 입력 정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		
		// 2. DB에 새글 등록
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAOImpl();
		boardDAO.insertBoard(vo);
		
		// 3. 새로 등록된 글 목록을 보여주자
		response.sendRedirect("getBoardList.do");

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

	private void deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
	}

	private void getBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("글 상세 조회 처리");

		// 1. 상세 정보 확인할 seq번호 추출
		String seq = request.getParameter("seq");

		// 2. DB에서 상세정보 꺼내기
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAOImpl();
		BoardVO board = boardDAO.getBoard(vo);

		// 3. JSP가 읽을 수 있도록 session에 저장한다
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		response.sendRedirect("getBoard.jsp");
	}

	private void getBoardList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("글 목록 검색 처리");

		// 1. 글 목록 정보들을 DB로부터 꺼낸다.
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAOImpl();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 2. JSP가 읽을 수 있도록 공유한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		response.sendRedirect("getBoardList.jsp");
	}

}
