var ctx = "/TheLostItemFinder";

window.onload=function(){
	var url=window.location.href;
	//var temp1 = url.split('?');
	//var temp2 = temp1[1].split('&');
	
	//var page = temp[0].split('=')[1];
	//var limit = temp[1].split('=')[1];
	var page = document.getElementById("page").value;
	var pages = document.getElementById("pages");
	var limit = document.getElementById("limit").value;
	var total;
	if((total=sessionStorage.getItem('board'))==null || total=='null'){
		$.ajax({
			url:ctx+"/boardpage",
			dataType:"json",
			type:"GET",
			data:"limit="+limit,
			success:function(data){
				total = data['total'];
				sessionStorage.setItem("board",data['total']);
			},
			error:function(request,status,error){
				alert('데이터 전송 오류가 발생했습니다.');
				location.reload();
			}
		});
		
	}
	if(total>10){
		total=10;
	}

	pages.innerHTML = "<li> <a href='#' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a> </li>";
	for(var i=1; i<=total; i++){
		pages.innerHTML+="<li><a href='#'>" + i + "</a></li>";
	}
	pages.innerHTML+= "<li> <a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
	
}

function counter(text,length){
	var limit = length;
	var str = text.value.length;
	if(str>limit){
		document.getElementById("reCount").innerHTML = "1500자 이상 입력했습니다.";
		text.value=text.value.substring(0,limit);
		text.focus();
	}
	document.getElementById("reCount").innerHTML = text.value.length + " / " + limit;	
}

function setCondition(type){
	var searchType=document.getElementById("searchType");
	searchType.value = type;
	
}

function delRep(seq,aseq){
	if(confirm("정말로 댓글을 삭제하시겠습니까?")){
		alert(seq+" "+aseq);
		$.ajax({
			type:'GET',
			url:ctx+'/deletereply',
			data:"seq="+seq+"&aseq="+aseq,
			success:function(data){
				alert('댓글이 삭제되었습니다.');
			},error:function(request,status,error){
				alert("다시 시도하세요 (error Name = "+status+", code="+ error +", message = "+request.responseText);
				location.href=ctx+"/board";
			}
		});
	}
}

function store(id){
	alert("관리실에 보관합니다.");
	$.ajax({
		type:'GET',
		url:ctx+'/additem',
		data:"seq="+id,
		success:function(data){
			if(data['message'] == false){
				alert("다시 시도하세요");
			}
		},error:function(request,status,error){
			alert("다시 시도하세요 (error Name = "+status+", code="+ error +", message = "+request.responseText);
			location.href=ctx+"/board";
		}
	})
}

function free(id){
	if(confirm("정말 글을 삭제하겠습니까?")){
		$.ajax({
			type:'GET',
			url:ctx+'/deleteitem',
			data:"seq="+id,
			success:function(data){
				alert("글이 삭제되었습니다");
				location.href=ctx+"/board";
			},error:function(request,status,error){
				alert("다시 시도하세요 (error Name = "+status+", code="+ error +", message = "+request.responseText);
				location.href=ctx+"/board";
			}
		});
	}
}