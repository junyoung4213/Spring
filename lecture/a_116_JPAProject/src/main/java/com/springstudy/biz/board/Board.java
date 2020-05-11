package com.springstudy.biz.board;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Board
 *
 */

/*
 * @Entity : 엔티티 클래스, 테이블과 매핑된다
 * 			   클래스 명 = 테이블 명
 * @Table  : 클래스 명과 다른 테이블을 매핑시킬 수 있다.
 * @Id 	   : Primary Key, 무조건 있어야 한다
 * @GeneratedValue : @Id가 선언된 필드에 자동으로 생성하여 할당할 때, 
 * 					 h2는 시퀀스를 사용
 * @Temporal : 날짜 타입 변수에 선언하여 날짜 타입을 매핑할 때
 * 			   	DATE	: java.util.Date 타입의 날짜 데이터만 
 * 				TIME 	: 시간 정보
 * 				TIMESTAMP : 날짜와 시간 모두
 * 				중 하나 선택
 * @Column : 필드와 컬럼명이 다를 때,
 * 			   제약조건 설정할 때
 * @GeneratedValue
 * 		- strategy : 자동 생성 유형을 지정한다
 * 			TABLE		: 테이블을 사용하여 PK값 생성
 * 			SEQUENCE	: 오라클, H2 시퀀스 지원하는 데이터베이스
 * 			IDENTIFY	: AUTO_INCREMENT, IDENTITY를 이용해서 PK
 * 						  My_SQL, Maria DB
 * 			AUTO		: 사용중인 데이터베이스에 알맞게 자동으로 PK값 생성
 * 						  (기본 설정)
 * 		- generator : 이미 생성된 Generator이름을 지정
 * 
 * @Transient : 특정 필드를 테이블과 매핑을 하지 않을 때
*/

@SuppressWarnings("serial")
@Entity
@Table(name = "Board")
public class Board implements Serializable {

	@Id
	@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int seq;
//	@Column(name="BOARD_TITLE",nullable=false, length=30)
	private String title;
//	@Column(name = "BOARD_WRITER",updatable=false)
	private String writer;
//	@Column(name="BOARD_CONTENT",nullable = false)
	private String content;
//	@Column(name="BOARD_REG_DATE")
	@Temporal(TemporalType.DATE)
	private Date regDate = new Date();
//	@Column(name="BOARD_CNT")
	private int cnt;
	
	// 클라이언트와 매핑하기 위한 필드
	@Transient
	private String searchCondition;
	@Transient
	private String searchKeyword;
	//@Transient
	//private MultipartFile uploadFile;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
	
	

}
