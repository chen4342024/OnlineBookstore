<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>淘书轩页面首部</title>
	<link href="<%=request.getContextPath()%>/css/basic.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <div id="header_nav_page">
  	<jsp:include page="header_nav.jsp"></jsp:include>
  </div>
  <div id="header">
     		<div id="nav1">
            </div>
			<div id="logo"><img src="<%=request.getContextPath()%>/images/logo.jpg"/></div>  
			<div id="nav2">
				<img src="<%=request.getContextPath()%>/images/nav2.jpg" alt="导航"/>
					<ul>
						<li><a href="<%=request.getContextPath() %>/index.jsp">首页</a></li>
						<li><a href="gainGoods_by_keyWord.do?otherOrderBy=&keyWord=文学&rowName=3">文学</a></li>
						<li><a href="gainGoods_by_keyWord.do?otherOrderBy=&keyWord=小说&rowName=3">小说</a></li>
						<li><a href="gainGoods_by_keyWord.do?otherOrderBy=&keyWord=励志与成功&rowName=3">励志与成功</a></li>
						<li><a href="gainGoods_by_keyWord.do?otherOrderBy=&keyWord=少儿&rowName=3">少儿</a></li>
					</ul>
			</div>
	 </div>
  </body>
</html>
