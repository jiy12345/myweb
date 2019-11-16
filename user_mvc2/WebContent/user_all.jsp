<%@page import="domain.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>이름 </td>
			<td>태어난 해</td>
			<td>주소</td>
			<td>핸드폰</td>
		</tr>
			<c:forEach var="vo1" items="${list}">
					<tr>
						<td>${vo1.no}</td>
						<td><a href="get.do?no=${vo1.no}">${vo1.username}</a></td>
						<td>${vo1.birthyear}</td>
						<td>${vo1.addr}</td>
						<td>${vo1.mobile}</td>
					</tr>
			</c:forEach>
	</table>
	<button type = "button" onclick="location.href='user_insert.jsp'">입력</button>
	<button type = "button" onclick="location.href='index.jsp'">메인으로</button>
</body>
</html>