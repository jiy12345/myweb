<%@page import="domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../layout/header.jsp" %>
<link rel="stylesheet" href="../css/floating-labels.css" />
<%-- session에 정보를 가져와서 정보가 있으면 ~님 반갑습니다.
	 없는 경우 아래 폼이 보이도록 하기 
--%>
<%--
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo !=null){
		out.print(vo.getName()+"님 반갑습니다");
	}
--%>
<c:if test="${empty vo}">
<form class="form-signin" name="loginform" action="../login.do" method="post">
      <div class="form-label-group">
        <input type="text" id="userid" name="userid" class="form-control" placeholder="id" required autofocus>
        <label for="userid">아이디</label>
      </div>

      <div class="form-label-group">
        <input type="password" id="current_password" name="current_password" class="form-control" placeholder="Password" required>
        <label for="pass">비밀번호</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
    </form>
</c:if>
<c:if test = "${!empty vo}">
	<script>
		var name = '${vo.name}'; // 따옴표를 붙여줘야 문자로 인식함!
	</script>
	<script src="../js/menu.js"></script>
	<script src="../js/member.js"></script>
</c:if>
<%@include file="../layout/footer.jsp" %>












