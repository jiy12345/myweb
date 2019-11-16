<%@page import="java.sql.Connection"%>
<%@page import="dbcp.JDBCUtil"%>
<%@page import="dbcp.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터베이스 작업
	String code = request.getParameter("code");
	int price = Integer.parseInt(request.getParameter("price"));
	
	Connection con = JDBCUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	// book_modify 실행
	int result = dao.book_modify(code, price);
	
	// 어디로 이동할지 결정
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