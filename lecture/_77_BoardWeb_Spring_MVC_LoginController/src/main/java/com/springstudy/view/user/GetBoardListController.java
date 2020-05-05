package com.springstudy.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;
import com.springstudy.view.controller.Controller;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");

		// 1. 글 목록 정보들을 DB로부터 꺼낸다.
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAOImpl();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 2. JSP가 읽을 수 있도록 공유한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}
}








