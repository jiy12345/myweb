/**
 * joinForm.jsp 검증하기
 */
$(function(){
	$("#joinform").validate({
		errorPlacement:function(error,element){ 
			$(element).closest("form")
			.find("small[id='"+element.attr("id")+"']")
			.append(error);
			},
		rules:{
			userid:{
				required:true,
				validId : true,
				dupId:true
				
				/*remote:{					
			        url: "../checkId.do",
			        type: "post",
			        data: {
			          userid: function() {			        	 
			             return $('#userid').val();
			          }						
			        },
			        success : function(rData, textStatus, xhr) {
			            var chkRst = rData;
			            if(chkRst == 0){
			             alert("등록 가능 합니다.");
			             $("#idChk").val('Y');
			            }else{
			             alert("중복 되어 있습니다.");
			             $("#idChk").val('N');
			            }
			           }
				}			*/					
			},
			password:{
				required:true,
				validPwd : true
			},
			confirm_password:{
				required:true,
				validPwd : true,
				equalTo:"#password"
			},
			name:{
				required:true,
				minlength:2
			},
			gender:{
				required:true,
			},
			email:{
				required:true,
				validEmail:true
			}
		},
		messages:{
			userid:{
				remote: "아이디가 중복입니다.",
				required:"아이디는 필수 입력 요소입니다."				
			},
			password:{
				required:"비밀번호는 필수 입력 요소입니다."				
			},
			confirm_password:{
				required:"비밀번호는 필수 입력 요소입니다."	,				
				equalTo:"이전 비밀번호와 다릅니다."
			},
			name:{
				required:"이름은 필수 입력 요소입니다.",
				minlength:"이름은 최소 2자리는 입력해야 합니다"
			},
			gender:{
				required:"성별은 필수 입력 요소입니다."
			},
			email:{
				required:"이메일은 필수 입력 요소입니다."				
			}
		}
	});	
});
$.validator.addMethod("validId",function(value){
	var regId=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,12}$/;
	return regId.test(value);
},"아이디는 영문 대소문자,숫자를 포함하여 5~12자리 사이로 입력해야 합니다.");
$.validator.addMethod("validPwd",function(value){
	var regPwd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
	return regPwd.test(value);
},"비밀번호는 숫자와 영문자와 특수문자의 조합으로 8~15자리를 사용해야 합니다.");
$.validator.addMethod("validEmail",function(value){
	var regEmail=/^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	return regEmail.test(value);
},'이메일 형식을 확인해 주세요');
$.validator.addMethod("dupId",function(value){
	$.ajax({
        url: '../checkId.do',
        type: 'POST',
        data: {
	          userid: function() {			        	 
	             return ($('#userid').val());
	          }						
	        },
	    success:function(result){
	    	$("#userid").html(result);
	    }
	        
       // dataType: 'text',
        /*success: function(data) {
        	//alert(data);
        	//$.validator.messages.userid = result;
        },
        error: function(jqXHR, satus, error){
            console.log(status, error);
         }*/
    });
},"아이디 중복");







