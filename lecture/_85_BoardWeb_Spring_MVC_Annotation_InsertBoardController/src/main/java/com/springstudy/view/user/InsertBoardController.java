package com.springstudy.view.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.board.impl.BoardDAOImpl;

/* @Controller는 @Component의 상속을 받은 어노테이션이다
 * 그러므로 presentation-layer.xml의 
 * <context:component-scan>에 의해 자동으로 bean으로 등록된다
 * 
 * 또, DispatcherServlet이 인식하는 Controller객체로 만들어진다
*/

@Controller
public class InsertBoardController {

	/* DispatcherServlet은 아래 주소로 요청이 들어오면
	 * 아래 메서드를 자동으로 호출해준다.
	 * 
	 * 메서드의 매개변수 타입을 조사해서 자동으로 객체를
	 * 주입해준다.
	*/
	@RequestMapping(value="/insertBoard.do")
	public void insertBoard(HttpServletRequest request) {
		System.out.println("글 등록 처리");

		// 1. 글 입력 정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 2. DB에 새글 등록
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAOImpl();
		boardDAO.insertBoard(vo);

	}
}








