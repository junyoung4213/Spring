package com.springstudy.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAOSpringImpl implements BoardDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	private final String BOARD_INSERT = "INSERT INTO" + "\r\n"
			  +	"BOARD(seq,title,writer,content) VALUES(" + "\r\n"
			  + "(SELECT NVL(MAX(seq),0)+1 FROM board)," + "\r\n" 
			  + "?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board" + "\r\n"
			  			+ "SET title=?, content=? WHERE seq=?";
	private final String BOARD_DELETE = "DELETE board WHERE seq=?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq=?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";
		
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC1로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT,
				vo.getTitle(), vo.getWriter(),
				vo.getContent());
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC1로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE,
				vo.getTitle(), vo.getContent(),
				vo.getSeq());
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC1로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC1로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, 
							args, new BoardRowMapper());
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC1로 getBoardList() 기능 처리");
		System.out.println((jdbcTemplate==null ? "null" : "not null"));
		return jdbcTemplate.query(BOARD_LIST, 
							new BoardRowMapper());
	}

	class BoardRowMapper implements RowMapper<BoardVO>{
		public BoardVO mapRow(ResultSet rs, int rowNum) 
								throws SQLException{
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
			return board;
		}
	}	
}















