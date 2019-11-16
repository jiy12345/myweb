<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// cartAdd.jsp에서 담은 값 출력하기
	List<String> productList= (ArrayList<String>) session.getAttribute("productList");
	
	if(productList==null){
		out.println("아직 담긴 상품이 없습니다.");
	}else{
		out.print(productList.toString());
	}
%>
<h4><a href="cart.jsp">상품선택 페이지</a></h4>
<h4><a href="cartDel.jsp">장바구니 비우기</a></h4>