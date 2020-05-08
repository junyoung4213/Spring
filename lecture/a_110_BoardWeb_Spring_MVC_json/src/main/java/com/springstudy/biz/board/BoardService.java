package com.springstudy.biz.board;

import java.io.IOException;
import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	
	// 파일 업로드 기능
	void uploadBoard(BoardVO vo) throws IllegalStateException, IOException;
}
