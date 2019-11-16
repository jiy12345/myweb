<%@page import="java.sql.Connection"%>
<%@page import="dbcp.JDBCUtil"%>
<%@page import="dbcp.BookDAO"%>
<%@page import="dbcp.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//book_insert.jsp에서 넘긴 값 가져오기	
	String code = request.getParameter("code");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	int price = Integer.parseInt(request.getParameter("price"));
	
	BookVO vo = new BookVO(code, title, writer, price);
	
	// DB 작업 book_insert()
	Connection con = JDBCUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	int result = dao.book_insert(vo);
	
	//result 결과에 따라 페이지 이동
	if(result>0){
		// 1이면 book_select_result.jsp
		JDBCUtil.commit(con);
		response.sendRedirect("book_select_result.jsp");
	}else{
		// 0이면 이전페이지로 이동
		//0이면 에러메세지 띄우고 user_insert.jsp로 돌려보내기
		out.print("<script>");
		out.print("alert('데이터 전송 실패');");
		out.print("history.back();");
		out.print("</script>");
	}
%>