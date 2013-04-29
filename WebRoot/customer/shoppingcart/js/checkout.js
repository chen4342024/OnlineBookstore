function msgToggle(t){
  if($(t).parents('.consignee').find('.info').hasClass('close')){
	  showConsigneeMessage(t);
  }else{
	  hideConsigneeMessage(t);
  }
  return false;
};

function showConsigneeMessage(t){
	$(t).parents('.consignee').find('.btn_close').text("[关闭]");
	$(t).parents('.consignee').find('.info').removeClass('close');
	$(t).parents('.consignee').find('.info').toggle(700, function() {
		$(t).parents('.consignee').find('.refer_m').toggle(700, false);
	});
}

function hideConsigneeMessage(t){
	$(t).parents('.consignee').find('.btn_close').text("[修改]");
	$(t).parents('.consignee').find('.info').addClass('close');
	$(t).parents('.consignee').find('.info').toggle(700, function() {
		$(t).parents('.consignee').find('.refer_m').toggle(700, false);
	});
}
function collectShippingAddress(){
	$("#shipping_address_id").val($("input[name='radio_shipping_address_id']:checked").val());
	if($("#shipping_address_id").val()=="0"){
		$("#consignee").val($('#txt_ship_name').val());
		$("#shipping_province").val($('#s_province').val());
		$("#shipping_city").val($('#s_city').val());
		$("#shipping_county").val($('#s_county').val());
		$("#street_address").val($('#txt_ship_address').val());
		$("#postcode").val($('#txt_ship_zip').val());
		$("#mobile_phone").val($('#txt_ship_mb').val());
		$("#fixed_phone").val($('#txt_ship_tel').val());
	}
}
function fillConsigneeMessage(){
	if($(".customer_address:radio[checked='true']").attr("id")=="newCustomerAddress"){
		$('#li_refer_m').html(
				$('#txt_ship_name').val() + ","+
				$('#s_province').val()+","+$('#s_city').val()+","+$('#s_county').val() + ","+
				$('#txt_ship_address').val() + ","+
				$('#txt_ship_zip').val() +"," +
				$('#txt_ship_mb').val() + "'" + 
				$('#txt_ship_tel').val()
		)
		collectShippingAddress();
	}else {
		$('#li_refer_m').html($(".customer_address:radio[checked='true']").next(".existAddress").text());
	}
}
function initValidation(){
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
function beforeSubmit(){
	if(ui_isInputEmptyValueAfterTrim('shipping_address_id')){
		$("#submitOrderErrorMsgHolder").text("请确认收货地址");
		return false;
	}
	if(ui_isInputEmptyValueAfterTrim("parmPaymentMethod")){
		$("#submitOrderErrorMsgHolder").text("请确认送货方式");
		return false;
	}
	if(ui_isInputEmptyValueAfterTrim("amount")){
		if(ui_getObjectById('amount').value=='0'){
			$("#submitOrderErrorMsgHolder").text("当前商品数量为0，请重新选择");
			return false;
		}
	}
	return true;
}
$(document).ready(function(){
	//为表单添加验证
	var validationManager = new ValidationManager().bind('div_consignee_edit_info_display');
	initValidation();
	//控制地址的显示和隐藏
	$(".customer_address:radio").change(function(){
		if($(this).attr("id")=="newCustomerAddress"){
			$("#div_consignee_edit_info_display").show();
		}else{
			$("#div_consignee_edit_info_display").hide();
		}
	});
	//级联地区的操作
	$('.select_w').change(function(){
		$('#div_country_province_city').html(
		"中国,"+$('#s_province').val()+","+$('#s_city').val()+","+$('#s_county').val());
	});
	//点击保存之后的操作
	$("[name='btn_consignee_save']").click(function(){
		if ($("#newCustomerAddress").attr("checked")==true && !validationManager.validateWithDraftLevel()) {
       		return false;
      	 }
		fillConsigneeMessage();
		msgToggle(this);
		$('#shipping_address_id').val($("input[name='radio_shipping_address_id']:checked").val());
	});
	//支付方式的操作
	$('#parmPaymentMethod').val($("input[name='payment_method']:checked").val());
	$('#btn_payment_save').click(function(){
		$('#payment_result').html($("input[name='payment_method']:checked").next().text());
		$('#parmPaymentMethod').val($("input[name=payment_method]:checked").val());
	});
	
	$('#submitOrder').click(function(){
		if(!beforeSubmit()){
			$("#submitOrderErrorMsgHolder").show();
			return false;
		}
		$("submitOrderErrorMsgHolder").hide();
		$('#submitOrderButton').click();
		return false;
	})
});
