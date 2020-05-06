package com.springstudy.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

/* 각 Controller 클래스 별로 흩어져 있는
 * 매핑 메서드를 여기로 집결 시킨다.
 * 통합 관리하고 싶다.
 * */

@Controller
public class BoardController {
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAOImpl boardDAO) {
		System.out.println("글 등록 처리");
		System.out.println(vo.toString());
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";

	}
	
	// 글 수정
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOImpl boardDAO) {
		System.out.println("글 수정 처리");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOImpl boardDAO) {
		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping(value="getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAOImpl boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	// 글 목록 검색
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo , BoardDAOImpl boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}
