function validate() {
	
	if (!termscheck.agree.checked){
      alert("이용약관에 동의하지 않았습니다.");
      termscheck.agree.focus();
      return false;
    }
    
  return true;
}

function checkDouble(){
	var id = getElementById("inputID");
	var notice = getElementById("notice");
	alert(id.value + " " + notice.value);
	$.ajax({
		url:checkDouble,
		dataType:"json",
		async:true,
		type:POST,
		data:id,
		success: function(data){
			if(data['message'] == false){
				notice.innerHTML = "<font style='font-color:red; font-style:bold;'>이미 존재하는 ID입니다!</font>";
			}
		},
		error:function(request,status,error){
			alert('데이터 전송 오류가 발생했습니다.');
			location.reload();
		}
	});
}