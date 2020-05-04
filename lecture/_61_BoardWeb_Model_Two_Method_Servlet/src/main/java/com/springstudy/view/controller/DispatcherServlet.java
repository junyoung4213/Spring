package com.springstudy.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트 요청 path 정보를 추출한다
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. 클라이언트 요청 path에 따라 분기한다
		if (path.equals("/login.do")) {
			login(request, response);
		} else if (path.equals("/logout.do")) {
			logout(request, response);
		} else if (path.equals("/insertBoard.do")) {
			insertBoard(request, response);
		} else if (path.equals("/updateBoard.do")) {
			updateBoard(request, response);
		} else if (path.equals("/deleteBoard.do")) {
			deleteBoard(request, response);
		} else if (path.equals("/getBoard.do")) {
			getBoard(request, response);
		} else if (path.equals("/getBoardList.do")) {
			getBoardList(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("로그인 처리");
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
	}
	private void insertBoard(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");
	}
	private void updateBoard(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 수정 처리");
	}
	private void deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
	}
	private void getBoard(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
	}
	private void getBoardList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
	}

}
