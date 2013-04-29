<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ognl.OgnlValueStack"%>

<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/css/tableCorner.css" rel="stylesheet" type="text/css" />
</head>

<body>
		<table width="100%" cellspacing="0" cellpadding="0" border="0"
						class="rotundWhiteBg">
				<tbody>
						<tr class="tableTop">
							<td colspan="2"></td>
						</tr>
						<tr class="left_header">
							<td colspan="2"><s:property value="#request.parentCategory.catagory_name"/></td>
						</tr>
						<tr class="tableCenter">
							<td></td><td>&nbsp  </td>
						</tr>
						<s:iterator value="#request.parentCategory.secondCatagoryList" status="st">
							<s:if test="true">
								<s:if test="#st.index < 5">
									<tr class="tableCenter">
											<td class="allow"></td><td><a href="#"><s:property value="catagory_name"/></a></td>
									</tr>
								</s:if>
							</s:if>
							<s:else>
								<tr class="tableCenter">
										<td class="allow"></td><td><a href="#"><s:property value="catagory_name"/></a></td>
								</tr>
							</s:else>
		        		</s:iterator>
						<tr class="tableCenter adapt" >
								<td colspan="2">更多类别 >>></td>
						</tr>
						<tr class="tableBottom">
							<td colspan="2"></td>
						</tr>
				</tbody>
		</table>
</body>
</html>
