<%@page import="DataBase2.UserDAO"%>
<%@page import="DataBase2.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// user_get.jsp에서 no만 가져오기
	int no = Integer.parseInt(request.getParameter("no"));
	Connection con=JDBCUtil.getConnection();
	UserDAO dao=new UserDAO(con);
	
	// UserDAO의 user_delete()를 호출해서 회원 탈퇴
	int result = dao.user_delete(no);
	// 삭제를 성공 했을 시 회원 탈퇴 후 user_all.jsp로 이동	
	if(result>0) {
		JDBCUtil.commit(con);
		response.sendRedirect("user_all.jsp");
	}else{
		out.print("<script>");
		out.print("alert('코드확인');");
		out.print("</script>");
	}
%>