<%@page import="com.coding17.easycms.web.util.WebConst"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>easycms</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="${_staticRes}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<%@ include file="/WEB-INF/jsp/include/common_css.jsp" %>
	<%@ include file="/WEB-INF/jsp/include/common_js.jsp" %>
</head>
<body>
<%-- <div style="margin:20px;">
	<a href="${_ctxPath}/content/to_edit.htm" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑栏目</a>
	<a href="${_ctxPath}/content/to_add" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除栏目</a>
</div> --%>
<table class="table table-bordered table-hover" style="width:95%;margin:20px">
	<thead>
		<tr class="success">
			<td width="20px"></td>
			<td width="100px">栏目ID</td>
			<td>名称</td>
			<td width="150px">路径</td>
			<td width="200px">状态</td>
			<td width="150px">排序</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${channels}" var="s">
		<tr>
			<td><input type="radio" value="${s.id}" name="channelRadio"></td>
			<td>${s.id }</td>
			<td>${s.name }</td>
			<td>${s.path }</td>
			<td><ec:dict catalog="state" code="${s.state }"/></td>
			<td>${s.sort }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>