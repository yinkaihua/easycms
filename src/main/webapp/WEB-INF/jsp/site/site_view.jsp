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
<div style="margin:20px;">
	<a href="${_ctxPath}/site/to_add.htm" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建网站</a>
</div>
<table class="table table-bordered table-hover" style="width:800px; margin:20px">
	<thead>
		<tr class="success">
			<td>网站ID</td>
			<td>网站名称</td>
			<td>域名设置</td>
			<td>创建时间</td>
			<td>状态</td>
			<td>创建人</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${sites}" var="s">
		<tr>
			<td>${s.id }</td>
			<td>${s.name }</td>
			<td>${s.domain }</td>
			<td><fmt:formatDate value="${s.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td><ec:dict catalog="state" code="${s.state }"/></td>
			<td>${s.accountName }</td>
			<td><a href="${_ctxPath}/site/to_edit.htm?id=${s.id}" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a><a href="javascript:delSite('${s.id }');" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$(function() {
	
})
function delSite(id) {
	if (confirm("确认删除站点？")) {
		location.href="${_ctxPath}/site/remove.htm?id="+id;
	}
}
</script>
</body>
</html>