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
	<a href="${_ctxPath}/channel/to_add?pid=0" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建顶级栏目</a>
	<a href="javascript:createSubChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建子栏目</a>
	<a href="javascript:editChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑栏目</a>
	<a href="javascript:delChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除栏目</a>
</div>
<hr>
<div class="easyui-layout" style="width:700px;height:200px;margin:50px;">
	<div region="west" split="false" title="栏目" style="width:200px;">
		<ul class="easyui-tree" style="margin:10px">
			<li id="0"><span>栏目</span>
				<ul>
				<c:forEach items="${channels}" var="c">
					<li id="${c.id}"><span>${c.name}</span>
						<ul>
							<c:forEach items="${c.subChannel}" var="s"><li id="${s.id}"><span>${s.name }</span></li></c:forEach>
						</ul>
					</li>
				</c:forEach>
				</ul>
			</li>
		</ul>
	</div>
	<div id="content" region="center" title="编辑面板" style="padding:5px;">
		<table id="tt" class="easyui-datagrid" singleSelect=true style="width:100%;height:auto;">
		<thead>
			<tr>
				<th field="id" width="80">栏目ID</th>
				<th field="name" width="80">名称</th>
				<th field="path" width="80">路径</th>
				<th field="state" width="80">状态</th>
				<th field="sort" width="80">排序</th>
			</tr>
		</thead>                         
	</table>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$("#siteCombo").combobox({
		onChange:function(newVal, oldVal) {
			location.href="${_ctxPath}/channel/view?siteId="+newVal;
		}
	});
	$(".easyui-tree").tree({
		onClick:function(node) {
			showSubNodes(node.id);
		}
	});
})
function createSubChannel() {
	location.href="${_ctxPath}/channel/to_add?pid="+$(".easyui-tree").tree("getSelected").id;
}
function editChannel() {
	location.href="${_ctxPath}/channel/to_edit?id="+$("#tt").datagrid("getSelected").id;
}
function showSubNodes(id) {
	$.getJSON("${_ctxPath}/channel/children_list_ajax?pid="+id,{},function(ret) {
		if (ret.state=="0") {
			$("#tt").datagrid("loadData", {rows:ret.data});
		}
	});
}
function delChannel() {
	var selectedRow = $("#tt").datagrid("getSelected");
	if (selectedRow==null) {
		alert("当前没有选中的栏目");
		return;
	}
	var id = selectedRow.id;
	$.getJSON("${_ctxPath}/channel/has_children?id="+id,{},function(ret) {
		if (ret.state=="1") {
			alert(ret.msg);
		} else {
			if (confirm("确认删除栏目？")) {
				location.href="${_ctxPath}/channel/remove?id="+id;
			}
		}
	});
}
</script>
</body>
</html>