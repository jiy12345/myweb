<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action='insert.do'>	
	  <div class="form-group">
	    <label for="code">Code</label>
	    <input type="text" class="form-control" name="code" placeholder="code" required="required">    
	  </div>
	  <div class="form-group">
	    <label for="title">Title</label>
	    <input type="text" class="form-control" name="title" placeholder="title" required="required">
	  </div>
	  <div class="form-group">
	    <label for="writer">Author</label>
	    <input type="text" class="form-control" name="writer" placeholder="writer" required="required">
	  </div>
	  <div class="form-group">
	    <label for="price">Price</label>
	    <input type="number" class="form-control" name="price" placeholder="price" required="required">
	  </div>
	  <button type="submit" class="btn btn-primary">입력</button>
	  <button type="reset" class="btn btn-secondary">취소</button>	
	</form>	
</body>
</html>




