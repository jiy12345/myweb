<%@page import="DataBase2.UserVO"%>
<%@page import="DataBase2.UserDAO"%>
<%@page import="DataBase2.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// get 방식으로
	// user_all.jsp에서 넘어오는 값 가져오기
	int no = Integer.parseInt(request.getParameter("no"));
	Connection con=JDBCUtil.getConnection();
	UserDAO dao=new UserDAO(con);

	// 전체 회원 목록 가져오기
	UserVO vo = dao.selectOne(no);
	if(vo!=null) {
		out.print(vo);
	}else{
		out.print("번호확인");
	}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.js"></script>
</head>
<body>
	<div>
		<form action="user_pro.jsp" method="post" id="myform">
		<label for="username">이름 </label>
		<input type="text" name="username" id="username" value="<%=vo.getUsername()%>" readonly="readonly"/>
		<br />
		<label for="birthYear">태어난 해 </label>
		<input type="text" name="birthYear" id="birthYear" value="<%=vo.getBirthYear()%>" readonly="readonly"/>
		<br />
		<label for="addr">주소 </label>
		<input type="text" name="addr" id="addr" value="<%=vo.getAddr()%>"/>
		<br />
		<label for="mobile">핸드폰 </label>
		<input type="text" name="moblie" id="mobile" value="<%=vo.getMobile()%>"/>
		<br />
		<input type="hidden" name="no" value="<%=no%>" />
		<input type="button" value="수정" id="modify"/>
		<input type="button" value="탈퇴" id="leave"/>
		</form>
	</div>
<script>
	// modify 버튼이 클릭이 되면 user_modify.jsp로 이동
	$("#modify").click(function(){
		$("#myform").attr("action","user_modify.jsp");
		$("#myform").submit();
		
	});
	// leave 버튼이 클릭이 되면 user_leave.jsp로 이동
	$("#leave").click(function(){
		$("#myform").attr("action","user_leave.jsp");
		$("#myform").submit();
	});
</script>
</body>
</html>