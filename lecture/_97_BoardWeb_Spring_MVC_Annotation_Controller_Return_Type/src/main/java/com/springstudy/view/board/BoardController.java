package com.springstudy.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

/* 각 요청을 담당하는 메서드들간에 리턴값이 다르다
 * 기존에는
 * model전달은 없고 view로 전환만 있는 경우는 String 리턴형을
 * model을 view에 전달하기 위해서는 ModelAndView 리턴형을 
 * 사용했다. 
 * 
 * 그러나 프로젝트에서는 일관된 코드를 중요시하게 된다.
 * 그래서 모든 메서드를 동일한 String 리턴형으로 바꾸겠다.
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
	public String getBoard(BoardVO vo, BoardDAOImpl boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");
		BoardVO board = boardDAO.getBoard(vo);
		/* 매개변수로 전달된 model 객체에 값을 넣으면
		 * 스프링은 이 메서드가 리턴된 후 model에서 값을 꺼내서
		 * request에 저장한다.
		 * 그러므로 ModelAndView를 사용하나 이렇게 하나 동일하다.
		 * 다만, 메서드의 일관성을 위해 이렇게 코딩을 하겠다.
		*/
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	// 글 목록 검색
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo , BoardDAOImpl boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
}
