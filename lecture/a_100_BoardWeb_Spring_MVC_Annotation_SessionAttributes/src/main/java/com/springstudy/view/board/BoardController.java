package com.springstudy.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	/* @ModelAttribute의 기능
	 * 1) Command객체를 view에 전달할 때 이름 변경시 사용
	 * 2) view에서 사용할 데이터 객체를 만들어서 전달할 때 사용
	 * 	 (@RequestMapping 어노테이션보다 먼저 호출된다. 
	 * 	    자동으로 Model에 저장된다.
	 * 	    스프링은 Model에 저장된 conditionMap을 꺼내서
	 * 	  request에 저장해서 jsp에 전달한다)
	*/
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
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOImpl boardDAO) {
		System.out.println("글 수정 처리");
		/* 별다른 처리를 하지 않으면
		 * vo에는 seq, title, content정보만 들어있고
		 * 나머지는 null이거나 0의 값을 가지고 있다.
		 * 향후 더 많은 항목을 update하는데 클라이언트가
		 * 보내주는 데이터가 가변적일 경우
		 * null이나 0은 DB의 값으로 채워줘야 한다.
		*/
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
		/*
		 * 매개변수로 전달된 model 객체에 값을 넣으면 스프링은 이 메서드가 리턴된 후 model에서 값을 꺼내서 request에 저장한다.
		 * 그러므로 ModelAndView를 사용하나 이렇게 하나 동일하다. 다만, 메서드의 일관성을 위해 이렇게 코딩을 하겠다.
		 */
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}

	/*
	 * 검색요청시 searchCondition과 searchKeyword가 request를 통해 전달된다. 이 때 해당 값을 처리하기 위해 값을
	 * 얻는 방법은 다음 3가지이다 1) BoardVO에 search~ 2개의 필드를 선언하고 getter/setter를 만들면 스프링이 자동으로
	 * 주입시켜준다. 2) 1번을 선택하지 않을 경우는 매개변수로 request를 포함시켜서 직접 request객체로부터 search~
	 * 매개변수값을 추출할 수 있다. 3) @RequestParam을 사용할 수 있다.
	 * 
	 * 여기서는 @RequestParam을 사용해보겠다.
	 */

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
