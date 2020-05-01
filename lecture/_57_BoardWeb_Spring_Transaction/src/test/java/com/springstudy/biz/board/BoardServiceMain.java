package com.springstudy.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceMain {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 LookUp한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. 글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(1000);
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용..............");
		
		// 트랜잭션은 메서드 단위로 이루어지므로
		// 이 메서드내에서 1번째는 성공하지만
		// 2번째가 실패하므로 모두 rollback하는 것을
		// 확인할 수 있다.
		boardService.insertBoard(vo);

		// 4. 글 목록 검색 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);

		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}

		// 5. Spring 컨테이너 종료
		container.close();
	}
}
