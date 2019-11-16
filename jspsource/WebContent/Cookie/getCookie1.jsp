<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
이름 : <%=getCookieValue(cookies, "name")%> <br>
성별 : <%=getCookieValue(cookies, "gender")%> <br>
나이 : <%=getCookieValue(cookies, "age")%> <br>

<%!
	// 원하는 쿠키를 찾는 과정
	private String getCookieValue(Cookie[] cookies, String name){
		if(cookies == null){
			return null;
		}
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(name)){
				return cookie.getValue();
			}
		}
		return null;
	}
%>