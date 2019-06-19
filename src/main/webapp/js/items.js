var ctx = "/TheLostItemFinder";
var target=null;
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
	if(confirm("정말 선택한 물건을 폐기하겠습니까?")){
		//TODO: 폐기 코드 작성.
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