<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 장바구니 세션을 가져와서 널이 아니라면 세션 삭제
	if(session.getAttribute("productList")==null){
		out.println("카트가 이미 비어있습니다");
	}else{
		session.invalidate();
		// session.removeAttribute("productList"); 와 같은 의미!
		out.println("카트를 비웠습니다.");
	}
	// cart.jsp로 이동
%>
<h4><a href="cart.jsp">상품선택 페이지</a></h4>