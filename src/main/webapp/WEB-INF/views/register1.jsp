
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
	<script src="/TheLostItemFinder/js/terms.js"></script>
	<script src="/TheLostItemFinder/Js/register1.js"></script>
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
              <a href="#" class="list-group-item active">2 - 회원정보 입력</a>
              <a href="#" class="list-group-item">3 - 가입 완료</a>
            </div>
          </div>

        </div>
      <div class="col-xs-12 col-md-10">
        <div class="page-header">
        <h1>회원정보 입력</h1>
      </div>
     <form class="form-horizontal">
	  <div class="form-group form-inline">
	    <label class="col-sm-2 control-label">ID</label>
	    <div class="col-sm-10">
	      <input type="input" class="form-control" id="inputEmail3" placeholder="사용할 ID를 입력해주세요.">
	      <button type="submit" class="btn btn-primary">중복확인</button><br />
	      <label class="col-sm-2 control-label" id="idcheckresult"></label>
	    </div>
	  </div>
	</form>
	
	<form class="form-horizontal" name="password">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="pw" placeholder="Password">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">Password 확인</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="pw_check" placeholder="Password">
	      <label class="col-sm-2 control-label" id="passwdcheckresult"></label>
	    </div>
	  </div>
	 
	  <div class="form-group">
		<label class="col-sm-2 control-label">전화번호</label>
		 <div class="col-sm-2">
		  <input type="tel" class="form-control" id="inputPassword3" placeholder="전화번호를 입력해주세요.">
	   </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">학번/교직원번호</label>
      <div class="col-sm-10">
        <input type="input" class="form-control" placeholder="학번 또는 교직원번호를 입력해주세요.">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">닉네임</label>
        <div class="col-sm-10">
          <input type="input" class="form-control" id="nickname" placeholder="사용할 닉네임을 입력해주세요.">
          <label class="col-sm-2 control-label" id="nicknamecheckresult"></label>
          </div>
        </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">제출하기</button>
	    </div>
	  </div>
	 </form>
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