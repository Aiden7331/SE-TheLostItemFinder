<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html xmlns:th="http://wwww.thymeleaf.org">
  <head>
    <meta http-http-equiv="Content-Type" content="text/thml; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../favicon.ico">
    <!--<link href="/TheLostItemFinder/css/main/terms.css" rel="stylesheet" media="all" /> -->

    <title>물건을 찾아줘</title>
	<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>
	<script src="/TheLostItemFinder/js/success.js"></script>
  </head>

  <body>

    <div class="container">
	 <jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>

      <!-- Main component for a primary marketing message or call to action -->

      <div class="row">
        <div class="col-xs-6 col-md-2">
          <p></p>

          <div class="panel panel-success" style="margin-top:30%" >
            <!-- Default panel contents -->
            <div class="panel-heading">Menu
            </div>
            <div class="list-group">
              <a href="#" class="list-group-item">1 - 약관 동의</a>
              <a href="#" class="list-group-item">2 - 회원정보 입력</a>
              <a href="#" class="list-group-item active">3 - 가입 완료</a>
            </div>
          </div>
        </div>
      <div class="col-xs-12 col-md-10">
        <div class="page-header">
        <h1>가입 완료</h1>
      </div>
      <div class="jumbotron">
        <h2>회원가입이 완료되었습니다.</h2>
        <p>
          앞으로 물건을 찾아줘 사이트의 모든 시스템을 이용할 수 있습니다.
          </p>
        </div>
        <div id="result">
          <button type="submit" class="btn btn-default">제출하기</button>
          </div>
     <div class="text-center">
        하단 문구 작성
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
