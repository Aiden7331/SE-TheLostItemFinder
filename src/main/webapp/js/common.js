var ctx = "/TheLostItemFinder";
   	 
function login(form){
	var Pw = document.getElementById('inputPw');
	var msg = false;
	$.ajax({
		url: $(form).attr('action'),
		dataType:"json",
		async:true,
		type:$(form).attr('method'),
		data:$(form).serialize(),
		success: function(data){
			if(data['message']=='false'){
				var warning = document.getElementById("warning");
				warning.innerHTML="<div class='alert alert-danger' role='alert'>"+
				"<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>"+
				"<span class='sr-only'>Error:</span> 아이디 혹은 패스워드가 틀렸습니다. </div>";
				msg=false;
				//location.href=ctx+"/login";
				
			}else{
				msg=true;
				location.href=ctx;
			}
		},
		error:function(request,status,error){
			alert('데이터 전송 오류가 발생했습니다.');
			location.reload();
		}
	});
	
	return msg;
}

function logout(){
   	 var query={ };
   	 $.ajax({
   		 type:"POST",
   		 url:ctx+"/logout",
   		 data:query,
   		 success:function(data){
   			 alert("로그아웃 되었습니다.");
   			 location.href=ctx;
   		 }
   	 });
}
