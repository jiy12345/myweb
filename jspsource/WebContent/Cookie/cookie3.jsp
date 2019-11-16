<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String language="korea";
    
    String cookie = request.getHeader("cookie");
    if(cookie!=null){
    	Cookie[] cookies=request.getCookies();
    	
    	
    	for(int i=0;i<cookies.length;i++){
    		if(cookies[i].getName().equals("language")){
    			language=cookies[i].getValue();
    		}
    	}
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>