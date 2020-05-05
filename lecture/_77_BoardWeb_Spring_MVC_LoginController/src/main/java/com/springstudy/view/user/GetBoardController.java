package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;
import com.springstudy.view.controller.Controller;

public class GetBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		return "getBoard";
	}
}







