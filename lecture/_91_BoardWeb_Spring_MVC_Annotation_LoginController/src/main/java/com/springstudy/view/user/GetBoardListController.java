package com.springstudy.view.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

@Controller
public class GetBoardListController{

	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo , BoardDAOImpl boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}








