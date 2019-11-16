<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// login.jsp에서 넘긴 값 아이디랑 비밀번호 가져오기
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	// id만 세션에 담기
	session.setAttribute("userid", userId);
	// hong123 님 반갑습니다. 로그아웃
%>
<h3><%=userId%> 님 반갑습니다. <a href='logout.jsp'>로그아웃</a></h3>
<ul>
	<li><a href="menu1.jsp">메뉴1</a></li>
	<li><a href="menu2.jsp">메뉴2</a></li>	
</ul>