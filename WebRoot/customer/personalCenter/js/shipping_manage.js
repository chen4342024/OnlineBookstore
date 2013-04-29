var shipping_manage = {
	validationManager:null,
	init : function() {
	 	this.validationManager = new ValidationManager().bind('editAddress_div');
	 	this.bindValidation();
	},
	bindValidation:function(){
		new Validation(ui_getObjById("txt_ship_name")).addDraft(ValidateFun.Mandatory,{message : "收货人必填"});
		new Validation(ui_getObjById("s_province")).addDraft(ValidateFun.Mandatory,{message : "省份必填"});
		new Validation(ui_getObjById("s_city")).addDraft(ValidateFun.Mandatory,{message : "城市必填"});
		new Validation(ui_getObjById("s_county")).addDraft(ValidateFun.Mandatory,{message : "县必填"});
		new Validation(ui_getObjById("txt_ship_address")).addDraft(ValidateFun.Mandatory,{message : "街道地址必填"});
		new Validation(ui_getObjById("txt_ship_zip")).addDraft(ValidateFun.Mandatory,{message : "邮编必填"}).addDraft(ValidateFun.Digit,{message:"请填写正确的邮编"});
		new Validation(ui_getObjById("txt_ship_mb")).addDraft(ValidateFun.Mandatory,{message : "手机必填"})
			.addDraft(function(element){
				if(element.value.length==11) return true;
				return false;
			}, {  message: "请输入正确的手机号码"});;
		new Validation(ui_getObjById("txt_ship_tel")).addDraft(ValidateFun.Mandatory,{message : "固定电话格式出错"});
	}
}
$(document).ready(function(){
	shipping_manage.init();
	
})