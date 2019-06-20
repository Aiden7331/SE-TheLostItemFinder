<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>찾아주기</title>
	<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>	
	<script src="/TheLostItemFinder/js/items.js"></script>

<script>
window.onload=function(){
	var hidden = document.getElementById("seq");
	var seq = localStorage.getItem('item');
	if(seq==null){
		alert("페이지 오류가 발생했습니다");
		window.close();
		return ;
	}
	hidden.value=seq;
	
}
</script>
</head>
<body>
	<h3> 찾는 사람 정보 입력 </h3>
	<form action="setgiven" method="GET">
		<input id="seq" name="seq" type="hidden">
		<div class="form-group">
	    <label class="col-sm-2 control-label">이름</label>
	    <div class="col-sm-10">
	    	 <input class="form-control" name="name" type="text">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">전화번호</label>
	    <div class="col-sm-10">
			<input class="form-control" name="tel" type="tel">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">메모</label>
	    <div class="col-sm-10">
		<textarea class="form-control" name="memo" rows="10"></textarea>
	    </div>
	  </div>
	  <div class="form-group" style="text-align:right;">
		<input class="btn btn-success" type="submit" value="작성완료" >
	  </div>
	</form>
</body>
</html>