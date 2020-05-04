<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springstudy.biz.board.impl.BoardDAOImpl" %>
<%@ page import="com.springstudy.biz.board.BoardVO" %>
<%@ page import="com.springstudy.biz.board.BoardDAO" %>
    
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	BoardDAO boardDAO = new BoardDAOImpl();
	boardDAO.insertBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>