<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String food = request.getParameter("food");
	//prefer.jsp에서 필요한 값이기 때문에 세션에 담기
	session.setAttribute("food", food);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>좋이하는 동물은?</h3>
	<form action="prefer.jsp" method="post">
		<input type="text" name="animal"/><br />
		<input type="submit" name="전송" />
	</form>	
</body>
</html>
