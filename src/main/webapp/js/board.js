var ctx = "/TheLostItemFinder";

window.onload=function(){
	var url=window.location.href;
	var page = document.getElementById("page").value;
	var pages = document.getElementById("pages");
	var limit = document.getElementById("limit").value;
	var total;
	if((total=sessionStorage.getItem('board'))==null || limit!=sessionStorage.getItem('limit') || total=='null'){
		$.ajax({
			url:ctx+"/boardpage",
			dataType:"json",
			async:false,
			type:"GET",
			data:"limit="+limit,
			success:function(data){
				total = data['total'];
				sessionStorage.setItem("limit",limit);
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
	if(page==1){
		pages.innerHTML = "<li class='disenable'> <a aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a> </li>";
	}else{
		pages.innerHTML = "<li> <a aria-label='Previous' onclick='prevPage("+page+")'> <span aria-hidden='true'>&laquo;</span></a> </li>";
	}
	for(var i=1; i<=total; i++){
		if(i==page){
			pages.innerHTML+="<li class='active'><a>" + i + "</a></li>";
		}else{
			pages.innerHTML+="<li><a onclick='selectPage("+i+")'>" + i + "</a></li>";
		}
	}
	if(page==total){
		pages.innerHTML+= "<li class='disenable'> <a aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
	}else{
		pages.innerHTML+= "<li> <a aria-label='Next' onclick='nextPage("+page +")'><span aria-hidden='true'>&raquo;</span></a></li>";	
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

function selectPage(page){
	editGET('page',page);
}

function divide(limit){
	var url = window.location.href;
	fragment=url.split('?');
	location.href = fragment[0]+'?limit='+ limit +'&page=1';
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
	searchField.placeholder = type;
}

function delRep(seq,aseq){
	if(confirm("정말로 댓글을 삭제하시겠습니까?")){
		$.ajax({
			type:'GET',
			url:ctx+'/deletereply',
			data:"seq="+seq+"&aseq="+aseq,
			success:function(data){
				alert('댓글이 삭제되었습니다.');
				location.reload();
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
			alert('선택한 아이템이 보관되었습니다');
			location.reload();
		},error:function(request,status,error){
			alert("다시 시도하세요 (error Name = "+status+", code="+ error +", message = "+request.responseText);
			location.href=ctx+"/board";
		}
	})
}
function cancel(target){
	if(confirm('정말 선택한 물건을 보관취소하겠습니까?')){
		$.ajax({
			type:'GET',
			url:ctx+"/cancelProperty",
			dataType:'json',
			contentType: "application/json",
			data:'seq='+target,
			success:function(data){
				if(data['message']==false){
					alert("다시 시도하세요");
					return ;
				}
				alert("선택한 아이템이 보관취소 되었습니다.");
				location.reload();
			},
			error:function(request,status,error){
				alert('데이터 전송 오류가 발생했습니다.'+error);
				location.reload();
			}
		});	
		
	}
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

