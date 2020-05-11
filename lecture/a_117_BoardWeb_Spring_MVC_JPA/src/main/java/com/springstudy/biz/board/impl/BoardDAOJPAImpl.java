package com.springstudy.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springstudy.biz.board.BoardDAO;
import com.springstudy.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAOJPAImpl implements BoardDAO {

	// EntityManagerFactory 빈이 자동으로 주입한다
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JPA로 insertBoard() 기능 처리");
		em.persist(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JPA로 updateBoard() 기능 처리");
		em.merge(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JPA로 deleteBoard() 기능 처리");
		em.remove(em.find(BoardVO.class, vo.getSeq()));
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JPA로 getBoard() 기능 처리");
		return (BoardVO)em.find(BoardVO.class, vo.getSeq());
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JPA로 getBoardList() 기능 처리");
		String qlString = "from BoardVO b order by b.seq desc";
		return em.createQuery(qlString,BoardVO.class).getResultList();
	}

}
