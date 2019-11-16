<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String name = null;
	for(Cookie cookie:cookies){
		if(cookie.getName().equals(name))
			name = cookie.getValue();
	}
	out.print("<h3>쿠키 확인 : " + name);
%>