<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action='book_delete_pro.jsp'>
		<h4>삭제할 책의 코드 번호를 입력하세요</h4>	
		<input type="text" name="code" class="form-control form-control-lg" required="required"><br>
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-secondary">취소</button>	
	</form>
</body>
</html>


