<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springstudy.biz.board.BoardDAO" %>
<%@ page import="com.springstudy.biz.board.impl.BoardDAOImpl" %>
<%@ page import="com.springstudy.biz.board.BoardVO" %>
    
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	System.out.println("seq : " + seq);
	
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAOImpl();
	boardDAO.updateBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>