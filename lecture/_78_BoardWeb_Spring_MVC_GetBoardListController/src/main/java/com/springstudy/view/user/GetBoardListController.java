package com.springstudy.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");

		// 1. 글 목록 정보들을 DB로부터 꺼낸다.
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAOImpl();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 스프링은 mav에 저장된 데이터를 꺼내서 
		// HttpServletRequest에 저장한다
		// jsp파일은 request객체로부터 꺼내서 화면에 보여준다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}








