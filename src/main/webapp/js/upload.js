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

function checkValidate(frm) {
	if(frm.title.value=="") {
		alert("제목을 입력해주세요.");
		frm.title.focus();
		return false;
	}
	if(frm.date.value=="") {
		alert("날짜를 선택해주세요.");
		frm.date.focus();
		return false;
	}
	if(frm.place.value=="") {
		alert("분실 또는 발견한 장소를 입력해주세요.");
		frm.place.focus();
		return false;
	}
	if(frm.type_item.value=="") {
		alert("분실 또는 습득한 물건의 종류를 입력해주세요.");
		frm.place.focus();
		return false;
	}
	if(frm.contents.value=="") {
		alert("내용을 입력해주세요.");
		frm.contents.focus();
		return false;
	}
	
	alert("제출하시겠습니까?");
	return true;
}