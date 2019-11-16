<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글 처리
	request.setCharacterEncoding("utf-8");
	
	// cart.jsp에서 사용자가 선택한 제품 가져오기
	String product = request.getParameter("product");
	
	List<String> productList;
	
	// 세션에 담아놓은 ArrayList를 확인하여(장바구니)
	if(session.getAttribute("productList") == null){
		// 세션에 장바구니가 없다면 새로 생성한다.
		productList = new ArrayList<>();
		session.setAttribute("productList", productList);
	}else{
		productList = (ArrayList<String>)session.getAttribute("productList");
	}
	// 기존 장바구니에 추가하기
	productList.add(product);
	// session에 다시 저장하기
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><a href="cartList.jsp">장바구니 보기</a></h3>
</body>
</html>