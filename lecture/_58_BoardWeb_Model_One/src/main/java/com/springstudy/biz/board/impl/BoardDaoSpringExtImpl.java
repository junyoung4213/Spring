package com.springstudy.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;

//@Repository("boardDAO")
public class BoardDaoSpringExtImpl extends JdbcDaoSupport implements BoardDAO {

	// SQL 명령어들
	private final String BOARD_INSERT = "INSERT INTO BOARD(seq,title,writer,content) VALUES((SELECT NVL(MAX(seq),0)+1 FROM board), ?,?,?)";

	private final String BOARD_UPDATE = "UPDATE board SET title = ?, content=? WHERE seq=?";
	private final String BOARD_DELETE = "DELETE board WHERE seq=?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq=?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";

	/*
	 * 이것은 필드에 직접 type이 같은 bean을 찾아서 주입
	 * 
	 * @Autowired DataSource dataSource;
	 */

	/*
	 * Spring Conatiner는 아래 메서드를 자동 호출하는데 매개변수 type을 확인해서bean을 주입한다
	 */
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");

		/*
		 * 아래와 같이 한번에 전달할 수도 있다. Object[] args = {vo.getTitle(), vo.getWriter(),
		 * vo.getContent()}; getJdbcTemplate().update(BOARD_INSERT,args);
		 */

		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = { vo.getSeq() };

		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");

		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}

}

class BoardRowMapper implements RowMapper<BoardVO> {
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
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
