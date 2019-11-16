<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 메인 세션으로 다시 돌아왔는지 확인하기 위해
	String name = null;
	if(session.getAttribute("name")!=null){
		name=(String)session.getAttribute("name");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	세가지 모두 버튼 모양으로 나타남 
	
	button을 제외한 나머지 두가지 버튼은 기능을 가지고 있음
	button에 기능을 붙이기 위해서는 script를 붙여야 함!
	
	submit은 form태그안에 사용하여 폼이
	submit은 무조건 보내버리므로 단점이 있음
	submit을 사용한다면 일단 막아놓고 체크 후 보내는 형태로 스크립트로 작성해줘야 함
	
	reset form안에 넣어진 데이터를 모두 초기화 해줌!
	-->
	<h3>세션 테스트</h3>
	<input type="button" value="세션 값 저장" onclick="location.href='sessionSet.jsp'"/>
	<input type="button" value="세션 값 삭제" onclick="location.href='sessionDel.jsp'"/>
	<input type="button" value="세션 값 초기화" onclick="location.href='sessionInv.jsp'"/>
	<input type="submit" value="전송"/>
	<input type="reset" value="초기화"/>
	<h3>현재 세션 정보 : <%=name%></h3>
	<h3>현재 세션 정보 : <%=session.getAttribute("id")%></h3>
</body>
</html>