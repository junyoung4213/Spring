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
	 * 
	 * 스프링에서는 BoardVO vo와 같은 클라이언트로부터
	 * 전달받은 인자를 담는 vo객체를 Command객체라고 부른다.
	 * title은 BoardVO의 setTitle메서드를 호출해서 값을 저장
	 * writer는 BoardVO의 setWriter메서드를 호출해서 값을 저장
	 * content는 BoardVO의 setContent메서드를 호출해서 값을 저장
	 * 
	 * 매개변수로 BoardDAOImpl 객체를 주입해준다.
	*/
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAOImpl boardDAO) {
		System.out.println("글 등록 처리");
		System.out.println(vo.toString());
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";

	}
}








