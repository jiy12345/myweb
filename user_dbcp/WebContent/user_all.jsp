<%@page import="DataBase2.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="DataBase2.UserDAO"%>
<%@page import="DataBase2.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
			Connection con=JDBCUtil.getConnection();
			UserDAO dao=new UserDAO(con);
	
			// 전체 회원 목록 가져오기
			ArrayList<UserVO> list=dao.selectAll();
			if(!list.isEmpty()) {// list.size()>0
				for(UserVO vo1:list) {
%>
					<tr>
						<td><%=vo1.getNo()%></td>
						<td><a href="user_get.jsp?no=<%=vo1.getNo()%>"><%=vo1.getUsername()%></a></td>
						<td><%=vo1.getBirthYear()%></td>
						<td><%=vo1.getAddr()%></td>
						<td><%=vo1.getMobile()%></td>
					</tr>
<%
				}
			}
%>
	</table>
</body>
</html>