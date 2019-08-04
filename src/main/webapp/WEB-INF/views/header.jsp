<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.navbar-inverse{
		background-color:#337ab7;
		border-color:#2e6da4;
		color:#FFFFFF;
	}
</style>
</head>
<body>
      <!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/TheLostItemFinder/">물건을 찾아줘</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="board">분실물 알림</a></li>
              <c:if test="${sessionScope.user.GRADE eq 'ADMIN'}">
               <li><a href="items">${sessionScope.office}관리실</a></li>
              </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
             <c:choose>
              <c:when test="${empty sessionScope.user}">
               <li><a id="on" href="login">로그인 <span class="sr-only">(current)</span></a></li>
              </c:when>
              <c:when test="${not empty sessionScope.user}">
               <li><a id="on" href="javascript:logout()">로그아웃 <span class="sr-only">(current)</span></a></li>
              </c:when>
             </c:choose>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

</body>
</html>