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
	<a href="${_ctxPath}/dict/to_add.htm" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建字典条目</a>
	<a href="javascript:refresh()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">刷新字典缓存</a>
</div>
<table class="table table-bordered table-hover" style="width:800px; margin:20px">
	<thead>
		<tr class="success">
			<td>字典分类</td>
			<td>键</td>
			<td>值</td>
			<td>描述</td>
			<td>排序</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${dicts}" var="s">
		<tr>
			<td>${s.catalogCode }</td>
			<td>${s.key }</td>
			<td>${s.value }</td>
			<td>${s.desc }</td>
			<td>${s.sort }</td>
			<td><a href="${_ctxPath}/dict/to_edit.htm?id=${s.id}" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a><a href="javascript:delDict('${s.id }');" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$(function() {
	
})
function delDict(id) {
	if (confirm("确认删除字典条目？")) {
		location.href="${_ctxPath}/dict/remove.htm?id="+id;
	}
}
function refresh() {
	$.getJSON("${_ctxPath}/dict/refresh.htm", function(ret) {
		alert("刷新成功");
	});
}
</script>
</body>
</html>