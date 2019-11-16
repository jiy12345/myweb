<%@page import="domain.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<UserVO> list = (ArrayList<UserVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.js"></script>
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
			<% 	for(UserVO vo1:list) {	%>
					<tr>
						<td><%=vo1.getNo()%></td>
						<td><a href="get.do?no=<%=vo1.getNo()%>"><%=vo1.getUsername()%></a></td>
						<td><%=vo1.getBirthYear()%></td>
						<td><%=vo1.getAddr()%></td>
						<td><%=vo1.getMobile()%></td>
					</tr>
<%			}%>
	</table>
	<button type = "button" onclick="location.href='user_insert.jsp'">입력</button>
	<button type = "button" onclick="location.href='index.jsp'">메인으로</button>
</body>
</html>