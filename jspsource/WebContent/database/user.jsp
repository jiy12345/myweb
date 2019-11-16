<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="user_pro.jsp" method="post">
		<label for="username">이름 </label>
		<input type="text" name="username" id="username"/>
		<br />
		<label for="birthYear">태어난 해 </label>
		<input type="text" name="birthYear" id="birthYear"/>
		<br />
		<label for="addr">주소 </label>
		<input type="text" name="addr" id="addr"/>
		<br />
		<label for="mobile">핸드폰 </label>
		<input type="text" name="moblie" id="mobile"/>
		<br />
		<input type="submit" value="전송" />
		<input type="reset" value="재작성"/>
		</form></div>

</body>
</html>