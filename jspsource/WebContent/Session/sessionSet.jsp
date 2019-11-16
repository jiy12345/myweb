<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 임의의 세션 값 담기
	// session에 값을 담고 싶다!
	session.setAttribute("name", "SessionTest!");
	session.setAttribute("id", "hong123");
	// 처음 페이지로 돌아가기
	response.sendRedirect("session2.jsp");
%>