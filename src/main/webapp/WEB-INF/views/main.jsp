<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

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

    <!-- Bootstrap core CSS -->
    <link href="/TheLostItemFinder/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/TheLostItemFinder/css/main/navbar.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/TheLostItemFinder/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

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
            <a class="navbar-brand" href="#">물건을 찾아줘</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="board">들어온 분실물 </a></li>
              <li><a href="upload">내 분실물 알리기</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">추가개발예정 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="login">로그인 <span class="sr-only">(current)</span></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->

      <div class="jumbotron">
        <h2>오늘 찾은 분실물 N개</h2>
        <p></p>
        <p>
          <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">분실물 확인하기 &raquo;</a>
          <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">분실물 습득 신고하기 &raquo;</a>
        </p>
      </div>

      <!-- 그림 이미지 버튼입니다 -->
      <div class="row container">
        <h3>최근 등록된 분실물 <span class="label label-success">New</span></h3>
        <div class="col-sm-6 col-md-4">
          <div class="thumbnail">
            <img src="/TheLostItemFinder/site-image/main_image.png" alt="...">
            <div class="caption">
              <h3>지갑</h3>
              <p>ㅇㅇ에서 찾은 지갑입니다.</p>
              <p><a href="#" class="btn btn-primary" role="button">이동하기</a> </p>
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
