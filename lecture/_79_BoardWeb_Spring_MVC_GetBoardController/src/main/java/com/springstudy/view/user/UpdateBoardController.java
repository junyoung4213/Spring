package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;
import com.springstudy.view.controller.Controller;

public class UpdateBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		return "getBoardList.do";	
	}
}






