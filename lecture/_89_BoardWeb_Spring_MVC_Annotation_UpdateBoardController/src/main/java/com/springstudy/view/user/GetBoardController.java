package com.springstudy.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

@Controller
public class GetBoardController{

	@RequestMapping(value="getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAOImpl boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");

		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		return mav;
	}
}







