<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	sessionStorage.setItem('file_path','${file_path}');
	window.parent.CKEDITOR.tools.callFunction('${CKEditorFuncNum}','${file_path}','파일 전송 완료');	
</script>
</head>
<body>

</body>
</html>