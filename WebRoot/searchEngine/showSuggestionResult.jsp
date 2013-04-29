<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>网上购书中心首页</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=request.getContextPath()%>/css/basic.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/searchEngine/js/showResult.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.pack.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/shoppingcart_collection.js"></script>
  	<%
	Integer page01 = (Integer) request.getAttribute("page");
	Integer hasPages = (Integer) request.getAttribute("hasPages");
	Long hasCustomer = (Long) request.getAttribute("hasCustomer");
	Integer perFolioAmount = (Integer) request.getAttribute("perFolioAmount");
%>
	<script language="javascript">
		var page = <%=page01 %>;
		var hasPages = <%=hasPages%>;
		function justUpPage(){
			if(page == hasPages){
				 alert("已经是最后一页了！");
				 return false;
			}	 
		}
		
		function justNextPage(){
			if(page == 0 || page == 1){
				 alert("已经是第一页了！");
				 return false;
			}	 
		}
		function test(select){
	  		top.location.href = "showAll.do?page="+select.value ;
	  	}
</script>
<script>
		$(document).ready(function () {	
		//添加购物车的操作
			$('a.buy').click(function(){
				shoppingCart.addBookToShoppingCart(this);
				return false;
			});
			$('a.collect').click(function(){
				customerCollect.addToCollection(this);
				return false;
			});
		});
</script>
    </head>
    <body>
    	<div id="header_page">
           <jsp:include page="../header.jsp" />
        </div>
        <div id="main">
        	<div id="sidebar">
                
                	<s:if test="rowName==3">
                		<s:action name="findCatagoryIncludeChildByName">
                			<s:param name="catagory.catagory_name" value="keyword_show"></s:param>
                		</s:action>
                		<s:iterator value="#request.firstCatagoryList" status="st" var="parentCategory">
                		<div class="bookCategoryList">
							<jsp:include page="../customer/bookCategoryList.jsp" flush="true">
								    <jsp:param name="parentCategory" value="${parentCategory}"/>
								    <jsp:param name="showAll" value="true"/>
							</jsp:include>
						</div>
						</s:iterator>
                	</s:if>
				
                <div id="sidebar4"><img src="<%=request.getContextPath() %>/images/sidebar4.jpg" alt="导航"/></div>
                <div id="sidebar5"><img src="<%=request.getContextPath() %>/images/sidebar5.jpg" alt="导航"/></div>
                <div id="sidebar6"><img src="<%=request.getContextPath() %>/images/sidebar6.jpg" alt="导航"/></div>
                <div id="sidebar7"><img src="<%=request.getContextPath() %>/images/sidebar7.jpg" alt="导航"/></div>
                <div id="sidebar8"><img src="<%=request.getContextPath() %>/images/sidebar8.jpg" alt="导航"/></div>
            </div>
            <div id="main1">
            	<div id="main11">
                	
                    <div id="search">
                    	<jsp:include page="shou.jsp" />
                    </div>    
                <div id="search_info">
                	<table id="table2">
										<tr>
											<td width="5%"><%=page01%>/<%=hasPages%></td>
											<td width="10%">
												<a href="showAll.do?page=1"
													onclick="return justNextPage();">第一页</a>
											</td>
											<td width="10%">
												<a href="showAll.do?page=<%=page01 - 1%>"
													onclick="return justNextPage();">上一页</a>

											</td>
											<td width="10%">
												<a href="showAll.do?page=<%=page01 + 1%>"
													onclick="return justUpPage()">下一页</a>
											</td>
											<td width="10%">
												<a href="showAll.do?page=<%=hasPages%>"
													onclick="return justUpPage()">最后一页</a>
											</td>
											<td width="10%">

												跳转
												<s:select list="page_l" name="page"  id="s_page" onchange="test(this);" />
											</td>
											<td width="10%">
												搜索<font class="keyword_font">${keyword_show}</font>共有<font class="keyword_font">${has}</font>条记录
											</td>
										</tr>
									</table>
                </div>
              
               <div class="result_list">
               		<ul>
               		<s:iterator value="goods_l" status="st">
               			<li class="book_info">
               				<input type="hidden" value="${book_id}"/>
               				<div id="book_img" class="listitem pic"><a href="showbook.do?book.book_id=${book_id}" target="_blank"><img src="<%=request.getContextPath() %>/BookImages/cover/${book_image}"/></a></div>
               				<div class="listitem book_detail">
               					<ul class="tip_list">
               						<li class="main_title">
               							<a href="showbook.do?book.book_id=${book_id}" target="_blank" title="${name}">
											${name}       								
               							</a>
               						</li>
               						<li class="sub_title">
               							<p></p>
               				    	</li>
               				    	<li class="star_level">
               				    		(
               				    		<a href="">
               				    			<img src="<%=request.getContextPath() %>/searchEngine/image/star_all.png"/>
               				    			<img src="<%=request.getContextPath() %>/searchEngine/image/star_all.png"/>
               				    			<img src="<%=request.getContextPath() %>/searchEngine/image/star_all.png"/>
               				    			<img src="<%=request.getContextPath() %>/searchEngine/image/star_all.png"/>
               				    			<img src="<%=request.getContextPath() %>/searchEngine/image/star_all.png"/>
               				    		</a>
               				    		<span>
               				    			<a href="">233</a>条评论)
               				    		</span>
               				    	</li>
               				    	<li class="publisher_info">
               				    		<a href="gainGoods_by_keyWord.do?otherOrderBy=&keyWord=${author}&rowName=2" name="author">${author}</a>
               				    		&#12288;著/<fmt:formatDate value="${publish_date}" type="date"/>/${publish_company} 
               				    	</li>
               				    	<li class="book_content">
               				    		<p>
               				    			${content_summary}
               				    		</p>
               				    	</li>
               				    	<li class="clearfix">
               				    		<div class="panel operate clearfix">
               				    			<a href="" class="buy" name="${book_id}"><img src="<%=request.getContextPath() %>/searchEngine/image/btn_buy.gif"/></a>
               				    			<a href="" class="collect" name="${book_id}"><img src="<%=request.getContextPath() %>/searchEngine/image/btn_keep.gif"/></a>
               				    		</div>
               				    		<div class="panel price">
               				    			<span class="price_d">
               				    				¥<em><fmt:formatNumber value="${price*discount}" pattern=".00"/></em>
               				    			</span>
               				    			<span class="price_m">¥${price}</span>
               				    			<span class="discount">折扣：<fmt:formatNumber value="${discount*100}" pattern="0"/>折</span>
               				    		</div>
               				    		
               				    	</li>
               					</ul>
               				</div>
               			</li>
               		</s:iterator>
               		</ul>
               </div>
              
            </div>
        </div>
        </div>
         <div id="footer_page">
        	<jsp:include page="../footer.jsp" />
        </div>
    </body>
</html>