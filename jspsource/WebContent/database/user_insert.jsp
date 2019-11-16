<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>User 입력</h3>
	<form action="user_insertPro.jsp" method="post">
		<div>
			<label for="username">이름</label>
			<input type="text" name="username" id="username"/>
		</div>
		<div>
			<label for="birthYear">태어난 해</label>
			<input type="text" name="birthYear" id="birthYear"/>
		</div>
		<div>
			<label for="addr">주소</label>
			<input type="text" name="addr" id="addr"/>
		</div>
		<div>
			<label for="mobile">핸드폰</label>
			<input type="text" name="mobile" id="mobile"/>
		</div>
		<div>
			<input type="submit" value="전송" />
			<input type="reset" value="취소"/>
		</div>
	</form>
</body>
</html>