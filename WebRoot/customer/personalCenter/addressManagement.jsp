<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<link href="css/taoshuxuan.css" rel="stylesheet" type="text/css" />
<link href="css/addressManagement.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/taoshuxuan.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/customer/shoppingcart/js/jquery-1.5.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validation.js" ></script>
<script type="text/javascript" src="js/shipping_manage.js"></script>
</head>

<body>
<div class="content">
 <div id="breadNav">
	<jsp:include page="breadcrumbNavigation.jsp" />
</div>
  <div class="title">
    <h3> 我的收货地址簿</h3>
  </div>
  <div id="dizhi_list">
    <table class="addr_list">
      <tbody>
        <tr>
          <th class="consignee"> 收货人 </th>
          <th class="addr_detail"> 详细地址 </th>
          <th class="phone"> 电话/手机 </th>
          <th class="operate"> 操作 </th>
        </tr>
        <s:iterator value="#session.customer.addresses" status="st">
	        <tr>
	          <td class=consignee title="consignee"><s:property value="consignee"/></td>
	          <td class="address"> 
	          	<s:property value="shipping_province"/> -
				<s:property value="shipping_city"/>-
				<s:property value="shipping_county"/>-
				<s:property value="street_address"/>,&nbsp;
				<s:property value="postcode"/>
			 </td>
	          <td >
	          	<s:if test="fixed_phone != ''"><s:property value="fixed_phone"/>&nbsp;/&nbsp;</s:if><s:property value="mobile_phone"/>
	          </td>
	          <td><a href="#" class="edit-info"> 编辑</a> <a href="#" id="delete"> 删除</a></td>
	        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
  <div class="title">
    <h3> 如需添加收货地址请输入</h3>
  </div>
  <fieldset class="edit-addr">
    <div id="editAddress_div">
      <div class="new_dizhi">
        <table width="100%" cellspacing="3" cellpadding="10" border="0" class="addNewAddr">
          <tbody>
            <tr>
              <td class="lable"><span style="color:red">*</span> 收 货 人：</td>
              <td ><input id="txt_ship_name" type="text" name="shippingAddress.consignee"	maxlength="40" /></td>
            </tr>
            <tr>
              <td class="lable"><span style="color:red">*</span> 地&#12288;&#12288;区：</td>
              <td>
              	<select id="s_province"  class="select_w" name="shippingAddress.shipping_province" ></select>
				<select id="s_city"  class="select_w" name="shippingAddress.shipping_city"></select>
				<select id="s_county"  class="select_w" name="shippingAddress.shipping_county"> </select>
                <script type="text/javascript" src="<%=request.getContextPath()%>/js/area.js" ></script> 
                <script type="text/javascript">_init_area();</script> 
               </td>
            </tr>
            <tr>
              <td class="lable"><span style="color:red">*</span> 详细地址：</td>
              <td colspan="3"><input id="txt_ship_address" class="textbox_x" type="text" name="shippingAddress.street_address" maxlength="100" /></td>
            </tr>
            <tr>
              <td class="lable"><span style="color:red">*</span> 邮政编码：</td>
              <td colspan="3">
				<input id="txt_ship_zip" class="textbox_4" type="text" name="shippingAddress.postcode" maxlength="20" />
				</td>
            </tr>
            <tr>
              <td class="lable">&#12288;手&#12288;&#12288;机：</td>
              <td ><input id="txt_ship_mb" class="textbox_4" type="text" name="shippingAddress.mobile_phone" maxlength="20" /></td>
            </tr>
            <tr>
              <td class="lable">&#12288;座    机：</td>
              <td ><input id="txt_ship_tel" class="textbox_4" type="text" name="shippingAddress.fixed_phone" maxlength="20" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <a style="margin-left:77px;" href="###"> <img alt="添加这个地址" id="saveButton" src="http://i.vanclimg.com/my/2012/deliveryaddress/bt6.jpg"/> </a>
  </fieldset>
</div>
</body>
</html>
