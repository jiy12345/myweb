/**
 * login 후 화면 상단에 보여줄 변경 메뉴
 */
$(function(){
	//상단 메뉴 조정
	//register 메뉴 없애고	
	$('#2').detach();
	//Login 메뉴는 없애고
	$('#3').detach();
	//~ 님 반갑습니다.  메뉴는 추가하기
	var $tag="<span class='navbar-text'>"+name+" 님 반갑습니다.</span>&nbsp;&nbsp;"		
	+"<button type='button' id='modify' class='btn btn-success'>비밀번호 수정</button>"
	+"&nbsp;&nbsp;"
	+"<button type='button' id='logout' class='btn btn-primary'>로그아웃</button>"
	+"&nbsp;&nbsp;"
	+"<button type='button' id='leave' class='btn btn-danger'>회원탈퇴</button>";
	$("#navbarCollapse").append($tag);	
});
