<%@page import="domain.UserVO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.js"></script>
</head>
<body>
	<div>
		<form action="user_pro.jsp" method="post" id="myform">
		<label for="username">이름 </label>
		<input type="text" name="username" id="username" value="${vo.username}" readonly="readonly"/>
		<br />
		<label for="birthYear">태어난 해 </label>
		<input type="text" name="birthyear" id="birthyear" value="${vo.birthyear}" readonly="readonly"/>
		<br />
		<label for="addr">주소 </label>
		<input type="text" name="addr" id="addr" value="${vo.addr}"/>
		<br />
		<label for="mobile">핸드폰 </label>
		<input type="text" name="moblie" id="mobile" value="${vo.mobile}"/>
		<br />
		<input type="hidden" name="no" value="${vo.no}" />
		<input type="button" value="수정" id="modify"/>
		<input type="button" value="탈퇴" id="leave"/>
		</form>
	</div>
<script>
	// modify 버튼이 클릭이 되면 user_modify.jsp로 이동
	$("#modify").click(function(){
		$("#myform").attr("action","modify.do");
		$("#myform").submit();
		
	});
	// leave 버튼이 클릭이 되면 user_leave.do로 이동
	$("#leave").click(function(){
		$("#myform").attr("action","leave.do");
		$("#myform").submit();
	});
</script>
</body>
</html>