/*---*/

/*reduce roundtrip*/
//Below try catch is to set IE to cache the backgound image, no need to request every time.
try {
  document.execCommand("BackgroundImageCache", false, true);
} catch(err) {}

/* content_page.js */

var content_page_constant = "CARGO_SMART_CONTENT_PAGE";
var content_page_locale_en_us = "en-US";
var content_page_locale_zh_cn = "zh-CN";
var content_page_locale_zh_tw = "zh-TW";
var content_page_locale_ja_JP = "ja-JP";

function navigate_openContentPageWindow(url,windowname) {
      var windowparms = "resizable,status,scrollbars,menubar,titlebar,toolbar,location,";
      var w_ht = Math.round(screen.availHeight * 0.8);
      var w_wd = Math.round(screen.availWidth * 0.8);
	  left = (screen.availWidth  - w_wd) - 20;
	  windowparms += "left=" + left + ",top=" + 5 + ",screenX=" + 10 + ",screenY=" + 10 + ",";
	  windowparms += "height=" + w_ht + ",width=" + w_wd;

      NewWindow = window.open(url,windowname,windowparms);
      NewWindow.window.focus();
}

function openContentPageInNewWindow (pageType, locale) {
	if (pageType=="TOU"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/sc/company/tou/tou.htm", content_page_constant);
		} else {
			navigate_openContentPageWindow("/en/company/tou/tou.htm", content_page_constant);
		}
	}else if (pageType=="PRIVACY_SECURITY"){
			if (locale==content_page_locale_zh_cn){
				navigate_openContentPageWindow("/sc/company/tou/pss.htm", content_page_constant);
			}else {
				navigate_openContentPageWindow("/en/company/tou/pss.htm", content_page_constant);
			}
	}else if (pageType=="COPY_RIGHT_POLICY"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/sc/company/tou/tou.htm#cip", content_page_constant);
		} else {
			navigate_openContentPageWindow("/en/company/tou/tou.htm#cip", content_page_constant);
		}
	}else if (pageType=="CONTACT_US"){
					navigateMccContactUs();
					//if (locale==content_page_locale_zh_cn){
					//	navigate_openContentPageWindow("/sc/company/contact_us.htm", content_page_constant);
					//}else {
					//	navigate_openContentPageWindow("/en/company/contact_us.htm", content_page_constant);
					//}
	}else if (pageType=="HELP"){
		navigate_openContentPageWindow("/en/help/robohelp/mcc_online/!SSL!/FlashHelp/CSOnlineHelp.htm", content_page_constant);
	}else if (pageType=="AES_2008_10_12"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/aes_customer_communications.htm", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/aes_customer_communications.htm", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/aes_customer_communications.htm", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/aes_customer_communications.htm", content_page_constant);
		}
	}  else if (pageType=="SS_2009_03_15"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_3.15.09.pdf", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_3.15.09.pdf", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_3.15.09.pdf", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_3.15.09.pdf", content_page_constant);
		}
	}  else if (pageType=="SF_2008_11_23"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_11.23.08.pdf", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_11.23.08.pdf", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_11.23.08.pdf", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_11.23.08.pdf", content_page_constant);
		}
	}  else if (pageType=="AES_POE"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/help_sed_poe.htm", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/help_sed_poe.htm", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/help_sed_poe.htm", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/help_sed_poe.htm", content_page_constant);
		}
	}  else if (pageType=="AES_POU"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/help_sed_poul.htm", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/help_sed_poul.htm", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/help_sed_poul.htm", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/help_sed_poul.htm", content_page_constant);
		}
	}  else if (pageType=="AES_PARTY_STATE"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/help_sed_state_code.htm", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/help_sed_state_code.htm", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/help_sed_state_code.htm", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/help_sed_state_code.htm", content_page_constant);
		}
	}  else if (pageType=="AES_LICENSE_TYPE"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/help_sed_license_type.htm", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/help_sed_license_type.htm", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/help_sed_license_type.htm", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/help_sed_license_type.htm", content_page_constant);
		}
	}	else if (pageType=="SI_2009_01_11"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_1.11.09.pdf", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_1.11.09.pdf", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_1.11.09.pdf", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_1.11.09.pdf", content_page_constant);
		}
	}	else if (pageType=="SF_2008_10_12"){
		if (locale==content_page_locale_zh_cn){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_10.12.08.pdf", content_page_constant);
		}else if (locale==content_page_locale_zh_tw){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_10.12.08.pdf", content_page_constant);
		}else if (locale==content_page_locale_ja_JP){
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_10.12.08.pdf", content_page_constant);
		}else{
			navigate_openContentPageWindow("/en/help/app/CargoSmart_Release_Notes_10.12.08.pdf", content_page_constant);
		}
	}
}

function openAnnouncementInNewWindow (pageType, locale, link) {
	if (pageType=="CS_AEM"){
		navigate_openContentPageWindow(link, content_page_constant);
	}
}
/*---*/
/* cs2_ui.js */


/*-- Global Parameters--*/
var TChinese = "&#32321;&#39636;&#20013;&#25991;";  //UTF-8 coding
var SChinese = "&#31616;&#20307;&#20013;&#25991;"; //UTF-8 coding
var Japanese = "&#26085;&#26412;&#35486;"; 			//UTF-8 coding
var copyright = "Copyright &copy; 2000 - 2006 CargoSmart Limited. All rights reserved.";

function ui_getObjById(id_id){
	var _obj = document.getElementById(id_id);
	if (_obj != null) return _obj;
	_obj = document.getElementById("form:"+id_id);
	return _obj;
}

function ui_getObjsByName(str_name){
	var _objs = document.getElementsByName(str_name);
	if (_objs != null) return _objs;
	_objs = document.getElementsByName("form:"+str_name);
	return _objs;
}

/**
 * Trim the space from header and tail of the string.
 */
function ui_trim (str_string){
	var exp_Space_head  	= /^(\s+)(\S?.*)$/ ;  //define exp pattern, all space at header
	var exp_Space_tail    		= /^(.*\S+)(\s+)$/ ; //define exp pattern, all space at tail
	str_string = str_string.replace(exp_Space_head, "$2"); // remove the space at the header
	str_string = str_string.replace(exp_Space_tail, "$1"); // remove the space at the tail
	return str_string;
}

function ui_isInputEmptyValueAfterTrim(str_id){
	var obj = ui_getObjById(str_id);
	if(ui_trim(obj.value).length==0){
		return true;
	}
	return false;
}
/*
 * Check the select list whether has a option its label same as the specified.
 */
function ui_isOptionDuplicate (str_optionLabel, id_targetList){
	var _list = ui_getObjById(id_targetList);
	for (var i=0; i< _list.options.length; i++){
		if (_list.options[i].text == ui_trim(str_optionLabel)){
			return true; //return true if duplicate
		}
	}
	return false;

}

/**
 *  This is for Search box/Tab collapse or expand. (as the most prototype pages have use this function, just insert the original code without function standard.)
 *  You must specify the Div id which will be collapse or expand
 *  sample call:
 *   changeTab('collapse', 'expand');
 *
 *
 *
 */
function changeTab(topId, hiddenId){
	var topLayer = ui_getObjById(topId);
	var hiddenLayer = ui_getObjById(hiddenId);
	topLayer.style.display = "";
	hiddenLayer.style.display = "none";
}

/*
 * This function addes a new option to a SELECT list, and select the newly added option after then.
*/
function ui_addNewOption(str_newOptionValue, str_newOptionLabel, id_targetList) {

  if (!ui_isOptionDuplicate(str_newOptionLabel,id_targetList)){ //check the newly option if exist in the select list
  	//append the newly option to the select
  	var _selected_topic = new Option(ui_trim(str_newOptionLabel), ui_trim(str_newOptionValue), false, true); //new Option(text, value, defaultSelected, selected)
  	var _list = ui_getObjById(id_targetList);
	_list.options[_list.options.length] = _selected_topic;

	//select the newly added option
	if (_list.multiple){
		_list.options[_list.options.length-1].selected = true;
	}else{
		_list.selectedIndex = _list.options.length - 1;
	}
  }
}

function ui_check_all_check_boxes(id_select_all, name_items){
	var obj_select_all = document.getElementById(id_select_all);
	var obj_items = document.getElementsByName(name_items);
	if (obj_select_all!=null && obj_items!=null && obj_items.length>0){
		for (var i = 0; i <obj_items.length;i++){
			obj_items[i].checked = obj_select_all.checked;
		}
	}
}

function ui_check_select_all_check_box(id_select_all, name_items){
	var obj_select_all = document.getElementById(id_select_all);
	var obj_items = document.getElementsByName(name_items);
	if (obj_select_all!=null && obj_items!=null && obj_items.length>0){
		var counter = 0;
		for (var i = 0; i <obj_items.length;i++){
			if (obj_items[i].checked){
				counter++;
			}
		}
		obj_select_all.checked = (counter==obj_items.length);
	}
}

/*
 * Select all the options in the select list.
 */
function ui_selectAllOptions(id_targetList){
	var _list = ui_getObjById(id_targetList);
	if (_list.multiple){
		for (var i=0; i<_list.options.length; i++){
			_list.options[i].selected = true;
		}
	}
}


/*
 * Deselect all the selected options in the select list.
 */
function ui_deselectedOptions(id_targetList){
	ui_getObjById(id_targetList).selectedIndex = -1;
}

/*
 * Copy the selected options and put them in an array.
 */
function ui_copySelectedOptions(id_sourceList){
	var _list = ui_getObjById(id_sourceList);
	var _Options = new Array();
	for (var i=0; i<_list.options.length; i++){
		if (_list.options[i].selected){
			var _newOption = document.createElement('option');

			_newOption.text = _list.options[i].text;
			_newOption.value = _list.options[i].value;
			_Options[_Options.length] = _newOption;

		}
	}
	return _Options;
}

/*
 * Remove the selected options from the select list.
 */
function ui_removeSelectedOptions(id_targetList){
	var _list = ui_getObjById(id_targetList);
	for (var i=_list.options.length-1; i>-1; i--){
		if (_list.options[i].selected){
			_list.options[i] = null;
		}
	}
}

/*
 * Move the selected options from the source select list to the target select list. The moved options will be removed from the source list
 */
function ui_moveSelectedOptions(id_sourceList, id_targetList){

	var _selectedOptions = ui_copySelectedOptions(id_sourceList); //Get the selected options in the source list

	for (var i=0; i<_selectedOptions.length; i++){ //move the selected options to the target list
		ui_addNewOption(_selectedOptions[i].value, _selectedOptions[i].text, id_targetList);
	}

	ui_removeSelectedOptions(id_sourceList); //remove the selected options from the source list
}

/*
 * To check if at least one option has been selected in the select list.
 */
function ui_isAtLeastOneSelected(id_targetList){
	var _list = ui_getObjById(id_targetList);
	if (_list.selectedIndex != -1){
		return true;
	}else{
		return false;
	}
}

/*
 * Select the option in the select list if the option's label equal to the text specified by user.
 */
function ui_setSelectionInSelect(text, id_targetList) {
	var _list = ui_getObjById(id_targetList);
	for (var i = 0; i < _list.options.length; i++) {
		if ( _list.options[i].text == ui_trim(text) ) {
			_list.options[i].selected = true;
		}
	}
}

/*
 * Select the option in the select list if the option's value equal to the value specified by user.
 */
function setSelectionInSelect(val, id_targetList) {
	var list = ui_getObjById(id_targetList);
	for (var i = 0; i < list.options.length; i++) {
		if ( list.options[i].value == ui_trim(val) ) {
			list.options[i].selected = true;
			return true;
		}
	}
	return false;
}

/*
 * Select the options in the select list if the option's label equal to the array of text specified by user.
 */
function ui_setSelectionsInSelect(texts, id_targetList) {
	var _list = ui_getObjById(id_targetList);
	for (var i = 0; i < _list.options.length; i++) {
		for (var j = 0; j < texts.length; j++) {
			if ( _list.options[i].text == ui_trim(texts[j]) ) {
				_list.options[i].selected = true;
			}
		}
	}
}


/*
 * To check if the check box or radio has been checked.
 */
function ui_isChecked(id_ckbox){
	var _ckbox = ui_getObjById(id_ckbox);
	if (_ckbox.checked){
		return true;
	}else{
		return false;
	}

}

/*
 * Toggle the check box or radio button's checking status.
 */
function ui_toggleChecked(id_ckbox){
	var _ckbox = ui_getObjById(id_ckbox);
	_ckbox.checked = !_ckbox.checked;
}


/*
 * Set the check box or radio button as checked.
 */
function ui_setChecked(id_ckbox){
	var _ckbox = ui_getObjById(id_ckbox);
	_ckbox.checked = true;
}

/*
 * Set the associated check boxes as checked.
 */
function ui_toggleAssociatedCkboxes(arr_assocs){
	for (var i=0; i<arr_assocs.length; i++){

		ui_toggleChecked( arr_assocs[i] );
	}
}

/*
 * Reset all the radio buttons they are in same group (equal name)
 */
function ui_resetAllRadios(str_radioName){
	var _radios = ui_getObjsByName(str_radioName);
	for (var i=0; i<_radios.length; i++){
		_radios[i].checked = false;
	}

}

/*
 * Retrieve the selected value of the radio button.
 */
function ui_getSelectedRadioValue(str_name){
	var _radios = ui_getObjsByName(str_name);
	for (var i=0; i<_radios.length; i++){
		if (_radios[i].checked){
			return _radios[i].value;
		}
	}
}

/*
 * Set a new value to the input box.
 */
function ui_setInputValue(id_inputbox, str_value){
	ui_getObjById(id_inputbox).value = str_value;
}


/*
 * Highlights the value of the input box.
 */
function ui_highlightInputValue(id_inputbox){
	var _inputbox = ui_getObjById(id_inputbox);
	_inputbox.focus();
	_inputbox.select();
}

/*
 * Popup a new window at the top right screen.
 */
function ui_popupPage(str_url,str_winsize,str_winname,str_winparms) {
	if(str_url.indexOf("?")<0){
	  str_url += "?" ;
	}
	try{
	  str_url+="&USER_TOKEN="+USER_TOKEN+"&ENTRY="+ENTRY+"&ENTRY_TYPE="+ENTRY_TYPE+"&PREFER_LANGUAGE="+PREFER_LANGUAGE+"&OPERATOR_USER_ID="+OPERATOR_USER_ID;
	}catch(err){}
	var screen_ht = screen.availHeight;
	var screen_wd = screen.availWidth;
	var screen_left = 0;
	var screen_top = 10;
	if ( ui_trim(str_winparms) == '' ) {
		str_winparms = "scrollbars=1,resizable=1,status=1,";
	}else{
		str_winparms += ",";
	}

	if (str_winsize == "S") scalar = 0.33;

	else if (str_winsize == "M") scalar = 0.50;
		else if (str_winsize == "L") scalar = 0.75;
			else scalar = 0.9;
	w_ht = Math.round(scalar * screen_ht);
	w_wd = Math.round(scalar * screen_wd);
	w_left = (screen_wd - w_wd) - 20;
	str_winparms += "left=" + w_left + ",top=" + screen_top + ",screenX=" + w_left + ",screenY=" + screen_top + ",";
	str_winparms += "height=" + w_ht + ",width=" + w_wd;
	if (window.noncsWin) {
		if (!noncsWin.closed) noncsWin.close();
	}
	noncsWin = window.open(str_url,str_winname,str_winparms);
	return;
}

/*
 * Popup a warning window when user click a link links to outside
 */
function ui_popupExit(str_url){
	var FULL="toolbar,directories,resizable,status,scrollbars,menubar,location,";
	var screen_ht=screen.availHeight;
	var screen_wd=screen.availWidth;
	w_top = Math.round((screen_ht-300)*0.5);
	w_left= Math.round((screen_wd-460)*0.5);
	winparms = "width=460,height=200,";
	winparms += "left=" + w_left + ",top=" + w_top;
	exitWin=window.open('../mcc/exit.htm', 'cs_exist_warning_win', winparms);
	ui_popupPage(str_url,"X","noncs",FULL);
	exitWin.focus();
}

function ui_setFocus(id_id){
	ui_getObjById(id_id).focus();
}

/*
 * Output some text to the page.
 */
function ui_w(str_text){
	document.write(str_text);
}

/*
 * Jump to the specified anchor at the page
 */
function ui_jumpTo(str_anchor){
	if ( (ui_trim(str_anchor) != "") ) {
    	window.location.href = '#' + str_anchor;
	}
}

/*
 * Set a new button label to the button.
 */
function ui_setButtonLabel(id_button, str_label){
	ui_setInputValue(id_button, str_label);
}

/*
 * Hide the objects, and then display the objects in the page.
 */
function ui_switchVisibility(arr_hides, arr_displays){

	 //hide objects
	 if (arr_hides.length > 0){
		 for (var i = 0; i < arr_hides.length; i++){
			 var _obj = ui_getObjById( ui_trim(arr_hides[i]) );

			 _obj.style.display = 'none';
		 }
	 }

	 //display objects
	 if (arr_displays.length > 0){
		 for (var i = 0;i < arr_displays.length; i++){
			 var _obj = ui_getObjById( ui_trim(arr_displays[i]) );
			 _obj.style.display = '';

		 }
	 }
}

/*
 * Disable the objects, and then enable the objects in the page.
 */
function ui_switchAbility(arr_disables, arr_enables){

	 //disable objects
	 if (arr_disables.length > 0){
		 for (var i = 0; i < arr_disables.length; i++){
			 var _obj = ui_getObjById( ui_trim(arr_disables[i]) );
			 _obj.disabled = true;
			 if (_obj.type == "button") {
				 _obj.className = "disabledBtn";
			 }
			 else{
				 _obj.className = "disabledBox";
			 }
		 }
	 }

	 //enabled objects
	 if (arr_enables.length > 0){
		 for (var i = 0;i < arr_enables.length; i++){
			 var _obj = ui_getObjById( ui_trim(arr_enables[i]) );

			 _obj.disabled = false;
			 if (_obj.type == "button") {
				 _obj.className = "button";
			 }
			 else{
				 _obj.className = "";
			 }
		 }
	 }
  }

/*
 * Disable the object, and then enable the object in the page.
 */
function ui_collapseAndExpand(collapseId, expandId){
	var collapseLayer = document.getElementById(collapseId);
	var expandLayer = document.getElementById(expandId);
	collapseLayer.style.display = "";
	expandLayer.style.display = "none";
}


/*
 * Populate the select list from an array of grouping values according the group index.
 */
function ui_changeValueList(int_groupIndex, id_targetList, arr_values){
 	var _list = ui_getObjById(id_targetList);

	//clear the items from the list
 	for (var i=_list.options.length-1; i>-1; i--){
 		_list.options[i] = null;
 	}

 	//sort the values in Alphanumeric and populate the list
 	(arr_values[int_groupIndex]).sort();
 	for (var i=0; i<(arr_values[int_groupIndex]).length; i++){
 		var _newOption = new Option(arr_values[int_groupIndex][i],arr_values[int_groupIndex][i], false, false);
 		_list.options[_list.options.length] = _newOption;
 	}


}

/*
 * Assign a new style class name to the objects
 */
function ui_changeStyleClass(arr_objs, str_className){
	for (var i=0; i<arr_objs.length; i++){
		ui_getObjById( ui_trim(arr_objs[i]) ).className = str_className;
	}
}



/*
 * Dynamic adding javascript code into the page. <a href="cs2sample.htm#ui_writeJScode" target="cs2sample">see sample</a>
 */
function ui_writeJScode(str_jscode){
	_script = document.createElement("script");
	_script.text = str_jscode;
	document.documentElement.childNodes[0].appendChild(_script);
}

/*
 * Generate space instead using &#160;
 */
function ui_spacer(int_pixel){
	var _imagepath = ""; //specified the path to the spacer.gif
	document.writeln("<img src='" + global_image_path + "spacer.gif' width='" + int_pixel + "' HEIGHT='1'>");
}

/*
 * Popup the confirm message window when user attend delete the record
 */
function ui_delConfirmMsg(str_objname, str_newMsg, str_dest){
	var _msg = "Do you want to delete the " + str_objname + "? \n\nOnce the " +
				str_objname + " is deleted, it cannot be recovered.";
	if (ui_trim(str_newMsg).length !=0){
		_msg = str_newMsg;
	}
	if (window.confirm(_msg)){
		location.href = str_dest;

	}
}


function ui_addEventListener(obj_obj, str_eventName, pt_func){
	if (document.all){
		obj_obj.attachEvent(str_eventName,pt_func);
	}else{
		obj_obj.addEventListener(str_eventName,pt_func);
	}
}


function ui_removeEventListener(obj_obj, str_eventName, pt_func){
	if (document.all){
		obj_obj.detachEvent(str_eventName,pt_func);
	}else{
		obj_obj.removeEventListener(str_eventName,pt_func);
	}
}


/*
 * Popup a window at the center of the screen with size of 600(w)*480(h) and resizable.
 */
function ui_popupCenter(str_url,str_winname,str_winparms){
	var _screen_ht = screen.availHeight;
	var _screen_wd = screen.availWidth;
	var _win_ht = 480;
	var _win_wd = 600;
	w_top = Math.round((_screen_ht - _win_ht)*0.5);
	w_left= Math.round((_screen_wd - _win_wd)*0.5);
	str_winparms = ( ui_trim(str_winparms).length==0)?"scrollbars=yes,resizable=yes,status=yes,location=no,menubar=no,toolbar=no,width=" +_win_wd+ ",height=" +_win_ht+ ",":"scrollbars=yes,resizable=yes,status=yes,location=no,menubar=no,toolbar=no,width=" +_win_wd+ ",height=" +_win_ht+ "," + str_winparms;
	str_winparms += "left=" + w_left + ",top=" + w_top;
	_win=window.open(str_url, str_winname, str_winparms);
	_win.focus();
}



/**
 *  pops up a browser window and gives it focus.
 *  opens three standard sizes: s(mall), m(edium), and l(arge)
 *   ui_popupPrintableWin('../partnership/crm_create2a.htm','relnwin','m');
 */
function ui_popupPrintableWin(str_url,str_windowname, str_winsize) {
		str_winsize = str_winsize.toUpperCase();
		var ht = screen.availHeight;
		var wd = screen.availWidth;
		var left = 0;
		var top = 10;
		if (str_winsize == "S") scalar = 0.33;
		 else if (str_winsize == "M") scalar = 0.50;
		  else scalar = 0.75;
		w_ht = Math.round(scalar * ht);
		w_wd = Math.round(scalar * wd);
		left = (wd - w_wd) - 20;
		var windowparms = "menubar,scrollbars,resizable,status";
		windowparms += "left=" + left + ",top=" + top + ",screenX=" + left + ",screenY=" + top + ",";
		windowparms += "height=" + w_ht + ",width=" + w_wd;
		if (window.NewWindow) {
		   if (!NewWindow.closed) NewWindow.close();
		   }
		NewWindow = window.open(str_url,str_windowname,windowparms);
		NewWindow.window.focus();
 }




/*---*/
/* internal.js */

function swichSearchTable(showTableID, hideTableID){
	var hideTableObj = document.getElementById(hideTableID);
	hideTableObj.style.display = "none";
	var showTableObj = document.getElementById(showTableID);
	showTableObj.style.display = "";
}

function display_group_details(Flag,ppID,text_hide,text_show){
	var disply_obj = document.getElementById("detailsRow"+ppID);
	var hyperlink_obj = document.getElementById("hyperlinkTd"+ppID);
	if (Flag == '1') {
		disply_obj.style.display = "";
		hyperlink_obj.innerHTML = "<a href=\"javascript:void(0);\" onClick=\"javascript:display_group_details('0','"+ppID+"','"+text_hide+"','"+text_show+"');\">"+text_hide+"</a>";
		}
	else {
		disply_obj.style.display = "none";
		hyperlink_obj.innerHTML = "<a href=\"javascript:void(0);\" onClick=\"javascript:display_group_details('1','"+ppID+"','"+text_hide+"','"+text_show+"');\">"+text_show+"</a>";
		}
}

/*---*/
/* public.js */

// this function strips out all the tedious #text elements that firefox has attached to tables
function cleanTable(tableElement)
{
	var numTextElementsRemoved = 0;
	if (tableElement.nodeName != 'TD' && tableElement.nodeName != 'TH')
	{
		numTextElementsRemoved += cleanElement(tableElement);
		var node = tableElement.firstChild;
		while (node != null)
		{
			numTextElementsRemoved += cleanTable(node);
			node = node.nextSibling;
		}
	}
	return numTextElementsRemoved;
}

// removes all #text elements directly attached to the node.
function cleanElement(element)
{
	if (element == null) return 0;
	var numTextElementsRemoved = 0;
	var node = element.firstChild;
	while (node != null)
	{
		var tmp = node.nextSibling;
		if (node.nodeName == '#text')
		{
			element.removeChild(node);
			numTextElementsRemoved++;
		}
		node = tmp;
	}
	return numTextElementsRemoved;
}

function restructrueTableForSpecifiedColumnCount(tableName, columnCount, render){
	var obj_table = document.getElementById(tableName);
	if (obj_table!=null){
		cleanTable(obj_table);
		var obj_tbody = obj_table.firstChild;
		var obj_element_total = 0;

		for (var i=obj_tbody.firstChild.childNodes.length-1;i>=0;i--){
			if("TD"==obj_tbody.firstChild.childNodes[i].tagName){
				obj_element_total ++;
			}else{
				obj_tbody.firstChild.removeChild(obj_tbody.firstChild.childNodes[i]);
			}
		}


		if (obj_element_total>0){
			var rows=0;

			if (obj_element_total%columnCount ==0){
				rows=obj_element_total/columnCount;
			}else{
				rows=Math.floor(obj_element_total/columnCount) + 1;
			}

			for (r=0;r<rows;r++){
				var obj_row = document.createElement("tr");
				obj_tbody.appendChild(obj_row);
			}

			var counter=0;
			for (var r=1;r<rows+1;r++){

				for (var c=0;c <columnCount;c++){
					var obj_cell = document.createElement("td");
					var htmlContent="";
					if (counter < obj_element_total){
						htmlContent+= "<td " + render + ">";
						htmlContent+= obj_tbody.firstChild.childNodes[counter].innerHTML;
						htmlContent+= "</td>";
						obj_tbody.childNodes[r].appendChild(obj_cell);
						obj_tbody.childNodes[r].lastChild.innerHTML =htmlContent;

						counter++;
						continue;
					}
						htmlContent+= "<td " + render + ">&#160;&#160;";
						htmlContent+= "</td>";
						obj_tbody.childNodes[r].appendChild(obj_cell);
						obj_tbody.childNodes[r].lastChild.innerHTML =htmlContent;

				}
			}

			obj_tbody.removeChild(obj_tbody.firstChild);
			obj_table.width = "100%";
		}
	}
}

function alignTableCellsToTopAndSetWidth (tableName, width){
	var _obj_table = document.getElementById(tableName);
	cleanTable(_obj_table);
	if (_obj_table!=null){
		for (r=0;r<_obj_table.rows.length;r++){
			for (c=0;c<_obj_table.rows[r].cells.length;c++){
				_obj_table.rows[r].cells[c].vAlign= "top";
				_obj_table.rows[r].cells[c].width = width;

			}
		}
	}

}

function checkAccordingToValues(values, inputs){
	for(var i = 0; i < inputs.length; i++){
		var found = false;
		for(var j = 0; j < values.length; j++){
			if(inputs[i].value == values[j]){
				found = true;
				break;
			}
		}
		inputs[i].checked = found;
	}
}

function templateMask(){return ui_getObjById("mask");}



function showPoplayer(poplayerDivId, zIndex){
    zIndex = zIndex || 1000;
    templateMask().style.visibility = "visible";
    templateMask().style.display = "";
        templateMask().style.width = (document.compatMode=="CSS1Compat" ?document.documentElement.clientWidth:document.body.clientWidth)+'px';
        if (navigator.appName =="Microsoft Internet Explorer" ){
            templateMask().style.height = (document.compatMode=="CSS1Compat" ?document.documentElement.scrollHeight:document.body.scrollHeight)+'px';
    }else if (navigator.appName =="Netscape"){

        templateMask().style.height = document.documentElement.scrollHeight+"px";
    }

    templateMask().style.zIndex = zIndex;

    poplayerDiv = ui_getObjById(poplayerDivId);
    poplayerDiv.style.display = "";
    poplayerDiv.style.visibility = "visible";
    putPoplayerInCenter(poplayerDiv);
    poplayerDiv.style.zIndex = zIndex+1;
}


function putPoplayerInCenter(poplayerDiv){
	C_width = document.compatMode=="CSS1Compat" ? (document.documentElement.clientWidth - document.documentElement.scrollLeft) : (document.body.clientWidth - document.body.scrollLeft);
	C_height = document.compatMode=="CSS1Compat" ?  (document.documentElement.clientHeight) : (document.body.clientHeight);
	C_top = document.compatMode=="CSS1Compat" ? (document.documentElement.scrollTop) : (document.body.scrollTop);
	C_left = document.compatMode=="CSS1Compat" ? (document.documentElement.scrollLeft) : (document.body.scrollLeft);
	var L_width = poplayerDiv.offsetWidth;
	var L_height = poplayerDiv.offsetHeight;
	poplayerDiv.style.left = C_left + (C_width - L_width)/2 +"px";
	poplayerDiv.style.top = C_top + (C_height - L_height)/2 +"px";
}

function closePoplayer(poplayerDivId){
	poplayerDiv = ui_getObjById(poplayerDivId);
	if (poplayerDiv != null && poplayerDiv.style.display != "none"){
        $(".ac_results").hide();
        poplayerDiv.style.display = "none";
	}

   templateMask().style.display = "none";
}

// Time Glass
function hideShowTimeGlass(show) {
	var mask = ui_getObjById("mask");
	var dialog = ui_getObjById("dialog");
	if (show){
		mask.style.display = "none";
		//dialog.style.display = "none";
		dialog.style.top = "-6000px";
	}else {
		mask.style.display = "";
		dialog.style.di = "";
	}
}

var currentInterval;
function showTimeGlass(show){

	if (show){
		showPoplayer("dialog", 2000);
        setAllSelectVisibility("hidden");
        currentInterval = window.setInterval(startProgress,20);
	}else{
		closePoplayer("dialog");
        setAllSelectVisibility("visible");
        if (currentInterval != null){
		    window.clearInterval(currentInterval);
		    currentInterval == null;
		}
	}

	ui_getObjById("content").style.visibility = "visible"; //show the MCC at last. it must be the last action.
	return true;
}

function setAllSelectVisibility(visibility) {
    $("select[@scopt!='dialog']").each(function() {
        this.style.visibility=visibility;
    })
}

function resizeMask(){
    var mask = ui_getObjById("mask");
    // mask.style.height=document.body.scrollHeight;
    if (document.body.clientWidth< ui_getObjById("contentTable").clientWidth){

        mask.style.width = (ui_getObjById("contentTable").clientWidth+20)+'px';
    }else{
        mask.style.width = (document.compatMode=="CSS1Compat" ?document.documentElement.clientWidth:document.body.clientWidth)+'px';
    }
    if (mask.style.display == ""){
        var dialog = ui_getObjById("dialog");
        putPoplayerInCenter(dialog);
        //dialog.style.left = Math.abs(document.body.clientWidth-dialog.clientWidth)/2 ;
        //dialog.style.top = Math.abs(document.body.clientHeight-dialog.clientHeight)/2 ;
    }
}

function startProgress(){
	var mask = ui_getObjById("progressBarMask");
	var left = mask.style.left.substr(0, mask.style.left.length-2);
		left = parseInt(left);

	if (left < 0){
		mask.style.left = (left + 2)+"px";
	}else{

		mask.style.left = "-280px";
	}


}


// Compare two options within a list by VALUES
function compareOptionValues(a, b) {
  // Radix 10: for numeric values
  // Radix 36: for alphanumeric values
  var sA = parseInt( a.value, 36 );
  var sB = parseInt( b.value, 36 );
  return sA - sB;
}

// Compare two options within a list by TEXT
function compareOptionText(a, b) {
  // Radix 10: for numeric values
  // Radix 36: for alphanumeric values
  var sA = parseInt( a.text, 36 );
  var sB = parseInt( b.text, 36 );
  return sA - sB;
}

// Dual list move function
function moveDualList( srcList, destList, moveAll ) {
  // Do nothing if nothing is selected
  if (( srcList.selectedIndex == -1) && (moveAll == false)){
    return;
  }
  newDestList = new Array( destList.options.length );
  var len = 0;
  for( len = 0; len < destList.options.length; len++ ){
    if ( destList.options[ len ] != null ){
      newDestList[ len ] = new Option( destList.options[ len ].text, destList.options[ len ].value, destList.options[ len ].defaultSelected, destList.options[ len ].selected );
    }
  }

  for( var i = 0; i < srcList.options.length; i++ ){
    if ( srcList.options[i] != null && ( srcList.options[i].selected == true || moveAll ) ){
       // Statements to perform if option is selected
       // Incorporate into new list
       newDestList[ len ] = new Option( srcList.options[i].text, srcList.options[i].value, srcList.options[i].defaultSelected, srcList.options[i].selected );
       len++;
    }

  }



  // Sort out the new destination list

  newDestList.sort( compareOptionValues );   // BY VALUES
  //newDestList.sort( compareOptionText );   // BY TEXT
  // Populate the destination with the items from the new array

  for ( var j = 0; j < newDestList.length; j++ ) {
    if ( newDestList[ j ] != null )
    {
      destList.options[ j ] = newDestList[ j ];
    }
  }

  for( var i = srcList.options.length - 1; i >= 0; i-- )
  {
    if ( srcList.options[i] != null && ( srcList.options[i].selected == true || moveAll ) )
    {
       srcList.options[i]       = null;
    }
  }
}

var news_title = new Array();
var news_content = new Array();
var news_link = new Array();

var is_news_displayed = false;

var spotlight_date = new Array();
var spotlight_content = new Array();
var spotlight_link = new Array();

var is_spotlight_displayed = false;

function isAnnouncementEmpty(){
	return (news_title.length==0);
}

function isSpotlightEmpty(){
	return (spotlight_date.length==0);
}

function getContentsOfAnnouncement(){
	document.writeln("<table width=\"100%\" border=\"0\" cellspacing=\"0\ cellpadding=\"0\">");
	for (var i=0;i<news_title.length;i++){
		document.writeln("<tr><td><a href=\"" + news_link[i] + "\" target=\"_blank\">" + news_title[i] + "</a>");
		document.writeln(news_content[i] + "</td></tr><tr><td>&#160;</td></tr>");
	}
	document.writeln("</table>");
}

function getContentsOfSpotlight(){
	document.writeln("<table width=\"100%\" border=\"0\" cellspacing=\"0\ cellpadding=\"0\">");
		for (var i=0;i<spotlight_date.length;i++){
		document.writeln("<tr><td valign=\"top\" class=\"bulletItem\"><img src=\"../images/bullet_blue.gif\" width=\"8\" height=\"8\"/></td>");
		document.writeln("<td class=\"contentItem\">" + spotlight_date[i] + " <a href=\"" + spotlight_link[i] + "\" target=\"_blank\">" + spotlight_content[i] + "</a>&#160;</td></tr>");
	}
	document.writeln("</table>");
}



/*---*/
/* robohelp_csh.js */

// eHelp?Corporation
// Copyright?1998-2002 eHelp?Corporation.All rights reserved.
// RoboHelp_CSH.js
// The Helper function for WebHelp Context Sensitive Help

//     Syntax:
//     function RH_ShowHelp(hParent, a_pszHelpFile, uCommand, dwData)
//
//     hParent
//          Reserved - Use 0
//
//     pszHelpFile
//          WebHelp:
//               Path to help system start page ("http://www.myurl.com/help/help.htm" or "/help/help.htm")
//               For custom windows (defined in Help project), add ">" followed by the window name ("/help/help.htm>mywin")
//
//          WebHelp Enterprise:
//               Path to RoboEngine server ("http://RoboEngine/roboapi.asp")
//               If automatic merging is turned off in RoboEngine Configuration Manager, specify the project name in the URL ("http://RoboEngine/roboapi.asp?project=myproject")
//               For custom windows (defined in Help project), add ">" followed by the window name ("http://RoboEngine/roboapi.asp>mywindow")
//
//     uCommand
//          Command to display help. One of the following:
//                    HH_HELP_CONTEXT     // Displays the topic associated with the Map ID sent in dwData
//											if 0, then default topic is displayed.
//               The following display the default topic and the Search, Index, or TOC pane.
//               Note: The pane displayed in WebHelp Enterprise will always be the window's default pane.
//                    HH_DISPLAY_SEARCH
//                    HH_DISPLAY_INDEX
//                    HH_DISPLAY_TOC
//
//     dwData
//          Map ID associated with the topic to open (if using HH_HELP_CONTEXT), otherwise 0
//
//     Examples:
//     <p>Click for <A HREF='javascript:RH_ShowHelp(0, "help/help.htm", 0, 10)'>Help</A> (map number 10)</p>
//     <p>Click for <A HREF='javascript:RH_ShowHelp(0, "help/help.htm>mywindow", 0, 100)'>Help in custom window (map number 100)</A></p>


var gbNav6=false;
var gbNav61=false;
var gbNav4=false;
var gbIE4=false;
var gbIE=false;
var gbIE5=false;
var gbIE55=false;

var gAgent=navigator.userAgent.toLowerCase();
var gbMac=(gAgent.indexOf("mac")!=-1);
var gbSunOS=(gAgent.indexOf("sunos")!=-1);
var gbOpera=(gAgent.indexOf("opera")!=-1);

var HH_DISPLAY_TOPIC = 0;
var HH_DISPLAY_TOC = 1;
var HH_DISPLAY_INDEX = 2;
var HH_DISPLAY_SEARCH = 3;
var HH_HELP_CONTEXT = 15;

var gVersion=navigator.appVersion.toLowerCase();

var gnVerMajor=parseInt(gVersion);
var gnVerMinor=parseFloat(gVersion);

gbIE=(navigator.appName.indexOf("Microsoft")!=-1);
if(gnVerMajor>=4)
{
	if(navigator.appName=="Netscape")
	{
		gbNav4=true;
		if(gnVerMajor>=5)
			gbNav6=true;
	}
	gbIE4=(navigator.appName.indexOf("Microsoft")!=-1);
}
if(gbNav6)
{
	document.gnPageWidth=innerWidth;
	document.gnPageHeight=innerHeight;
	var nPos=gAgent.indexOf("netscape");
	if(nPos!=-1)
	{
		var nVersion=parseFloat(gAgent.substring(nPos+10));
		if(nVersion>=6.1)
			gbNav61=true;
	}
}else if(gbIE4)
{
	var nPos=gAgent.indexOf("msie");
	if(nPos!=-1)
	{
		var nVersion=parseFloat(gAgent.substring(nPos+5));
		if(nVersion>=5)
			gbIE5=true;
		if(nVersion>=5.5)
			gbIE55=true;
	}
}

function RH_ShowHelp(hParent, a_pszHelpFile, uCommand, dwData)
{
	// this function only support WebHelp
	var strHelpPath = a_pszHelpFile;
	var strWnd = "";
	var nPos = a_pszHelpFile.indexOf(">");
	if (nPos != -1)
	{
		strHelpPath = a_pszHelpFile.substring(0, nPos);
		strWnd = a_pszHelpFile.substring(nPos+1);
	}
	if (isServerBased(strHelpPath))
		RH_ShowWebHelp_Server(hParent, strHelpPath, strWnd, uCommand, dwData);
	else
		RH_ShowWebHelp(hParent, strHelpPath, strWnd, uCommand, dwData);
}

function RH_ShowWebHelp_Server(hParent, strHelpPath, strWnd, uCommand, dwData)
{
	// hParent never used.
	ShowWebHelp_Server(strHelpPath, strWnd, uCommand, dwData);
}

function RH_ShowWebHelp(hParent, strHelpPath, strWnd, uCommand, dwData)
{
	// hParent never used.
	ShowWebHelp(strHelpPath, strWnd, uCommand, dwData);
}


function ShowWebHelp_Server(strHelpPath, strWnd, uCommand, nMapId)
{
	var a_pszHelpFile = "";
	if (uCommand == HH_HELP_CONTEXT)
	{
		if (strHelpPath.indexOf("?") == -1)
			a_pszHelpFile = strHelpPath + "?ctxid=" + nMapId;
		else
			a_pszHelpFile = strHelpPath + "&ctxid=" + nMapId;
	}
	else
	{
		if (strHelpPath.indexOf("?") == -1)
			a_pszHelpFile = strHelpPath + "?ctxid=0";
		else
			a_pszHelpFile = strHelpPath + "&ctxid=0";
	}

	if (strWnd)
		a_pszHelpFile += ">" + strWnd;

	if (gbIE4)
	{
		a_pszHelpFile += "&cmd=newwnd&rtype=iefrm";
		loadData(a_pszHelpFile);
	}
	else if (gbNav4)
	{
		a_pszHelpFile += "&cmd=newwnd&rtype=nswnd";
		var sParam = "left="+screen.width+",top="+screen.height+",width=100,height=100";
		window.open(a_pszHelpFile, "__webCshStub", sParam);
	}
	else
	{
		var sParam = "left="+screen.width+",top="+screen.height+",width=100,height=100";
		if (gbIE5)
			window.open("about:blank", "__webCshStub", sParam);
		window.open(a_pszHelpFile, "__webCshStub");
	}
}


function ShowWebHelp(strHelpPath, strWnd, uCommand, nMapId)
{
	var a_pszHelpFile = "";
	if (uCommand == HH_DISPLAY_TOPIC)
	{
		a_pszHelpFile = strHelpPath + "#<id=0";
	}
	if (uCommand == HH_HELP_CONTEXT)
	{
		a_pszHelpFile = strHelpPath + "#<id=" + nMapId;
	}
	else if (uCommand == HH_DISPLAY_INDEX)
	{
		a_pszHelpFile = strHelpPath + "#<cmd=idx";
	}
	else if (uCommand == HH_DISPLAY_SEARCH)
	{
		a_pszHelpFile = strHelpPath + "#<cmd=fts";
	}
	else if (uCommand == HH_DISPLAY_TOC)
	{
		a_pszHelpFile = strHelpPath + "#<cmd=toc";
	}
	if (strWnd)
		a_pszHelpFile += ">>wnd=" + strWnd;

	if (a_pszHelpFile)
	{
		if (gbIE4)
			loadData(a_pszHelpFile);
		else if (gbNav4)
		{
			var sParam = "left="+screen.width+",top="+screen.height+",width=100,height=100";
			window.open(a_pszHelpFile, "__webCshStub", sParam);
		}
		else
		{
			var sParam = "left="+screen.width+",top="+screen.height+",width=100,height=100";
			if (gbIE5)
				window.open("about:blank", "__webCshStub", sParam);
			window.open(a_pszHelpFile, "__webCshStub");
		}
	}
}

function isServerBased(a_pszHelpFile)
{
	if (a_pszHelpFile.length > 0)
	{
		var nPos = a_pszHelpFile.lastIndexOf('.');
		if (nPos != -1 && a_pszHelpFile.length >= nPos + 4)
		{
			var sExt = a_pszHelpFile.substring(nPos, nPos + 4);
			if (sExt.toLowerCase() == ".htm")
			{
				return false;
			}
		}
	}
	return true;
}

function getElement(sID)
{
	if(document.getElementById)
		return document.getElementById(sID);
	else if(document.all)
		return document.all(sID);
	return null;
}

function loadData(sFileName)
{
	if(!getElement("dataDiv"))
	{
		if(!insertDataDiv())
		{
			gsFileName=sFileName;
			return;
		}
	}
	var sHTML="";
	if(gbMac)
		sHTML+="<iframe name=\"__WebHelpCshStub\" src=\""+sFileName+"\"></iframe>";
	else
		sHTML+="<iframe name=\"__WebHelpCshStub\" style=\"visibility:hidden;width:0;height:0\" src=\""+sFileName+"\"></iframe>";

	var oDivCon=getElement("dataDiv");
	if(oDivCon)
	{
		if(gbNav6)
		{
			if(oDivCon.getElementsByTagName&&oDivCon.getElementsByTagName("iFrame").length>0)
			{
				oDivCon.getElementsByTagName("iFrame")[0].src=sFileName;
			}
			else
				oDivCon.innerHTML=sHTML;
		}
		else
			oDivCon.innerHTML=sHTML;
	}
}

function insertDataDiv()
{
	var sHTML="";
	if(gbMac)
		sHTML+="<div id=dataDiv style=\"display:none;\"></div>";
	else
		sHTML+="<div id=dataDiv style=\"visibility:hidden\"></div>";

	document.body.insertAdjacentHTML("beforeEnd",sHTML);
	return true;
}



/*---*/
/* spotlight_announcement.js */


// News & Downtime
is_news_displayed = true;

news_title[0]   = "Scheduled Downtime1:";
news_content[0] = "16 Sept 2006 16:30 - 17 Sept 2006 09:00 PST , the downtime period for other time zones can be found by clicking here.";
news_link[0]    = "http://www.baidu.com";

news_title[1]   = "Scheduled Downtime2:";
news_content[1] = "16 Nov 2007 16:30 - 17 Sept 2006 09:00 PST , the downtime period for other time zones can be found by clicking here.";
news_link[1]    = "http://www.google.com";


// Spotlight
is_spotlight_displayed = true;

spotlight_date[0]    = "Jan 11, 2007";
spotlight_content[0] = "CargoSmart Ltd., annoucement... ... ";
spotlight_link[0]    = "http://www.cargosmart.com";

spotlight_date[1]    = "Nov 10, 2006";
spotlight_content[1] = "Latest Press Releases, nau das is es, habe heute mal die pink";
spotlight_link[1]    = "http://www.oocl.com";

spotlight_date[2]    = "Jan 11, 2007";
spotlight_content[2] = "CargoSmart Ltd., annoucement... ...";
spotlight_link[2]    = "http://www.oocl.com";



/*---*/
/* tips.js */
var SET_NO_WRAP = "nowrap";
var OFFSET_LEFT = 16;
var OFFSET_TOP = 18;
var IMG_PATH = "../skin/images/";
var MIN_SCREEN_WIDTH = 480;
var MIN_SCREEN_WIDTH_BR = 700;
var MIN_SCREEN_HEIGHT;

function setTableClass(myTable, tipsClassName){
	myTable.className = tipsClassName;
}

function removeLayer(myLayer){
	if(myLayer){
		setLayerHidden(myLayer);
		document.body.removeChild(myLayer);
	}
}

function setLayerHidden(myLayer){
	if(myLayer){
		myLayer.style.visibility = "hidden";
		myLayer.style.position = "absolute";
	}
}

function setLayerVisible(myLayer){
	if(myLayer){
		myLayer.style.visibility = "visible";
		myLayer.style.position = "absolute";
	}
}

function createTipsLayer(layerId, msg, zIndex, hasBrTag){
	var newLayer = document.createElement("div");
	newLayer.id = layerId;
	setLayerHidden(newLayer);
	var finalParent = document.body;
	finalParent.appendChild(newLayer);
	var newTable = createTable(1, 1);
	newLayer.appendChild(newTable);
	setTableClass(newTable, "dynamicTips");
	setTableValue(newTable, msg, hasBrTag);
	newLayer.style.zIndex = zIndex;
	return newLayer;
}


function createMaskLayer(layerId, obj, zIndex, hasBrTag){
	var myTd = obj.firstChild.firstChild.firstChild.firstChild;
	var isNoWrap = myTd.noWrap;
	var width = 0;
	var height = 0;
	if(isNoWrap){
		width =  obj.offsetWidth;
		height = obj.offsetHeight;
	}else{
		if(hasBrTag){
			width = MIN_SCREEN_WIDTH_BR;
		}else{
			width = MIN_SCREEN_WIDTH;
		}
		height = obj.offsetHeight;
	}
	MIN_SCREEN_HEIGHT = height;
	var pos = getObjectPosition(obj);
	var maskLayer = document.createElement("div");
	maskLayer.id = layerId;
	maskLayer.style.position = "absolute";
	var maskIframe = document.createElement("iframe");
	maskIframe.src = "/billing/common/cs.htm";
	maskLayer.appendChild(maskIframe);
	var nav = navigator.appVersion;
	maskIframe.style.width = nav.substr(nav.indexOf('MSIE')+5,3)<7.0 ? width : 0;
	maskIframe.style.height = height;
	maskIframe.style.zIndex = zIndex;
	maskIframe.style.borderWidth = 0;
	maskIframe.style.position = "absolute";
	document.body.appendChild(maskLayer);
	return maskLayer;
}


function setTableValue(myTable, msg, hasBrTag){
	var myTbody = myTable.firstChild;
	if(!myTbody) return;
	for(i = 0; i < myTbody.childNodes.length; i++){
		var myTr = myTbody.childNodes[i];
		for(j = 0; j < myTr.childNodes.length; j++){
			var myTd = myTr.childNodes[j];
			myTd.innerHTML = msg;
			var msgWidth = MIN_SCREEN_WIDTH;
			if(hasBrTag){
				msgWidth = MIN_SCREEN_WIDTH_BR;
			}
			if(myTd.offsetWidth < msgWidth){
				myTd.noWrap = SET_NO_WRAP;
			}else{
				myTd.style.width = msgWidth + "px";
			}
		}
	}
}

function createTable(numRow, numCol){
	var newTable = document.createElement("table");
	var newTbody = document.createElement("tbody");
	newTable.appendChild(newTbody);
	for(i = 0; i < numRow; i++){
		var newTr = document.createElement("tr");
		newTbody.appendChild(newTr);

		for(j = 0; j < numCol; j++){
			var newTd = document.createElement("td");
			newTd.innerHTML = "";
			newTr.appendChild(newTd);
		}
	}
	return newTable;
}

function getObjectPosition(inputObj){

	var left = inputObj.offsetLeft;
	var top = inputObj.offsetTop;
	var myParent = inputObj.offsetParent;
	while (myParent != null) {
		left += myParent.offsetLeft;
		top += myParent.offsetTop;
		myParent = myParent.offsetParent;
	}
	var pos = new Object();
	pos.x = left;
	var cHeight = document.compatMode=="CSS1Compat" ? document.documentElement.clientHeight : document.body.clientHeight;
	var scrollHeight = document.compatMode=="CSS1Compat" ? document.documentElement.scrollTop : document.body.scrollTop;
	if ((cHeight - top - MIN_SCREEN_HEIGHT + scrollHeight -16) >0) {
		pos.y = top;
	}else{
		pos.y = top - MIN_SCREEN_HEIGHT - 20;
	}
	return pos;
}

function setLayerPosition(layer, mskLayer, pos, hasBrTag){
	layer.style.top = pos.y + "px";
	mskLayer.style.top = pos.y + "px";
	layer.style.left = pos.x;
	var myTd = layer.firstChild.firstChild.firstChild.firstChild;
	var isNoWrap = myTd.noWrap;
	var width = 0;
	if(isNoWrap){
		width = layer.offsetWidth;
	}else{
		if(hasBrTag){
			width = MIN_SCREEN_WIDTH_BR+20;
		}else{
			width = MIN_SCREEN_WIDTH+20;
		}
	}
	var widthOverflow = document.compatMode=="CSS1Compat" ? (pos.x + width - document.documentElement.clientWidth - document.documentElement.scrollLeft) : (pos.x + width - document.body.clientWidth - document.body.scrollLeft);
	if (widthOverflow <=0 ) widthOverflow = 0;
	layer.style.left = (pos.x - widthOverflow > 0 ? pos.x - widthOverflow : 0) + "px";
	mskLayer.style.left = layer.style.left;
}



function showTips(icon, hasBrTag, msg){
	var tipsLayer =  document.getElementById(icon.id+"TipsLayer");
	var maskLayer = document.getElementById(icon.id+"MaskLayer");
	if ( !tipsLayer || !maskLayer) {
		var zIndex = 1;
		tipsLayer = createTipsLayer(icon.id+"TipsLayer", msg, zIndex+1, hasBrTag);
		maskLayer = createMaskLayer(icon.id+"MaskLayer",tipsLayer, zIndex, hasBrTag);
	}else{
		return;
	}
	var pos = getObjectPosition(icon);
	pos.x=pos.x+OFFSET_LEFT;
	pos.y=pos.y+OFFSET_TOP;
  setLayerPosition(tipsLayer,maskLayer, pos, hasBrTag);
	setLayerVisible(tipsLayer);
	setLayerVisible(maskLayer);
}

function hideTips(icon){
	var tipsLayer =  document.getElementById(icon.id+"TipsLayer");
	var maskLayer = document.getElementById(icon.id+"MaskLayer");
	removeLayer(tipsLayer);
	removeLayer(maskLayer);
}


function drawTipsIcon(iconName, id, tips){
//iconName is the filename of the icon,  id is the id of the icon in HTML, must specify,  tips is the text of tips, can use <br> to break into several lines.
	var hasBrTag = false;
	if(tips.indexOf("<br/>")>=0 || tips.indexOf("<br>")>=0){
		hasBrTag = true;
	}
	var newSec = tips.split('"');
	tips = '';
	for(i=0; i<newSec.length-1; i++){
		tips = tips + newSec[i] + '&quot;';
	}
	tips = tips + newSec[newSec.length-1];
	var newSec2 = tips.split("'");
	tips = "";
	for(i=0; i<newSec2.length-1; i++){
		tips = tips + newSec2[i] + "\\'";
	}
	tips = tips + newSec2[newSec2.length-1];
	document.write('&#160;<img src="' + global_image_path + iconName + '" onMouseOver="showTips(this,' + hasBrTag + ', \'' + tips + '\');" onMouseOut="hideTips(this);" />' );
}

/**
* code for multiple checkbox cascade.
* add by agen
*/
function setSelectedFunctions(thisCheckBox){
	operateTopWhenClickSub(thisCheckBox);
	var selectedBoxs = getAllSelectedSubFunctions();
	document.getElementById("form:hidden_functions").value= selectedBoxs;
}

function getAllSelectedSubFunctions(){
	var subFunctions = new Array();
	var obj=document.getElementsByTagName("input");
	for(i=0, j=0;i < obj.length;i++)
	{
   		if(obj[i].type=="checkbox")
 			{
 				if(obj[i].checked== true)
 					if(obj[i].name.indexOf("_subFunctions") != -1)
 						subFunctions[j++] = obj[i].value;
 			}
	}
	return subFunctions;
}

function operateTopWhenClickSub(thisCheckBox){
	var topName = getTopFunctionBySubFunctionName(thisCheckBox.name);
	if(thisCheckBox.checked)
		document.getElementsByName(topName)[0].checked = true;
	else{
		var subFunctions = document.getElementsByName(thisCheckBox.name);
		for(var i = 0 ; i<subFunctions.length; i++){
			if(subFunctions[i].checked == true)
				return;
		}
		document.getElementsByName(topName)[0].checked = false;
	}
}

function operateSubWhenClickTop(thisCheckBox){
	var name = thisCheckBox.name;
	var subFunctions = new Array();
	subFunctions = getSubFunctionsByTopFunctionName(name);

	for(var i = 0 ; i <subFunctions.length; i++){
		if(thisCheckBox.checked)
			subFunctions[i].checked = true;
		else
			subFunctions[i].checked = false;
	}
	var selectedBoxs = getAllSelectedSubFunctions();
	document.getElementById("form:hidden_functions").value= selectedBoxs;
}

function getTopFunctionBySubFunctionName(subFunctionName){
	var index = subFunctionName.indexOf("_subFunctions");
	var topFunctionName = subFunctionName.substring(0,index);
	return topFunctionName;
}

function getSubFunctionsByTopFunctionName(topFunctionName){
	var subFunctionName = topFunctionName+"_subFunctions";
	var subFunctions = document.getElementsByName(subFunctionName);
	return subFunctions;
}

function getFunctionArrayFromString(fString){
	var reArray = new Array();
	var i=0;
	while(fString.indexOf(",") != -1){
		var pos = fString.indexOf(",");
		reArray[i++] = fString.substring(0,pos);
		fString=fString.substring(pos+1);
	}
	reArray[i] = fString;
	return reArray;
}

function initRelatedCheckBoxState(){
	var selectedString = document.getElementById("form:hidden_functions").value;
	var selectedArray = getFunctionArrayFromString(selectedString);

	var subFunctions = new Array();
	var obj=document.getElementsByTagName("input");
	for(i=0, j=0;i < obj.length;i++)
	{
   		if(obj[i].type=="checkbox")
 			{
 					if(obj[i].name.indexOf("_subFunctions") != -1)
 						subFunctions[j++] = obj[i];
 			}
	}

	for(var i=0; i<subFunctions.length; i++){
		var subFunction = subFunctions[i];
		var topFunctionName = getTopFunctionBySubFunctionName(subFunction.name);
		for(var j=0; j<selectedArray.length; j++){
			var selectedFunction = selectedArray[j];
			if(subFunction.value == selectedFunction){
				subFunction.checked = true;
				document.getElementsByName(topFunctionName)[0].checked = true;
			}
		}
		if(subFunction.checked)
			document.getElementsByName(topFunctionName)[0].checked = true;
	}
}
function setSelectedFunctionWhenNoClick(){
	var selectedBoxs = getAllSelectedSubFunctions();
	document.getElementById("form:hidden_functions").value= selectedBoxs;
}

function getDayOfWeek(day){
	 var newDay=new Array();
	 newDay[0]="Sun";
	 newDay[1]="Mon";
	 newDay[2]="Tue";
	 newDay[3]="Wed";
	 newDay[4]="Thu";
	 newDay[5]="Fri";
	 newDay[6]="Sat";
	 return newDay[day];
	}
/**
 * Popup a new window at the top right screen.
 * <a href="cs2sample.htm#ui_popupPage" target="cs2sample">see sample</a>
 * @param {String} str_url The url of the new window.
 * @param {String} str_winsize The predefine size of the new window. <li>'S' for small;</li><li> 'M' for middle;</li><li> 'L' for large;</li><li> other for largest.</li>
 * @param {String} str_winname The window name of the new window.
 * @param {String} str_winparms The parametes to the popup window.
 *
 * @see #ui_popupExit_pw
 */
function ui_popupPage_pw(str_url,str_winsize,str_winname,str_winparms) {
	if(str_url.indexOf("?")<0){
	  str_url += "?" ;
	}
	try{
	  str_url+="&USER_TOKEN"+USER_TOKEN+"&ENTRY"+ENTRY+"&ENTRY_TYPE"+ENTRY_TYPE+"&PREFER_LANGUAGE"+PREFER_LANGUAGE+"&OPERATOR_USER_ID"+OPERATOR_USER_ID;
	}catch(err){}
	var screen_ht = screen.availHeight;
	var screen_wd = screen.availWidth;
	var screen_left = 0;
	var screen_top = 10;
	if ( ui_trim(str_winparms) == '' ) {
		str_winparms = "scrollbars=1,resizable=1,status=1,";
	}else{
		str_winparms += ",";
	}

	if (str_winsize == "S") scalar = 0.33;

	else if (str_winsize == "M") scalar = 0.50;
		else if (str_winsize == "L") scalar = 0.75;
			else scalar = 0.9;
	w_ht = Math.round(scalar * screen_ht);
	w_wd = Math.round(scalar * screen_wd);
	w_left = (screen_wd - w_wd) - 20;
	str_winparms += "left=" + w_left + ",top=" + screen_top + ",screenX=" + w_left + ",screenY=" + screen_top + ",";
	str_winparms += "height=" + w_ht + ",width=" + w_wd;
	if (window.noncsWin) {
		if (!noncsWin.closed) noncsWin.close();
	}
	noncsWin = window.open(str_url,str_winname,str_winparms);
	return;
}

function secBoard(n)
{
    for(i=0;i<document.getElementById("secTable").rows[0].cells.length;i++){
		var otherTabCenter = document.getElementById("tabCenter"+i);
		var otherTabCenterI = document.getElementById("tabCenterI"+i);
		var otherTabCenterE = document.getElementById("tabCenterE"+i);
		var otherTabLeft = document.getElementById("tabLeft"+i);
		var otherTabRight = document.getElementById("tabRight"+i);

		var targetTabCenter = document.getElementById("tabCenter"+n);
		var targetTabCenterI = document.getElementById("tabCenterI"+n);
		var targetTabCenterE = document.getElementById("tabCenterE"+n);
		var targetTabLeft = document.getElementById("tabLeft"+n);
		var targetTabRight = document.getElementById("tabRight"+n);

    	otherTabCenter.className="hiddenTabCenter";
		otherTabCenterI.className="hiddenTabCenter";
		otherTabCenterE.className="hiddenTabCenter";
		otherTabLeft.className="hiddenTabLeft";
		otherTabRight.className="hiddenTabRight";

  		targetTabCenter.className="topTabCenter";
		targetTabCenterI.className="topTabCenter";
		targetTabCenterE.className="topTabCenter";
		targetTabLeft.className="topTabLeft";
		targetTabRight.className="topTabRight";

		otherTabCenter.innerHTML = "<a href='#' class='tabLink' onClick='secBoard(" + i + ")'>" + otherTabCenter.innerHTML + "</a>";
		targetTabCenter.innerHTML = targetTabCenter.innerHTML;
	}

  	for(i=0;i<document.getElementById("mainTable").tBodies.length;i++){
   	 document.getElementById("mainTable").tBodies[i].style.display="none";
	 document.getElementById("mainTable").tBodies[n].style.display="";
 	}
}

function getUserTokenValue(){
	return ui_getObjById("USER_TOKEN").value;
}

function convertToJsfId(elementId){
	return "form:" + elementId;
}

function goToSiteRoot(){
window.location.replace('/');
}

String.prototype.decodeUnicode = function(){
 return this.replace(/&#(\d+);/g, function($1,$2){return String.fromCharCode($2)});
}

//end



