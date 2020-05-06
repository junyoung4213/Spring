package com.springstudy.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

@Controller
public class UpdateBoardController {
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOImpl boardDAO) {
		System.out.println("글 수정 처리");

		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
}






