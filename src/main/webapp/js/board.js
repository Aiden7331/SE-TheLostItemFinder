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