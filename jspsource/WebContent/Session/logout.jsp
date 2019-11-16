<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 해제 후 login.jsp로 이동
	// session.removeAttribute("userId"); -> 특정 정보만 지우기
	// 모든 정보 지우기
	session.invalidate();
	response.sendRedirect("login2.jsp");
%>