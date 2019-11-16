<%@page import="DataBase2.UserDAO"%>
<%@page import="DataBase2.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="DataBase2.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// user_get.jsp에서 넘긴 값 가져오기
	UserVO vo = new UserVO();
	vo.setUsername(request.getParameter("username"));
	vo.setBirthYear(Integer.parseInt(request.getParameter("birthYear")));
	vo.setAddr(request.getParameter("addr"));
	vo.setMobile(request.getParameter("mobile"));
	
	//userDAO의 user_insert호출
	Connection con = JDBCUtil.getConnection();
	UserDAO dao = new UserDAO(con);
	
	//result값을 받아서 1이면 commit한 후 user_all.jsp로 이동
	int result = dao.user_insert(vo);
	if(result>0) {
		JDBCUtil.commit(con);
		response.sendRedirect("user_all.jsp");
	}else{
		//0이면 에러메세지 띄우고 user_insert.jsp로 돌려보내기
		out.print("<script>");
		out.print("alert('데이터 전송 실패');");
		out.print("history.back();");
		out.print("</script>");
	}
%>