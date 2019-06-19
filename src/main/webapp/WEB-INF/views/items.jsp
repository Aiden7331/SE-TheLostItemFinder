<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns:th="http://wwww.thymeleaf.org">
  <head>
    <meta http-http-equiv="Content-Type" content="text/thml; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../favicon.ico">

    <title>물건을 찾아줘</title>
	<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>
	<script src="/TheLostItemFinder/js/items.js"></script>
  </head>

  <body>

    <div class="container">
	 <jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
	 
      <!-- Main component for a primary marketing message or call to action -->

      <div class="row">
        <div class="col-xs-6 col-md-2" >
          <p></p>

          </div>
          <div class="col-xs-12 col-md-10">
            <div class="page-header">
              <h1>관리실 보관 물품</h1>
            </div>
			<!-- Single button -->
            <div  style="text-align:right">
              <div class="btn-group " >
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  보기 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">최신순</a></li>
                  <li><a href="#">추가예정</a></li>
                  <li><a href="#">추가예정</a></li>
                  <li class="divider"></li>
                  <li><a href="#">추가예정</a></li>
                </ul>
              </div>
            </div>
            <p></p>
            <table class="table table-hover text-center">
              <tr class="info">
              	<th style="width:7%; text-align:center;"><b>체크</b></th>
                <th style="width:7%; text-align:center;"><b>글 번호</b></th>
                <th style="width:15%; text-align:center;"><b>물건 종류</b></th>
                <th style="width:21%; text-align:center;"><b>물건 사진</b></th>
                <th style="width:20%; text-align:center;"><b>발견한 곳</b></th>
                <th style="width:10%; text-align:center;"><b>발견 날짜</b></th>
                <th style="width:10%; text-align:center;"><b>업로드 날짜</b></th>
              </tr>
              <c:forEach var="article" items="${list}">
              <tr>
              	<td><input type="radio" name="seq" value="${article.SEQ}"></td>
                <td style="text-align:center">${article.SEQ}</td>
                <td>${article.TYPE_ITEM}</td>
                <td><img src="/TheLostItemFinder/site-image/main_image.png" alt="클릭하면 게시물로 이동합니다." width="40%"></td>
                <td>${article.PLACE}</td>
                <td>${article.DATE_LOST}</td>
                <td>${article.DATE_UPLOAD}</td>
              </tr>
              </c:forEach>
            </table>
          </div>
        </div>
        <div style="text-align:right;">
        	<input type="button" class="btn btn-info" value="찾아주기" onclick='give()'>
        	<input type="button" class="btn btn-warning" value="보관취소" onclick="cencel()">
        	<input type="button" class="btn btn-danger" value="폐기" onclick='drop()'>
        </div>

        <nav style="text-align:center">
          <ul class="pagination pagination-sm">
            <li>
              <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
              <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>
      <!-- 그림 이미지 버튼입니다 -->
      <div class="container" style="text-align:center">
        <form class="form-inline">
          <div class="form-group">
            <div class="btn-group " >
              <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                선택<span class="caret"></span>
              </button>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">제목</a></li>
                <li><a href="#">제목 + 내용</a></li>
                <li><a href="#">물건 종류</a></li>
                <li><a href="#">장소</a></li>
              </ul>
            </div>
            <div class="btn-group " >
              <input type="text" class="form-control" id="exampleInputEmail2" placeholder="검색어를 입력하세요.">
            </div>
            <button type="submit" class="btn btn-default">검색</button>
          </div>
        </form>
      </div>

      <div class="page-header">
      </div>

      <div class="text-center">
        하단 글
      </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/TheLostItemFinder/js/bootstrap.min.js"></script>
    <script src="/TheLostItemFinder/js/common.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/TheLostItemFinder/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
