var ctx = "/TheLostItemFinder";

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

function delRep(seq){
	if(confirm("정말로 댓글을 삭제하시겠습니까?")){
		
	}
}
