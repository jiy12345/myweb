<%@page import="dbcp.BookDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="dbcp.JDBCUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	// book_delete.jsp에서 넘긴 코드 값 가져오기
	String code = request.getParameter("code");
	
	// DB 작업하기
	Connection con = JDBCUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	int result = dao.book_delete(code);
	
	// result 값에 의해서 페이지 이동
	if(result>0){
		JDBCUtil.commit(con);
		response.sendRedirect("book_select_result.jsp");
	} else {
		out.print("<script>");
		out.print("alert('코드를 다시 확인해주세요')");
		out.print("history.back();");
		out.print("</script>");
	}

%>