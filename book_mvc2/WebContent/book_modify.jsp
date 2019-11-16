<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h4>가격을 변경할 책의 코드 번호와 가격을 입력하세요</h4>		
	<form method='post' action='modify.do'>	
		<div class="form-row">	
			<div class="form-group col-md-6">  
			 	<input type="text" name="code" class="form-control form-control-lg" required="required" placeholder="코드">
			</div> 
			<div class="form-group col-md-6">  
			 	<input type="text" name="price" class="form-control form-control-lg" required="required" placeholder="가격">
			</div> 
		</div>
		<div class="form-row">
	  	<div class="form-group col-md-6">
			<button type="submit" class="btn btn-primary">입력</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</div>
	  </div>
	</form>
</body>
</html>


