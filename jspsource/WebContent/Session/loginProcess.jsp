<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- login.jsp에서 사용자가 입력하는 값을 User객체에 세팅 --%>    
<%-- useBean은 jsp에서 jsp로의 이동에서만 의미가 있음! --%>
<jsp:useBean id="user" class="beans.User"/>  
<jsp:setProperty property="*" name="user"/> 
<!--
	위 코드를 자바 코드로 표현하면
	User user = new User();
	user.setUserId(request.getParameter("userid"));	
	user.setUserPwd(request.getParameter("userid"));		
-->
<%
	// user객체를 세션에 담기 -> 따로따로 담지 않고 한번에 할 수 있다!!
	session.setAttribute("user",user);
	response.sendRedirect("loginOk.jsp");
%> 