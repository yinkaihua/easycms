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
<div style="margin:20px;">
	<a href="${_ctxPath}/content/to_add.htm?cid=${cid}" class="easyui-linkbutton" data-options="iconCls:'icon-add'">发布</a>
	<a href="${_ctxPath}/content/to_add.htm" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
	<a href="${_ctxPath}/content/to_add.htm?cid=${cid}" class="easyui-linkbutton" data-options="iconCls:'icon-add'">页面静态化</a>
</div>
<table class="table table-bordered table-hover" style="width:95%;margin:20px">
	<thead>
		<tr class="success">
			<td width="20px"><input type="checkbox" id="selectAll"></td>
			<td width="100px">文章ID</td>
			<td>标题</td>
			<td width="150px">栏目</td>
			<td width="200px">创建时间</td>
			<td width="150px">发布状态</td>
			<td width="100px">状态</td>
			<td width="250px">操作</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${contents}" var="s">
		<tr>
			<td><input type="checkbox" value="${s.id}" name="contentCheckbox"></td>
			<td>${s.id }</td>
			<td>${s.title }</td>
			<td>${s.channel.name }</td>
			<td><fmt:formatDate value="${s.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td><ec:dict catalog="pubstate" code="${s.pubState }"/></td>
			<td><ec:dict catalog="state" code="${s.state }"/></td>
			<td>
				<a href="${_ctxPath}/content/to_edit.htm?id=${s.id}" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
				<a href="javascript:statiz(${s.id})" class="easyui-linkbutton" data-options="iconCls:'icon-add'">静态化</a>
				<a href="javascript:delContent(${s.id})" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$(function() {
	/* $("#selectAll").click(function() {
		if ($(this).is(":checked")) {
			$("input[name='contentCheckbox']").each(function() {
				$(this).attr("checked", "checked");
			});
		} else {
			$("input[name='contentCheckbox']").each(function() {
				$(this).attr("checked", false);
			});
		}
	}); */
})
function delContent(id) {
	if (confirm("确认删除文章？")) {
		location.href="${_ctxPath}/content/remove.htm?cid=${cid}&id="+id;
	}
}
function statiz(id) {
	$.getJSON("${_ctxPath}/gen/statiz.shtm", {ids:id}, function(ret) {
		alert(ret.state);
		location.reload();
	});
}
</script>
</body>
</html>