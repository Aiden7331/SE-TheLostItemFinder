<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>
</head>
<body>
<h1 id="officeName">${office.NAME}</h1>
<hr>
  <form action="updateInfoOffice" method="POST">
    <div class="form-group">
      <label class="col-sm-2 control-label">관리실 전화번호</label>
	    <div class="col-sm-10">
	      <input type="text" name="tel" class="form-control" value="${office.TEL}"><br>
	    </div>
      <label class="col-sm-2 control-label">관리실 위치</label>
	    <div class="col-sm-10">
	      <textarea class="form-control" name="location">${office.LOCATION}</textarea>
	    </div>
	</div>
	<div style="text-align:right;">
		<input type="hidden" name="name" value="${office.NAME}">
		<input type="submit" class="btn btn-primary" value="수정하기">
	</div>
  </form>
</body>
</html>