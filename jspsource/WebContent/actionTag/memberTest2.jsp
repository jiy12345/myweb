<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	Member member=new Member();
	member.setId(request.getParameter("id")); -> 원래 이렇게 하나씩 받아와야함
	
	member.getId(); -> getProperty 와 같음
	위와같이 자바 코드처럼 쓰는 것을 하지 않기 위해 아래의 액션 코드를
--%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="beans.Member"/>
<jsp:setProperty property="*" name="member"/> 
<%-- proprety="*" 멤버의 모든 변수를 설정해줘라! --%>
<h3>아이디: <jsp:getProperty name="member" property="id"/></h3>
<h3>이름: <jsp:getProperty name="member" property="name"/></h3>
<h3>전화번호: <jsp:getProperty name="member" property="tel"/></h3>