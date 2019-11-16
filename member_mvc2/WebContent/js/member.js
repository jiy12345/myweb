/**
 * loginForm.jsp와 logout.jsp와 modifyForm.jsp에서 사용할 버튼 이벤트를 
 * 모아놓은 자바스크립트
 */
$(function(){  
	$("#modify").click(function(){
		location.href='modifyForm.jsp';
	});
	//버튼 클릭시 logout 진행하러 감
	$("#logout").click(function(){
		location.href='../logout.do';
	});
	$("#leave").click(function(){
		location.href='leaveForm.jsp';
	});
	$("#leavecancel").click(function(){
		location.href='loginForm.jsp';
	});
	$("#modifycancel").click(function(){
		location.href='loginForm.jsp';
	});
});
	