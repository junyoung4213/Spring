package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;
import com.springstudy.view.controller.Controller;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");

		// 1. 삭제한 seq번호 추출
		String seq = request.getParameter("seq");

		// 2. DB에서 seq에 해당하는 정보 삭제
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAOImpl();
		boardDAO.deleteBoard(vo);

		// 3. 새로운 정보 DB에서 꺼내서 목록 보여주기
		return "getBoardList.do";	
	}
}











