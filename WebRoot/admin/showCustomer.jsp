<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {font-size: 12px}
.STYLE3 {color: #707070; font-size: 12px; }
.STYLE5 {color: #0a6e0c; font-size: 12px; }
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
.STYLE7 {font-size: 12}
-->
</style>
<%
	Integer page01 = (Integer) request.getAttribute("page");
	Integer hasPages = (Integer) request.getAttribute("hasPages");
	Long hasCustomer = (Long) request.getAttribute("hasCustomer");
	Integer perFolioAmount = (Integer) request.getAttribute("perFolioAmount");
%>
<script language="javascript">
		var page = <%=page01%>;
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
	  		location.href = "showCustomer_by_page.do?page="+select.value ;
	  	}
	  	
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/admin/js/jquery-1.5.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/admin/js/showCustomer.js" charset="utf-8"></script>
</head>

<body>
<div id="breadNav">
	<jsp:include page="breadcrumbNavigation.jsp" />
</div>	
<input type="hidden" class="page" value="<%=page01 %>"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#c9c9c9">
      <tr>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><strong><span class="STYLE1">会员编号</span></strong></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><strong><span class="STYLE1">会员姓名</span></strong></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><strong><span class="STYLE1">注册时间时间</span></strong></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><strong><span class="STYLE1">会员状态</span></strong></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><strong><span class="STYLE1">账号余额</span></strong></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><strong><span class="STYLE1">操作</span></strong></div></td>
      </tr>
      <s:iterator value="record_l" status="st">
      <tr>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><s:property value="email"/></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><s:property value="name"/></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><s:property value="join_date.toLocaleString()"/></span></div></td> 
        <c:set var="status" scope="request" ><s:property value="status"/></c:set>
        	<c:choose>								
				<c:when test="${status == '0'}"><td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3">禁用</span></div></td></c:when>
				<c:when test="${status == '1'}"><td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3">正常</span></div></td></c:when>	
				<c:when test="${status == '2'}"><td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3">未激活</span></div></td></c:when>			
			</c:choose>       
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><s:property value="balance"/></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center" class="STYLE5"><a href="#" class="changeState" id="<s:property value="status"/>" name="<s:property value="email"/>">注销/恢复</a>| <a href="gainCustomer.do?customer.email=<s:property value="email"/>">详细</a>| <a href="showCustomer_by_page.do?status=2&type=2&customer.email=<s:property value="email"/>">购书记录</a>| <a href="showCustomer_by_page.do?status=3&type=2&customer.email=<s:property value="email"/>">评论记录</a></div></td>
      </tr>
      </s:iterator>
    </table></td>
  </tr>
  <tr>
    <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="25%" height="29" nowrap="nowrap"><table width="342" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="44%" class="STYLE1">当前页：<%=page01%>/<%=hasPages%>页 每页 
              <input name="textfield2" type="text" class="STYLE1" style="height:14px; width:25px;" value="<%=perFolioAmount %>" size="5" />            </td>
            <td width="14%" class="STYLE1"><img src="images/sz.gif" width="43" height="20" /></td>
            <td width="42%" class="STYLE1"><span class="STYLE7">数据总量 <%=hasCustomer%> </span></td>
          </tr>
        </table></td>
        <td width="75%" valign="top" class="STYLE1"><div align="right">
            <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="62" height="22" valign="middle"><div align="right"><a href="showCustomer_by_page.do?page=1" onclick="return justNextPage();"><img src="images/page_first_1.gif" width="48" height="20" /></a></div></td>
                <td width="50" height="22" valign="middle"><div align="right"><a href="showCustomer_by_page.do?page=<%=page01 - 1%>" onclick="return justNextPage();"><img src="images/page_back_1.gif" width="55" height="20" /></a></div></td>
                <td width="54" height="22" valign="middle"><div align="right"><a href="showCustomer_by_page.do?page=<%=page01 + 1%>" onclick="return justUpPage()"><img src="images/page_next.gif" width="58" height="20" /></a></div></td>
                <td width="49" height="22" valign="middle"><div align="right"><a href="showCustomer_by_page.do?page=<%=hasPages%>" onclick="return justUpPage()"><img src="images/page_last.gif" width="52" height="20" /></a></div></td>
                <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
                <td width="25" height="22" valign="middle"><span class="STYLE7">
                  <s:select list="page_l" name="page" cssClass="STYLE1" onchange="test(this);"/>
                </span></td>
                <td width="23" height="22" valign="middle">页</td>
                <td width="30" height="22" valign="middle"><img src="images/go.gif" width="26" height="20" /></td>
              </tr>
            </table>
        </div></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
