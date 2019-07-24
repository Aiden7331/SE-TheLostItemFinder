var ctx="/TheLostItemFinder";
var idcheck=false;
var pwcheck=false;
var nickcheck=false;

  function checkDouble() {
    var input_id=document.getElementById("id");
    var idCheckResult = document.getElementById("notice");
    input_id=input_id.value;
    if(input_id=="") {
        idCheckResult.style.fontColor="red";
        idCheckResult.innerHTML="아이디를 입력해주세요.";
        return ;
    }
    
    $.ajax({
      type:'GET',
      url:"checkDouble",
      data :"id="+input_id,
      async:true,
      dataType:'json',
      success : function(data) {
        if(data['message']=='true') {
          idCheckResult.style="color:green;";
          idCheckResult.innerHTML="사용가능한 아이디입니다.";
          idcheck=true;
        } else{
          idCheckResult.style="color:red;";
          idCheckResult.innerHTML="이미 사용중인 아이디입니다.";
          idcheck=false;
        }
      },
      error : function(error) {
        alert("에러가 발생했습니다.\n에러내용: " + error);
      }
    });
    return false;
  }
  function keydown(pw2){
	  pw = document.getElementById("pw").value;
	  pw_check=pw2.value;
	  message = document.getElementById("keydown");
	  if(pw==pw_check){
		  message.style="color:green";
		  message.innerHTML="비밀번호가 일치합니다";
		  pwcheck=true;
	  }else{
		  message.style="color:red";
		  message.innerHTML="비밀번호가 일치하지 않습니다";
		  pwcheck=false;
	  }
  }
  
  function sending(form){
	  if(idcheck==false){
		  alert("아이디 중복확인을 해주세요");
		  input_ID=document.getElementById("input_ID");
		  input_ID.focus();
		  return false;
	  }else if(pwcheck==false){
		  alert("비밀번호가 일치하지 않습니다");
		  pw= document.getElementById("pw");
		  pw.focus();
		  return false;
	  }
		$.ajax({
			url: $(form).attr('action'),
			dataType:"json",
			async:true,
			type:$(form).attr('method'),
			data:$(form).serialize(),
			success: function(data){
				if(data['message']=='nickname'){
					var nicknameresult= document.getElementById("nicknamecheckresult");
					nicknameresult.innerHTML="중복된 닉네임입니다";
					nicknameresult.focus();
					msg=false;
				}else{
					msg=true;
					location.href=ctx+"/register-3";
				}
			},
			error:function(request,status,error){
				alert('데이터 전송 오류가 발생했습니다.');
				location.reload();
			}
		});
		return msg;
  }