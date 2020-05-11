package com.springstudy.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/* EntityManager가 제공하는 CRUD 메서드
 * 1) persist(Object entity) : INSERT
 * 2) merge(Object entity) : UPDATE
 * 3) remove(Object entity) : DELETE
 * 4) find(Class<T> entityClass, Object primaryKey) : SELECT ONE(1개 검색)
 * 5) createQuery(String qlString, class<T> resultClass) : SELECT LIST(JPQL에 해당하는 목록 검색)
*/

public class BoardServiceMain {
	public static void main(String[] args) {
		// EntityManager 생성(persistence.xml의 unit name을 넘겨준다)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("a_116_JPAProject");

		EntityManager em = emf.createEntityManager();

		// Transaction 생성
		EntityTransaction tx = em.getTransaction();

		try {
			// Transaction 시작
			tx.begin();

			// 테이블에 데이터를 저장하기
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 홍길동 임꺽정 장길산");
			em.persist(board); // insert

			// 테이블 목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for (Board brd : boardList) {
				System.out.println("---> " + brd.toString());
			}

			// Transaction 완료
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();

	}
}
