<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	쿠키는 객체 형태로 담을 수 없으며,
	사용자한테 받아올 때
-->
<%
	// 쿠키 생성하기
	// 쿠키를 브라우저로 넘겨주는 과정
	response.addCookie(new Cookie("name","John"));
	response.addCookie(new Cookie("gender","Male"));
	response.addCookie(new Cookie("age","12"));
%>
<h3>쿠키 데이터가 저장되었습니다.</h3>
<a href="getCookie1.jsp">쿠키 확인하러 가기</a>