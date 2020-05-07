package com.springstudy.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springstudy.biz.board.BoardService;
import com.springstudy.biz.board.BoardVO;

/* boardDAO -> boardService로 교체하는 이유
 * 1) boardDAO 업무단위가 단순한 단위
 * 	  boardService 업무단위는 비즈니스 로직에 의한 묶음 단위
 *    BoardController의 코드가 간결하게 된다.
 * 2) boardService의 확장시 Controller의 코드는 변경하지 않고
 * 	  boardService내의 코드만 변경하면 되므로 
 *    시스템 확장이나 저장소의 다양화 등에 유연한 구조를 가지게 
 *    된다.
 * 3) aop 설정 적용
 *    일반적으로 aop는 비즈니스 클래스 메서드에 동작시킨다.
 *    Service 클래스의 메서드가 비즈니스 로직 단위이다.
 *    트랜잭션 단위도 비즈니스 로직 단위로 일어난다
*/

@Controller
@SessionAttributes("board") // 2번
public class BoardController {

	@Autowired
	private BoardService boardService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		System.out.println(vo.toString());
		boardService.insertBoard(vo);
		return "getBoardList.do";

	}

	// 글 수정
	// @ModelAttribute("board") 이 3번
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		System.out.println("vo : " + vo.toString());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping(value = "getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		BoardVO board = boardService.getBoard(vo);
		// 1번
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}

	// 글 목록 검색
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
}
