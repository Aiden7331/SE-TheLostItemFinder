function logout(){
   	 var query={ };
   	 var ctx = "/TheLostItemFinder";
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
	var ctx="/TheLostItemFinder";
	if(confirm("정말 글을 삭제하겠습니까?")){
	$.ajax({
		type:'POST',
		url:ctx+'/deleteitem',
		contentType:'application/json',
		data:{"seq":id},
		dataType:'json',
		success:function(data){
			alert("글이 삭제되었습니다");
			location.href=ctx+"/board";
		},error:function(e){
			alert("다시 시도하세요");
			//location.href=ctx+"/board";
		}
	});
	}
}