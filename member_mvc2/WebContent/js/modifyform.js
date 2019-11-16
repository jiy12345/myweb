/**
 * modifyForm.jsp 폼 유효성 검증
 */
$(function(){
	$("#modifyform").validate({
		errorPlacement:function(error,element){ //에러메시지 위치 지정
			/*var errorElement=$(element).closest("form").find("label[for='"+element.attr("id")+"']")
				.append(error); //=> 이렇게 하면 기존 메세지 뒤로 붙여지기 때문에*/
			$(element).closest("form").find("small[id='"+element.attr("id")+"']")
				.append(error);
			//errorElement.text().replace(error);나중에 확인해보기	
		},	
		rules:{			
			current_password:{
				required:true,
				validPwd : true,
				validPwdLetter: true
			},
			new_password:{
				required:true,
				validPwd : true,
				validPwdLetter: true				
			},
			confirm_password:{
				required:true,
				validPwd : true,
				validPwdLetter: true,
				equalTo: "#new_password"
			}			
		},
		messages:{			
			current_password:{
				required:"필수 입력 요소입니다.",				
			},
			new_password:{
				required : "필수 입력 요소입니다."				
			},
			confirm_password:{
				required : "필수 입력 요소입니다.",
				equalTo : "이전 비밀번호와 동일하게 입력해주세요"
			}
		}
	});
});
$.validator.addMethod("validPwd", function(value) {
	var regPwd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/; 
	return regPwd.test(value);
}, '비밀번호는 문자,숫자,특수문자를 사용하여 8~15자리까지 사용가능합니다.');
$.validator.addMethod("validPwdLetter", function(value) {
	var regPwd=/(\w)\1\1\1/; 
	return !regPwd.test(value);
}, '동일한 숫자와 문자를 연속으로 사용할 수 없습니다');