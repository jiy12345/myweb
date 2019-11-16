<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기는 메뉴2 페이지
	<%
		String userId=(String)session.getAttribute("userId");
		if(userId!=null){
			out.print("<h3>"+userId+"님 반갑습니다. ");
			out.print("<a href='logout.jsp'>로그아웃</a></h3>");
		}else{
			response.sendRedirect("login2.jsp");
		}
	%>
</body>
</html>