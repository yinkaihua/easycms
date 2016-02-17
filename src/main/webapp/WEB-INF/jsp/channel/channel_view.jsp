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
<div style="margin:20px">
	站点选择：<select id="siteCombo" name="site" class="easyui-combobox" style="width:100px">
		<c:forEach items="${sites}" var="s">
		<option value="-1" <c:if test="${p.siteId==null}"> selected="selected"</c:if>>无</option>
		<option value="${s.id }" <c:if test="${p.siteId==s.id}"> selected="selected"</c:if>>${s.name}</option>
		</c:forEach>
	</select>
	<a id="addLvlOneBtn" href="${_ctxPath}/channel/to_add?pid=0" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建顶级栏目</a>
	<a id="addLvlTwoBtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建子栏目</a>
</div>
<table class="table table-bordered table-hover" style="width:800px; margin:20px">
	<thead>
		<tr class="success">
			<td>名称</td>
			<td>路径</td>
			<td>排序</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${channels}" var="s">
		<tr>
			<td>${s.name }</td>
			<td>${s.path }</td>
			<td>${s.sort }</td>
			<td><ec:dict catalog="state" code="${s.state }"/></td>
			<td><a href="${_ctxPath}/channel/to_edit?id=${s.id}" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a><a href="javascript:delDict('${s.id }');" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$(function() {
	$("#siteCombo").combobox({
		onChange:function(newVal, oldVal) {
			location.href="${_ctxPath}/channel/view?siteId="+newVal;
		}
	});
})
function removeSubMenu() {
	if (confirm("是否确认删除菜单？注意：子菜单也会删除")) {
		$("input[name='id']").val($("#selectedSubMenu").val());
		$("#delForm").submit();
	}
}
</script>
</body>
</html>