package com.springstudy.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardService;
import com.springstudy.biz.board.BoardVO;

/*
 * 이전에 비즈니스 메서드 호출 전에 일일이 추가했던
 * 로그 메서드를 제거하고
 * AOP에 의해서 로그 메서드가 호출되도록 한다
 * 
 * 현재는 biz 로직만 존재하는 상태
*/

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(BoardVO vo) {
		// after-throwing테스트를 위해 일부러 예외 발생
		if(vo!=null)
			throw new IllegalArgumentException("BoardVO객체가 null 아닙니다."); 
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
