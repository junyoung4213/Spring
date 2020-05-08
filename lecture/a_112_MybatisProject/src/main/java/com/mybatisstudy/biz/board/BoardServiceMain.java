package com.mybatisstudy.biz.board;

import java.util.List;

import com.mybatisstudy.biz.board.impl.BoardDAO;

public class BoardServiceMain {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();

		BoardVO vo = new BoardVO();
		vo.setTitle("myBatis 제목");
		vo.setWriter("임꺽정");
		vo.setContent("myBatis 내용입니다......");
		boardDAO.insertBoard(vo);

		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}

	}
}
