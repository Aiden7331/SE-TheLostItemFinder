CKEDITOR.editorConfig=function(config){
	config.language='ko';
	config.font_names='맑은 고딕; 돋움; 바탕; 돋음; 궁서;'+CKEDITOR.config.font_names;
	config.enterMode=CKEDITOR.ENTER_BR;
	config.docType="<!DOCTYPE html>";
	config.filebrowserFlashUploadUrl='imageup';
	config.filebrowserImageUploadUrl='imageup';
	config.removePlugins='save';
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