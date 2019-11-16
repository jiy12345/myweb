<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요!!
	<form action="hello_pro.jsp" method="post">
		<label for="name">이름</label>
		<input type="text" name="name" id="name"/>
		<br />
		<input type="submit" value="전송" />
	</form>
	<form action="hello_pro.jsp" method="post">
		<label for="name">나이</label>
		<input type="text" name="age" id="age"/>
		<br />
		<input type="submit" value="전송" />
	</form>
	<h3>get 전송2</h3>
	<a href="hello_pro.jsp?name=김길동&age=12">get전송2</a>
</body>
</html>