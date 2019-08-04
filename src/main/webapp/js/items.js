var ctx = "/TheLostItemFinder";
var target=null;

window.onload=function(){
	var url=window.location.href;
	var officeName = document.getElementById("officeName").value;
	var page = document.getElementById("page").value;
	var pages = document.getElementById("pages");
	var limit = document.getElementById("limit").value;
	var total;
	if((total=sessionStorage.getItem('itemPage'))==null || limit!=sessionStorage.getItem('itemLimit') || total=='null'){
		$.ajax({
			url:ctx+"/itempage",
			dataType:"json",
			async:false,
			type:"GET",
			data:"limit="+limit+"&officeName="+officeName,
			success:function(data){
				total = data['total'];
				sessionStorage.setItem("itemLimit",limit);
				sessionStorage.setItem("itemPage",data['total']);
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


function give(){
	var seq = document.getElementsByName("seq");
	for(var i=0; i<seq.length; i++){
		if(seq[i].checked==true){
			target=seq[i].value;
			break;
		}
	}
	if(target==null){
		alert("찾아줄 물건을 선택하세요.");
		return ;
	}
	localStorage.setItem('item',target);
	var option = "scrollbars=no,"
				+"fullscreen=no,"
				+"location=no,"
				+"status=no,"
				+"toolbar=no,"
				+"resizeale=no,"
				+"width=500,"
				+"height=500";
	var modal = window.open("find_result",target,option);
}
function drop(){
	var office = document.getElementById('officeName');
	var user = document.getElementById('adminName');
	if(user == null || office == null){
		alert("페이지 오류가 발생했습니다");
		return ;
	}

	var seq = document.getElementsByName("seq");
	for(var i=0; i<seq.length; i++){
		if(seq[i].checked==true){
			target=seq[i].value;
			break;
		}
	}
	if(target==null){
		alert("찾아줄 물건을 선택하세요.");
		return ;
	}
	
	if(confirm("정말 선택한 물건을 폐기하겠습니까?")){
		office = encodeURI(office);
		user = encodeURI(user);
		var obj={
				seq:target,
				office:office,
				user:user
		}
		$.ajax({
			type:'POST',
			url:ctx+"/setDiscard",
			dataType:'json',
			contentType: "application/json",
			data:JSON.stringify(obj),
			success:function(data){
				if(data['message']==false){
					alert("다시 시도하세요");
					return ;
				}
				alert("선택한 아이템이 폐기되었습니다.");
				location.reload();
			},
			error:function(request,status,error){
				alert('데이터 전송 오류가 발생했습니다.'+error);
				location.reload();
			}
		});	
	}
}

function cancel(){
	var seq = document.getElementsByName("seq");
	for(var i=0; i<seq.length; i++){
		if(seq[i].checked==true){
			target=seq[i].value;
			break;
		}
	}
	if(target==null){
		alert("보관취소할 물건을 선택하세요.");
		return ;
	}
	
	
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

function setgive(){
	var name = document.getElementById("name").value;
	var tel = document.getElementById("tel").value;
	var memo = document.getElementById("memo").value;
	var seq = localStorage.getItem('item');
	if(seq==null){
		alert("페이지 오류가 발생했습니다");
		return ;
	}
	name=encodeURI(name);
	tel=encodeURI(tel);
	memo=encodeURI(memo);
	alert("SEQ:"+seq+",memo:"+memo+tel+name);
	$.ajax({
		type:'GET',
		url:ctx+"/setgiven",
		data:"seq="+seq+"&name="+name+"&tel="+tel+"&memo="+memo,
		success:function(data){
			alert("전송끝!");
			if(data['message']==false){
				alert("다시 시도하세요");
			}
		},
		error:function(request,status,error){
			alert('데이터 전송 오류가 발생했습니다.');
			location.reload();
		}
	});
	window.close();
}

function showOffice(office_seq){
	var option = "scrollbars=no,"
				+"fullscreen=no,"
				+"location=no,"
				+"status=no,"
				+"toolbar=no,"
				+"resizeale=no,"
				+"width=300,"
				+"height=300";
	
	var modal = window.open("info_office?seq="+office_seq,office_seq,option);
}