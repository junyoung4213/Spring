<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springstudy.biz.board.BoardDAO" %>
<%@ page import="com.springstudy.biz.board.impl.BoardDAOImpl" %>
<%@ page import="com.springstudy.biz.board.BoardVO" %>

<%
	String seq = request.getParameter("seq");

	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAOImpl();
	boardDAO.deleteBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>