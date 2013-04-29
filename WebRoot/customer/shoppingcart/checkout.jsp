<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="<%=request.getContextPath()%>/css/taoshuxuan.css" rel="stylesheet" type="text/css" />
		<link type="text/css" rel="stylesheet" href="css/order_form.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/customer/shoppingcart/js/jquery-1.5.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/customer/shoppingcart/js/jquery.form.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/validation.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/customer/shoppingcart/js/checkout.js"></script>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/customer/shoppingcart/css/unite_header.css" />
	</head>
	<body>
		<div id="header_page">
           <jsp:include page="../../header.jsp" />
    	</div>
		<div id="div_ajax_canvas" style="display: block;">
			<div class="shoppingcart_wrapper">
				<div class="shoppingcart_nav shoppingcart_nav2">
					<h1>
						<a href="getBookFromCart.do">我的购物车</a>
					</h1>
				</div>
				<div id="div_checkout_tips" class="objhide"></div>
				<div class="shoppingcart_footer_experience">
					请确认以下信息，然后提交订单
				</div>
				
				<div class="clearing_border">
					<div id="div_consignee">
						<s:action name="getShippingAddressByEmail"></s:action>
						<div style="display:none">
							<input id="i1" value="<s:property value="#request.shippingAddress.shipping_province"/>"/>
							<input id="i2" value="<s:property value="#request.shippingAddress.shipping_city"/>"/>
							<input id="i3" value="<s:property value="#request.shippingAddress.shipping_county"/>"/>
						</div>
						<div id="consignee_tips" class="consignee">
							<h3>
								收货人信息
								<span class="look"> <a id="btn_consignee_close" name="btn_consignee_save"
									class="btn_close" href="#" >[关闭]</a>
								</span>
							</h3>
							<div id="consignee_edit_info" class="info open" style="display: block">
								<s:iterator value="#session.customer.addresses" status="st">
											<p class="clearing_address_nav">
											<s:if test="#st.index==0">
												<input type="radio" checked="checked" class="customer_address"  value="<s:property value="shipping_address_id"/>" name="radio_shipping_address_id" />
											</s:if>
											<s:else>
												<input type="radio" class="customer_address"  value="<s:property value="shipping_address_id"/>" name="radio_shipping_address_id" />
											</s:else>
											<span class="existAddress">
												<s:property value="consignee"/>,&nbsp;
												<s:property value="shipping_province"/>,&nbsp;
												<s:property value="shipping_city"/>,&nbsp;
												<s:property value="shipping_county"/>,&nbsp;
												<s:property value="street_address"/>,&nbsp;
												<s:property value="postcode"/>,&nbsp;
												<s:property value="mobile_phone"/>,&nbsp;
												<s:property value="fixed_phone"/>&nbsp;
											</span>
											</p>
								</s:iterator>
								<input type="radio" id="newCustomerAddress" class="customer_address" value="0" name="radio_shipping_address_id" />使用新地址
								<div id="div_consignee_edit_info_display" style="display:none">
									<form action="updateShippingAddress.do" id="form_consignee">
										<div class="m_list">
											<span class="text">收&nbsp;货&nbsp;人：</span><span class="requireSpan">*</span>
											<input id="txt_ship_name" class="required1" type="text" name="shippingAddress.consignee"
												value="<s:property value="#request.shippingAddress.consignee"/>" maxlength="40" />
											
										</div>
										<div id="div_consignee_addr" class="m_list">
											<span class="text">地&nbsp;&nbsp;&nbsp;&nbsp;区：<span class="requireSpan">*</span></span>
											<select id="sel_country" class="select_w" name="shippingAddress.shipping_country">
												<option value="9000">
													中国
												</option>
											</select>
											<span id="spn_province_city" style="display: block;">
												<select id="s_province"  class="select_w" name="shippingAddress.shipping_province" ></select>
												<select id="s_city"  class="select_w" name="shippingAddress.shipping_city"></select>
												<select id="s_county"  class="select_w" name="shippingAddress.shipping_county"> </select> </span> 
													<script	type="text/javascript" src="<%=request.getContextPath()%>/js/area.js"></script> 
													<script	type="text/javascript">_init_area();</script>
										</div>
										<div class="m_list">
											<span class="text"> 街道地址： <span
												id="div_country_province_city" class="">
													 </span></span><span class="requireSpan">*</span>
											<input id="txt_ship_address" class="textbox_x" type="text" name="shippingAddress.street_address"
												onblur="" onfocus="" value="<s:property value="#request.shippingAddress.street_address"/>" maxlength="100" />
											<span id="ship_address_valid_msg" class="news_red2"
												style="visibility: hidden"></span>
										</div>
										<div class="m_list">
											<span class="text">邮&nbsp;&nbsp;&nbsp;&nbsp;编：<span class="requireSpan">*</span></span>
											<input id="txt_ship_zip" class="textbox_4" type="text" name="shippingAddress.postcode"
												value="<s:property value="#request.shippingAddress.postcode"/>" maxlength="20" />
											<span id="ship_zip_valid_msg" class="news_red2"
												style="visibility: hidden"> </span>
										</div>
										<div class="m_list">
											<span class="text">手&nbsp;&nbsp;&nbsp;&nbsp;机：<span class="requireSpan">*</span></span>
											<input id="txt_ship_mb" class="textbox_4" type="text" name="shippingAddress.mobile_phone"
												maxlength="20" value="<s:property value="#request.shippingAddress.mobile_phone"/>" />
											<span class="text"> <span class="hint">或者</span> 固定电话：
											</span>
											<input id="txt_ship_tel" class="textbox_4" type="text" name="shippingAddress.fixed_phone"
												maxlength="20" value="<s:property value="#request.shippingAddress.fixed_phone"/>" />
											<span id="ship_mb_valid_msg" class="news_red2"
												style="visibility: hidden"> </span>
										</div>
									</form>
								</div>
								<div class="button_ts">
									<input type="hidden" value="#request.shippingAddress.shipping_address_id"/>
									<input name="btn_consignee_save" class="save_button" 
									  	   type="button" value="确认收货人信息" />
									<span id="span_consignee_save_tips" class="objhide"></span>
									<div class="clear"></div>
								</div>
							</div>
								<div id="refer_m" class="refer_m" style="display:none">
										<ul>
											<li >
												收货人信息 ： 
												<span id="li_refer_m">
												</span>
										   </li>
									 </ul>
								</div>
						</div>
					</div>
					<div id="div_shipment">
						<div id="shipment_tips" class="consignee">
							<h3 class="change_h3_h">
								<span id="ship_type_tips">送货方式</span>
							</h3>
							<div id="rd_shipinfo">
								<div class="delivery_title">
									<ul>
										<li class="height2">
											<span class="delivery_text_l1">送货方式</span>
											<span class="delivery_text_l2">运费</span>
										</li>
									</ul>
								</div>
								<div class="delivery_text">
									<ul>
										<li>
											<span class="delivery_text_l2">普通快递送货上门 （支持货到付款）</span>
											<span class="delivery_text_c3"> 5元（购物满29元免运费）</span>
										</li>
									</ul>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div id="div_payment">
						<div id="payment_tips" class="consignee">
							<h3>
								付款方式&#12288;
								<span class="add_gray2"> <a id="btn_payment_close"
									class="btn_close" href="#" onclick="return msgToggle(this)">[关闭]</a>
								</span>
								<span id="payment_valid_msg" class="news_red"></span>
							</h3>
							<div id="rd_pay_id" class='info open'>
								<div class="clearing_payment">
								<s:action name="findAllPaymentMethod"></s:action>
								<br />
									<form>
										<s:iterator value="#request.paymentMethod_l" status="st">
											<p class="clearing_payment_nav">
											<s:if test="#st.index==0">
												<input type="radio" checked="checked" class="payment_radio"  value="<s:property value="payment_method_id"/>" name="payment_method" />
											</s:if>
											<s:else>
												<input type="radio" class="payment_radio"  value="<s:property value="payment_method_id"/>" name="payment_method" />
											</s:else>
												<b class="v"><s:property value="name"/></b>
											</p>
										</s:iterator>
									</form>
								</div>
								<div class="button_ts" style="display:block">
									<input id="btn_payment_save" class="put_in" type="button"
										value="确认付款方式" name="" onclick="return msgToggle(this)"/>
									<span id="span_payment_save_tips" class="news_red2"></span>

									<div class="clear"></div>
								</div>
							</div>

							<div id="refer_m3" class="refer_m" style="display: none">
								<ul>
									<li>
										<span id="payment_result"></span>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="div_cartItems">
						<div class="refer_m refer_m2">
							<h4>
								商品清单
							</h4>
							<div class="merch_detail">
								<span class="experience"> [<a name="gobackshoppingcart"
									href="">返回修改购物车</a>] </span>
								<div id="div_order_all" class="">
									<div class="business_box">
										<div class="business_box_border">
											<div>
											<s:action name="getBookFromCart"></s:action>
												<div id="rpt_cart_items">
													<ul class="shoppingcart_subject">
														<li class="row1">
															商品名称
														</li>
														<li class="row2">
															所在仓库
														</li>
														<li class="row3">
															价格
														</li>
														<li class="row4">
															<span title="优惠">优惠</span>
														</li>
														<li class="row5">
															数量
														</li>
														<li class="row6">
															小计
														</li>
													</ul>
													<div class="shoppingcart_general">
													 <s:iterator value="#request.bookItems">
														<ul id="ul_22731771" name="ul_22731771"
															class="shoppingcart_list">
														
															<li  class="row1">
																<s:property value="book.name"/>
															</li>
															<li class="row7">
																<span></span>
															</li>
															<li class="row2">
																#######
															</li>
															<li class="row3">
																<s:property value="book.price"/>
															</li>
															<li class="row4"><s:property value="book.discount"/></li>
															<li class="row5">
																<s:property value="amount"/>
															</li>
															<li class="row6">
																<s:property value="getTotal()"/>
															</li>
														</ul>
													</s:iterator>
														<div class="clear" />
															<span class="price_charge_border"></span>
														</div>
													</div>
													<div class="price_charge">
														<p class="p_charge1">
															商品金额总计：
															<span>￥<span id="sp_bargin_total">${total_account-5} </span> </span>
														</p>
														<p class="p_charge1">
															运费：
															<span id="sp_shipping_fee">￥5.00</span>
														</p>
														<div id="rpt_collection_privilege_deduct"></div>
														<p class="change_total">
															您需支付：
															<span class="c_red"> ￥<span id="sp_payable">${total_account}</span>
															</span>
														</p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<form id="form_order" method="post" action="commitOrder.do">
										<div id="parm" style="display:none">
											<input id="shipping_address_id" name="order.shippingAddress.shipping_address_id"/>
											<input id="consignee" name="order.shippingAddress.consignee"/>
											<input id="shipping_province" name="order.shippingAddress.shipping_province"/>
											<input id="shipping_city" name="order.shippingAddress.shipping_city"/>
											<input id="shipping_county" name="order.shippingAddress.shipping_county"/>
											<input id="street_address" name="order.shippingAddress.street_address"/>
											<input id="postcode" name="order.shippingAddress.postcode"/>
											<input id="mobile_phone" name="order.shippingAddress.mobile_phone"/>
											<input id="fixed_phone" name="order.shippingAddress.fixed_phone"/>
											<input id="parmPaymentMethod" name="order.paymentMethod.payment_method_id" />
											<input id="amount" name="order.amount" value="${total_account}" />
											<input id="submissionToken" name="submissionToken" value="${session.submissionToken}"/> 
											<input id="submitOrderButton" name="submit" type="submit" value="确认"/>
										</div>
										<div class="order_tijiao">
											<a id="submitOrder" name="submit" href="">提交订单</a>
											<br />
											<span id="submitOrderErrorMsgHolder" class="errorIconAndMsg" name="promptHolderDiv" style="display:none"></span>
										</div>
									</form>
									<div class="clear"></div>
								</div>
								<div id="order_submit_error_tips" class="order_tijiao_hint"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
	<div id="footer_page">
        	<jsp:include page="../../footer.jsp" />
    </div>
			<s:debug></s:debug>
	</body>
</html>