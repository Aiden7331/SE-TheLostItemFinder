CKEDITOR.editorConfig=function(config){
	config.language='ko';
	config.font_names='맑은 고딕; 돋움; 바탕; 돋음; 궁서;'+CKEDITOR.config.font_names;
	config.enterMode=CKEDITOR.ENTER_BR;
	config.docType="<!DOCTYPE html>";
	config.filebrowserFlashUploadUrl='imageup';
	config.filebrowserImageUploadUrl='imageup';
	config.removePlugins='save';
}