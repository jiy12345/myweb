<%@page import="DataBase2.UserVO"%>
<%@page import="DataBase2.UserDAO"%>
<%@page import="DataBase2.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// user_get.jsp에서 no, addr 가져오기
	UserVO vo = new UserVO();
	vo.setNo(Integer.parseInt(request.getParameter("no")));
	vo.setAddr(request.getParameter("addr"));
	
	Connection con=JDBCUtil.getConnection();
	UserDAO dao=new UserDAO(con);
	// DAO의 user_update()호출
	int result = dao.user_update(vo);
	// result를 받아서 0보다 크면 commit -> 업데이트 성공
	if(result>0) {
		JDBCUtil.commit(con);
		response.sendRedirect("user_all.jsp");
	}else{
		out.print("<script>");
		out.print("alert('코드확인');");
		out.print("</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>