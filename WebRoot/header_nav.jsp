<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>顶部快速导航条</title>
<link href="<%=request.getContextPath() %>/css/css.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/header_nav.js"></script>
</head>

<body >

<s:set name="account" value="#session.customer.email"></s:set>
<div id=page>
	<div class="chl-poster simple" id=header_nav>
		<div id=site-nav>
			<p class="log-info">
			 <s:if test="%{#account!=nul}">
			  hi，
			   <a href="#">${account}</a>
			   <a href="customerLogout.do">安全退出</a>
			  </s:if>
			   <s:else>
				亲，欢迎光临淘书轩！请
				<a href="<%=request.getContextPath() %>/customerLogin.jsp">登录</a>
				<a href="<%=request.getContextPath() %>/customerRegister.jsp">免费注册</a>
			   </s:else>
			 </p>  
			<ul class=quick-menu>
			  <li class=home><a href="<%=request.getContextPath() %>/index.jsp">淘书轩首页</a> </li>
			  <li><a  href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myOrder">我的订单</a></li>

			  <li class="mytaobao menu-item">
				  <div class=menu>
					  <a class=menu-hd href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myOrder" target=_top rel=nofollow>个人中心<b></b></a> 
					  <div class=menu-bd>
						  <div class=menu-bd-panel>
							  <div>
								  <p align="center"><a href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myOrder" rel=nofollow>我的订单</a></p>
								  <p align="center"><a href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myGoods" rel=nofollow>我的商品</a></p> 
								  <p align="center"><a href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myCollection" rel=nofollow>我的收藏</a></p>
								  <p align="center"><a href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myComment" rel=nofollow>我的评论</a></p>
							  </div>
						  </div>
						  <s class=r></s><s class=rt></s><s class=lt></s><s class=b></s><s class="b b2"></s><s class=rb></s><s class=lb></s>
					  </div>
				  </div>
			  </li>
			  <li class=cart><a href="getBookFromCart.do" rel=nofollow><S></s>购物车 </a></li>
			  <li class=favorite><a  href="<%=request.getContextPath() %>/customer/personalCenter/main.jsp?trigger=myCollection" rel=nofollow>收藏夹</a></li>
			 
			  <li class="services menu-item last">
				  <div class=menu>
					  <a class=menu-hd href="#" target=_top>网站导航<b></b></a> 
					  <div class=menu-bd style="WIDTH: 210px; HEIGHT: 262px; _width: 202px">
						  <div class=menu-bd-panel>
							  <dl>
								<dt><a href="#">购物</a>
								<dd>
										<a href="#">商城</a> 
										<a href="#">电器城</a> 
										<a href="#">嗨淘</a>
										<a href="#">全球购</a>
										<a href="#">跳蚤街</a> 
										<a href="#">礼物</a>
										<a href="#">促销</a>
										<a href="#">机票</a>
										<a href="#">彩票</a>
										<a href="#">创意</a> 
								</dd>
							</dl>
							  <dl>
								<dt><a href="#">门户</a> 
								<dd><a href="#">服饰</a> <a href="#">女人</a> <a href="#">美容</a> <a href="#">居家</a> <a href="#">男人</a> <a href="#">数码</a> <a href="#">亲子</a> <a href="#">时尚</a> <a href="#">试用</a> <a href="#">心得</a> <a href="#">帮派</a> <a href="#">画报</a> <a href="#">淘女郎</a> <a href="#">社区</a> <a href="#">宝贝传奇</a>
								</dd>
							</dl>
							  <dl>
								<dt><a href="#">淘江湖</a> &nbsp;<a href="#">手机淘宝</a> </dt></dl>
							  <dl>
								<dt><a href="#">帮助中心</a> 
								<dd><a href="#">交易安全</a> <a href="#">维权中心</a> </dd></dl>
							  <dl class=last>
								<dd><strong style="FONT-WEIGHT: bold"><a href="#">更多内容</a></strong></dd>
							  </dl>
						  </div>
						  <s class=r></s><s class=rt></s><s class=lt></s><s class=b style="WIDTH: 169px"></s><s class="b b2" style="WIDTH: 169px"></s><s class=rb></s><s class=lb></s>
					  </div>
				  </div>
			  </li>
		    </ul>
		</div>
	</div>
</div>
<script type=text/javascript>
	TB.Header.init();
</script>
</body>
</html>