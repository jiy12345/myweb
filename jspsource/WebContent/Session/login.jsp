<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action='loginProcess.jsp' method='post'>
		아이디 : <input type = "text" name = "userid"/><br />
		<!-- password는 가려져서 나옴 -->
		비밀번호 : <input type = "password" name = "userpwd"/><br />
		<input type = "submit" value = "전송"/><br />
	</form>
</body>
</html>