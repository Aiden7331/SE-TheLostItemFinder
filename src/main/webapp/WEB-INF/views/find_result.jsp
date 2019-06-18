<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>찾아주기</title>
	<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>	
	<script>
		function (){
			var name = document.getElementById("name");
			var tel = document.getElementById("tel");
			var memo = document.getElementById("memo");
			
		}
	</script>
</head>
<body>
	<h3> 찾는 사람 정보 입력 </h3>
	<form>
		이름 <input id="name" type="text"><br>
		전화번호<input id="tel" type="tel"><br>
		메모<br>
		<textarea id="memo" rows="10"></textarea><br>
		<input class="btn btn-success" type="submit" value="작성완료" onclick="">
	</form>
</body>
</html>