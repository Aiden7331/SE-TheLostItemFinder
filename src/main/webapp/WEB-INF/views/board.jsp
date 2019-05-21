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
  </head>

  <body>

    <div class="container">
	 <jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
	 
      <!-- Main component for a primary marketing message or call to action -->

      <div class="row">
        <div class="col-xs-6 col-md-2" >
          <p></p>
			
          <!-- <div class="panel panel-success" style="margin-top:30%" data-spy="affix" data-offset="100" >
            <div class="panel-heading">Menu
            </div>
            <div class="list-group">
              <a href="#" class="list-group-item">
                게시물 작성하기
              </a>
              <a href="#" class="list-group-item">게시물 수정하기</a>
              <a href="#" class="list-group-item">게시물 삭제하기</a>
              <a href="#" class="list-group-item">관리자에게 알리기</a>
              <a href="#" class="list-group-item">추가개발예정</a>
            </div>
          </div> --> 

          </div>
          <div class="col-xs-12 col-md-10">
            <div class="page-header">
              <h1>분실물 알림</h1>
            </div>
			<c:if test="${isArticle eq true}">
			<div>
			 <table class="table table-hover text-center">
			  <tr>
			    <th colspan="4" style="text-align:center;">${article.TITLE}</th>
			  </tr>
			  <tr>
				<td colspan="3" style="text-align:left;">작성자 ${article.DATE_UPLOAD}</td><td>조회수 ${article.HITS }</td>
			  </tr>
			  <tr>
				<td style="text-align:left">잃어버린 장소 </td><td style="text-align:left"> ${article.PLACE} </td>
			  </tr>
			  <tr>
				<td style="text-align:left">분실물 종류</td><td style="text-align:left;">${article.TYPE_ITEM}</td>
			  </tr>
			  <tr>
				<td colspan="4">${article.CONTENTS}</td>
			  </tr>
			 </table>
			</div>
			<div>
			 <table class="table table-hover text-center">
			  <tr style="width:100%">
			   <th style="text-align:center; width:10%;">뎃글번호</th><th style="text-align:center; width:65%">내용</th><th style="text-align:center; width:20%">작성자</th><th style="text-align:center; width:15%">작성일</th>
			  </tr>
			  <c:choose>
			   <c:when test="${not empty replies}">
			    <c:forEach var="reply" items="${replies}">
			     <tr>
			      <td>${reply.SEQ}</td><td>${reply.CONTENTS}</td><td>${reply.NICKNAME}</td><td>${reply.DATE}</td>
			     </tr>
			    </c:forEach>
			   </c:when>
			   <c:when test ="${empty replies}">
			    <tr>
			  	 <td colspan="4">작성한 댓글이 없습니다.</td>
			  	</tr>
			   </c:when>
			  </c:choose>
			  <tr>
			   <c:choose>
                <c:when test="${not empty sessionScope.user}">
                 <form action="board" method="POST">
			      <input type="hidden" name="id" value="${article.SEQ}">
			      <input type="hidden" name="nickname" value="${sessionScope.user}"> 
			      <td colspan="3">
			       <textarea style="width:100%; height:100%" name="contents"></textarea>
			      </td>
			      <td>
			   	   <input class="btn btn-default" style="width:100%; height:100%;" type="submit" value="뎃글 작성">
			      </td>
			     </form>
                </c:when>
                <c:when test="${empty sessionScope.user}">
                </c:when>
               </c:choose> 
			   </tr>
			 </table>
			<div>
			 <button class="btn btn-default">수정</button><button class="btn btn-default">삭제</button><button class="btn btn-default">신고</button>
			</div>
			</div>
			
			</c:if>
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
                <th style="width:7%; text-align:center;"><b>글 번호</b></th>
                <th style="width:21%; text-align:center;"><b>물건 사진</b></th>
                <th style="width:30%; text-align:center;"><b>제목</b></th>
                <th style="width:15%; text-align:center;"><b>물건 종류</b></th>
                <th style="width:10%; text-align:center;"><b>글쓴이</b></th>
                <th style="width:7%; text-align:center;"><b>조회수</b></th>
                <th style="width:10%; text-align:center;"><b>업로드 날짜</b></th>
              </tr>
              <c:forEach var="article" items="${list}">
              <tr>
                <td style="text-align:center">${article.SEQ}</td>
                <td><img src="/TheLostItemFinder/site-image/main_image.png" alt="클릭하면 게시물로 이동합니다." width="40%"></td>
                <td><a href="?id=${article.SEQ}">${article.TITLE}</a></td>
                <td>${article.TYPE_ITEM}</td>
                <td>${article.NICKNAME}</td>
                <td>${article.HITS}</td>
                <td>${article.DATE_UPLOAD}</td>
              </tr>
              </c:forEach>
            </table>
          </div>
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
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/TheLostItemFinder/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
