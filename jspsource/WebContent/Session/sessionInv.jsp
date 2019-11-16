<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 생성된 세션 모두 삭제
	session.invalidate();
	response.sendRedirect("session2.jsp");	
%>