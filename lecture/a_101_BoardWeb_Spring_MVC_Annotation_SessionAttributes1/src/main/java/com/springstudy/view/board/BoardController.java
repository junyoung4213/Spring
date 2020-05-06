package com.springstudy.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;


/* updateBoard호출시 vo에는 클라이언트가 전송한 데이터만
 * 주입되어 있고 나머지는 모두 null/0으로 저장되어 있다.
 * 
 * 만약 더 많은 항목을 update하려고 sql을 작성했는데
 * 클라이언트가 가변적으로 데이터를 보낸다면
 * 어떨 때는 모두 값이 존재하지만 어떤 때는 비어있는 값이 
 * 존재하게 된다.
 * 
 * 이럴 때 비어있는 값을 기존의 값으로 채워줘야하고
 * 새로운 값만 갱신해서 update해야 한다.
 * 
 * 이럴 때 @SessionAttributes를 사용한다.
 * 
 * 먼저 1번 항목은 getBoard()메서드가 실행되면 
 * 1차적으로 Model에 "board"라는 이름으로 BoardVO객체가 저장된다.
 * 
 * 2번에서 이 때 @SessionAttributes("board") 설정이 되어있으면
 * Model에 "board"를 찾아서 session공간에서 "board"를 저장하게 된다.
 * 
 * 3번 @ModelAttribute("board") 설정을 해석하여
 * session에 "board"라는 객체가 있는지 확인한다.
 * 있으면 해당 객체를 꺼내서 vo에 할당한다.
 * 그리고 사용자가 새로 보내온 title, content값만 새롭게 
 * 할당된다.
 * 그러므로 사용자가 보내지 않은 나머지 데이터는 기존 데이터를
 * 가진 상태가 된다.
*/
@Controller
@SessionAttributes("board")		// 2번
public class BoardController {
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAOImpl boardDAO) {
		System.out.println("글 등록 처리");
		System.out.println(vo.toString());
		boardDAO.insertBoard(vo);
		return "getBoardList.do";

	}

	// 글 수정
	// @ModelAttribute("board") 이 3번
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAOImpl boardDAO) {
		System.out.println("글 수정 처리");
		System.out.println("vo : " + vo.toString());
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
	@RequestMapping(value = "getBoard.do")
	public String getBoard(BoardVO vo, BoardDAOImpl boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");
		BoardVO board = boardDAO.getBoard(vo);
		// 1번
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}

	// 글 목록 검색
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(
			@RequestParam(value = "searchCondition", defaultValue = "Title", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, BoardVO vo,
			BoardDAOImpl boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
}
