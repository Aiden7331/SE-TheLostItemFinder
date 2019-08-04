<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!--<link rel="icon" href="../../favicon.ico">-->

    <title>물건을 찾아줘</title>
	<jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>	
	

  </head>

  <body>

    <div class="container">

      <form id="login" class="form-signin" action="login" method="POST" onsubmit="return login(this)">
        <h2 class="form-signin-heading">물건을 찾아줘</h2>
        <div id="warning"></div>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="text" id="inputId" class="form-control" name="id" placeholder="ID" required autofocus maxlength='15'>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPw" class="form-control" name="pw" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> ID 기억하기
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      </form>
      <div class="text-center">
        <a>비밀번호 찾기</a>
        <a href="register-1">회원가입</a>
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
