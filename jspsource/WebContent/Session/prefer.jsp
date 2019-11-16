<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>선호도 조사</h3>
	<h4>좋아하는 음식은 <%=session.getAttribute("food") %>이고,
	좋아하는 동물은  <%=request.getParameter("animal") %> 입니다.</h4>
</body>
</html>