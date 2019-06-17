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

function free(id){
	if(confirm("정말 글을 삭제하겠습니까?")){
	$.ajax({
		type:'POST',
		url:ctx+'/deleteitem',
		contentType:'application/json',
		data:{"seq":id},
		success:function(data){
			alert("글이 삭제되었습니다");
			location.href=ctx+"/board";
		},error:function(request,status,error){
			alert("다시 시도하세요 (error Name = "+status+", code="+ error +", message = "+request.responseText);
			location.href=ctx+"/board";
		}
	});
	}
}