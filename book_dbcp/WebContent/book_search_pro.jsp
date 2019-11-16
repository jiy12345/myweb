<%@page import="dbcp.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dbcp.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="dbcp.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// 값 받아오기
	String criteria = request.getParameter("cirteria");
	String searchword = request.getParameter("searchword");

	// 데이터베이스 작업
	Connection con = JDBCUtil.getConnection();
	BookDAO dao = new BookDAO(con);

	// book_search 실행
	// 결과를 리스트로 받아서 속성 영역에 담고
	ArrayList<BookVO> list = dao.book_search(criteria, searchword);

	// 페이지로 이동하기
	if (!list.isEmpty()) {
		request.setAttribute("list", list);
		pageContext.forward("book_search_result.jsp");
	} else {
		out.print("<script>");
		out.print("alert('찾으시는 책이 존재하지 않습니다.')");
		out.print("history.back();");
		out.print("</script>");
	}
%>
