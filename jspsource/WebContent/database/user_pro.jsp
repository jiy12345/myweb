<%@page import="java.sql.Connection"%>
<%@page import="DataBase2.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//user.jsp에서 넘긴 값 가져오기  
	UserVO vo = new UserVO();
	
	vo.setUsername(request.getParameter("username"));
	vo.setBirthYear(Integer.parseInt(request.getParameter("birthYear")));
	vo.setAddr(request.getParameter("addr"));
	vo.setMobile(request.getParameter("mobile"));
	
	// 데이터베이스 insert작업
	Connection con = JDBCUtil.getConnection();
	UserDAO dao = new UserDAO(con);
	
	int result = dao.user_insert(vo);
	if(result>0){
		out.print("삽입 성공");
		out.print("<a href='user_all.jsp'>전체 User 보기</a>");
		JDBCUtil.commit(con);
	}
	else{
		out.print("삽입 실패");
		JDBCUtil.rollback(con);
	}
%>