<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// sessionSet.jsp에서 담은 세션값 삭제 -> key 하나만 넣어주면 됨
	session.removeAttribute("name");
	// 원래 페이지로 이동
	response.sendRedirect("session2.jsp");
%>