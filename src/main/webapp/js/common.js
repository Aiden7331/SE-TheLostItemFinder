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