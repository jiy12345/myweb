<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 객체에 담은 User 가져오기
	User user = (User) session.getAttribute("user");
	// User의 아아이디 출력하기
	out.print(user.getUserId());
%>