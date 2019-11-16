<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String userId=(String)session.getAttribute("userId");
	
	if(userId==null){
	%>
	<form action="loginProcess2.jsp" method="post">
		아이디 : <input type="text" name="userId"/><br />	
		비밀번호 : <input type="password" name="userPwd"/><br />
		<input type="submit" value="전송" />	
	</form>
	<%}else{
		out.print("<h3>"+userId+"님 반갑습니다. ");
		out.print("<a href='logout.jsp'>로그아웃</a></h3>");
	} %>
</body>
</html>