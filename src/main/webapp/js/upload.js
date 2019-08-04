var directInput=false;

var ckeditor_config={
		resize_enable:false,
		enterMode:CKEDITOR.ENTER_BR,
		shiftEnterMode:CKEDITOR.ENTER_P,
		tollbarCanCollapse:true,
		removePlugins:"elementspath",
		filebrowserUploadUrl:'/TheLostItemFinder/file_upload',
			
			// 에디터에 사용할 기능들 정의 
		toolbar : [ 
			[ 'Source', '-' , 'NewPage', 'Preview' ], 
			[ 'Cut', 'Copy', 'Paste', 'PasteText', '-', 'Undo', 'Redo' ], 
			[ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript'], 
			[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ], 
			'/', 
			[ 'Styles', 'Format', 'Font', 'FontSize' ], 
			[ 'TextColor', 'BGColor' ], 
			[ 'Image', 'Flash', 'Table' , 'SpecialChar' , 'Link', 'Unlink'] 
		]
}

function selectType(select){
	var inputForm = document.getElementById("inputForm");
	
	if(select.value=='직접입력'){
		directInput = true;
		inputForm.innerHTML="<input class='form-control' style='width:50%' type='text' name='type_item' placeholder='직접 입력'>";
		return ;
	}else if(directInput){
		directInput = false;
	}
	inputForm.innerHTML="<input type='hidden' name='type_item' value='"+select.value+"'>";
}

function checkValidate(frm) {
	if((img = sessionStorage.getItem('file_path'))!=null){
		frm.image.value=img;
		alert('경로설정 성공');
		sessionStorage.removeItem('file_path');
		alert('temp 데이터 제거 성공');
	}
	
	if(confirm("제출하시겠습니까?")){
		return true;
	}else{
		return false;
	}
}