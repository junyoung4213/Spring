package com.springstudy.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardService;
import com.springstudy.biz.board.BoardVO;
import com.springstudy.biz.common.log.Log4jAdvice;

/*
 * 기존에 비즈니스 로직 전후에 로그를 출력하기 위해서 
 * 로그 객체를 생성해서 biz로직 전후에 로그 메서드를
 * 호출하는 식으로 프로그래밍 했다.
*/

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

//	private LogAdvice log;
	private Log4jAdvice log;

	public BoardServiceImpl() {
//		log = new LogAdvice();
		log = new Log4jAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
//		log.printLog();
		log.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
//		log.printLog();
		log.printLogging();
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
//		log.printLog();
		log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
//		log.printLog();
		log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
//		log.printLog();
		log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
