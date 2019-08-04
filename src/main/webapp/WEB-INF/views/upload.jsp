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
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <title>물건을 찾아줘</title>
    <jsp:include page="/WEB-INF/views/default.jsp" flush="false"/>
    <script src="/TheLostItemFinder/resources/ckeditor/ckeditor.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="/TheLostItemFinder/js/upload.js"></script>
    <script>
    $(function() {
    	$("#datepicker").datepicker({
    		showOtherMonth: true,
    		selectOtherMonth: true,
    		changeMonth: true,
    		changeYear : true,
    		dateFormat: "yy-mm-dd"
    	});
    });

    $.datepicker.setDefaults({
    	prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
    </script>
  	<style>
    	.inputtext{width:100%;}
    </style>
  </head>
  <body>

    <div class="container">
		<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
	

      <!-- Main component for a primary marketing message or call to action -->
      	<div class="col-xs-6 col-md-2" >
          <p></p>
			
        </div>
        <div class="col-xs-12 col-md-10">
          <div class="page-header">
            <h1>게시물 작성</h1>
          </div>
			<form method="POST" action="upload" onsubmit="return checkValidate(this)" name="inputgroup">
	          <table class="table">
	          	<tr>
	            	<td><input class="form-control inputtext" type="text" name="title" autocomplete="off" placeholder="제목을 입력하세요"></td>
	            </tr>
	            <tr>
	            	<td><input class="form-control inputtext" type="text" id="datepicker" name="date_lost" autocomplete="off" placeholder="잃어버린 날짜를 선택하세요."></td>
	            </tr>
	            <tr>
	            	<td><input class="form-control inputtext" type="text" name="place" placeholder="잃어버린 장소를 입력하세요"></td>
	            </tr>
	            <tr>
	            	<td>
	            		분실물 종류
	            		<select onchange="selectType(this)">
	            			<option value="직접입력">직접입력</option>
	            			<option value="스마트폰">스마트폰</option>
	            			<option value="지갑">지갑</option>
	            			<option value="카드">카드</option>
	            			<option value="열쇠">열쇠</option>
	            			<option value="USB">USB</option>
	            			<option value="충전기">충전기</option>
	            			<option value="겉옷">겉옷</option>
	            			<option value="택배">택배</option>
	            			<option value="이어폰">이어폰</option>
	            			<option value="노트북">노트북</option>
	            			<option value="기타">기타</option>
	            		</select>
	            		<div id="inputForm"></div>
	            	</td>
	            </tr>
	            <tr>
	            	<td>
	            		<select style="width:30%" name="type_article">
	            			<option value="물건 찾는글">물건 찾아요</option>
	            			<option value="주인 찾는글">주인 찾아요</option>
	            		</select>
	            	</td>
	            </tr>
	            <!-- 미사용 
	            <tr>
	            	<td>이미지 첨부하기 <input type="file" class="btn btn-default" id="image" name="fileData"></td>
	            </tr>
	            -->
				<tr>
					<td><textarea name="contents" id="editor" rows="10" cols="80" placeholder="내용을 입력하세요"> </textarea></td>
					
    				<script>
     				 CKEDITOR.replace('editor',ckeditor_config);
    				</script>
				</tr>
	          </table>
	          <!-- Single button -->
	          <div style="text-align:right;">
			   <input type="hidden" name="nickname" value="${sessionScope.user.NICKNAME}">
			   <input type="hidden" id="image" name="image" value="/TheLostItemFinder/site-image/main_image.png">
			   <input type="submit" class="btn btn-primary" value="작성완료"/>
			</form>

		      <div class="page-header">
		      </div>

		      <div class="text-center">
		        하단 문구 작성
		      </div>
		    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script-->
    <script src="/TheLostItemFinder/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/TheLostItemFinder/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
