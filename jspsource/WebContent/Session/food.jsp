<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userFavorite" class="beans.UserFavorite"/>  
<jsp:setProperty property="*" name="beans.UserFavorite"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>좋아하는 음식은?</h3>
	<form action="animal.jsp" method="post">
		<input type="text" name="food"/><br />
		<input type="submit" name="전송"/>
	</form>
</body>
</html>