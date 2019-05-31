<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <!--<meta http-http-equiv="Content-Type" content="text/thml; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- <meta name="description" content="">
    <meta name="author" content="">-->
    <link rel="icon" href="../favicon.ico">

    <title>물건을 찾아줘</title>
		<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>
  </head>

  <body>

    <div class="container">
	  <jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>

      <!-- Main component for a primary marketing message or call to action -->

      <div class="jumbotron">
        <h2>오늘 찾은 분실물 N개</h2>
        <p></p>
        <p>
          <!--<a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">분실물 확인하기 &raquo;</a>-->
          <a class="btn btn-lg btn-primary" href="upload" role="button">분실물 습득 신고하기 &raquo;</a>
        </p>
      </div>

      <!-- 그림 이미지 버튼입니다 -->
      <div class="row container">
        <h3>관리실 보유중인 분실물</h3>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>지갑</h3>
              <p>ㅇㅇ에서 찾은 지갑입니다.<span class="label label-success">New</span></p>
              <p><a href="#" class="btn btn-primary" role="button">이동하기</a>   </p>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>시계</h3>
              <p>ㅇㅇ에서 찾은 시계입니다.
              ㅇㅇ에서 보관하고있습니다.</p>
              <p><a href="#" class="btn btn-primary" role="button">이동하기</a> </p>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>우산</h3>
              <p>ㅇㅇ에서 찾은 우산입니다.
              ㅇㅇ에서 보관하고 있으니 찾아가시기 바랍니다.</p>
              <p><a href="#" class="btn btn-primary" role="button">이동하기</a> </p>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>분실물 없음</h3>
              <p>주인을 찾지 못한 분실물이 있다면, 지금 등록하세요!</p>
              <p><a href="#" class="btn btn-primary disabled" role="button">이동하기</a> </p>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>분실물 없음</h3>
              <p>주인을 찾지 못한 분실물이 있다면, 지금 등록하세요!</p>
              <p><a href="#" class="btn btn-primary disabled" role="button">이동하기</a> </p>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>분실물 없음</h3>
              <p>주인을 찾지 못한 분실물이 있다면, 지금 등록하세요!</p>
              <p><a href="#" class="btn btn-primary disabled" role="button">이동하기</a> </p>
            </div>
          </div>
        </div>

        <ul class="pager">
          <li class="disabled"><a href="#">이전</a></li>
          <li class="disabled"><a href="#">다음</a></li>
        </ul>
        </nav>
      </div>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/TheLostItemFinder/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/TheLostItemFinder/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
