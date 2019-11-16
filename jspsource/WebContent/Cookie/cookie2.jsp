<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name", "Hong");
	// 쿠키의 유효시간 설정
	// 유효시간을 설정하지 않으면 브라우저 종료시 삭제된다!
	// 600초 동안 유지!
	cookie.setMaxAge(600);
	response.addCookie(cookie);
%>
<h3>쿠키 데이터가 저장되었습니다.</h3>
<h3><a href="getCookie2.jsp">쿠키데이터 확인하러 가기</a></h3>