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
	<script>
	window.onload=function(){
		var page = document.getElementById("page").value;
		var totalPage = document.getElementById("totalPage").value;
		var pager = document.getElementById("pager");
		page = parseInt(page);
		totalPage=parseInt(totalPage);
		if(page==1){
			pager.innerHTML += "<li class='disabled'><a>이전</a></li>";
		}else{
			pager.innerHTML += "<li class='active'><a onclick='prevPage(" + page + ")'>이전</a></li>";
		}
		if(page==totalPage){
			pager.innerHTML += "<li class='disabled'><a>다음</a></li>";
		}else{
			pager.innerHTML += "<li class='active'><a onclick='nextPage(" + page+ ")'>다음</a></li>";	
		}
		
	}
	
	function prevPage(page){
		page--;
		editGET('page',page);
	}
	function nextPage(page){
		page++;
		editGET('page',page);
	}

	function editGET(key,val){
		var url = window.location.href;
		if(url.indexOf('?')==-1){
			location.href = url+"?" + key + "="+val;
		}else if(url.indexOf(key+'=')==-1){
			location.href = url+"&"+key+"="+val;
		}else{
			var fragment= url.split(key+'=');
			if(fragment[1].indexOf('&')==-1){
				location.href = fragment[0] + key+'='+val;
			}else{
				var back = fragment[1].split('&');
				location.href = fragment[0]+key+'='+val+'&'+back[1];
			}
		}
	}
	
	function go(){
		var session=document.getElementById("on");
		temp=session.innerHTML;
		temp=temp.substr(0,3);
		if(temp=='로그인'){
			window.location.href="login";
		}else{
			window.location.href="upload";
		}
	}
	</script>
  </head>

  <body>

    <div class="container">
	  <jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>

      <!-- Main component for a primary marketing message or call to action -->

      <div class="jumbotron">
        <h2>오늘 찾은 분실물 ${count}개</h2>
        <p></p>
        <p>
          <!--<a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">분실물 확인하기 &raquo;</a>-->
          <a class="btn btn-lg btn-primary" onclick="go()" role="button">분실물 신고하기 &raquo;</a>
        </p>
      </div>

      <!-- 그림 이미지 버튼입니다 -->
      <div class="row container">
        <h3>관리실 보유중인 분실물</h3>
        <div class="row">
        <c:forEach var="article" varStatus="status" items="${list}">
	        <div class="col-sm-6 col-md-4">
	          <div class="thumbnail">
	            <img src="${article.IMAGE }" height="250px" style="max-height:250px; width:auto;" alt="...">
	            <div class="caption">
	              <h3>${article.TITLE}</h3>
	              <p>${article.CONTENTS}<span class="label label-success">New</span></p>
	              <p><a href="board?id=${article.SEQ}" class="btn btn-primary" role="button">이동하기</a>   </p>
	            </div>
	          </div>
	        </div>
	     <c:if test="${status.index eq 2}">
	     </div>
	     <div class="row">
	     </c:if>
        </c:forEach>
		  </div>
      </div>
      <input type="hidden" id="totalPage" value="${totalPage}">
      <input type="hidden" id="page" value="${page}">
      <ul id="pager" class="pager">
      </ul>

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
