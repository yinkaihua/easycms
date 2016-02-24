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
<%@ include file="/WEB-INF/jsp/site/site_selected.jsp" %>
<div style="margin:20px">
	<a href="${_ctxPath}/content/to_add" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新文章</a>
	<a href="javascript:editChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑栏目</a>
	<a href="javascript:delChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除栏目</a>
</div>
<hr>
<div class="easyui-layout" style="width:700px;height:200px;margin:20px;">
	<div region="west" split="false" title="栏目" style="width:200px;">
		<ul class="easyui-tree" style="margin:10px"></ul>
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
	$(".easyui-tree").tree({
		data:${treejson},
		onClick:function(node) {
			showContents(node);
		}
	});
})
function siteChangeEvent(newVal, oldVal) {
	location.href="${_ctxPath}/content/view?wc_p_context_sid="+newVal;
}
function createSubChannel() {
	location.href="${_ctxPath}/channel/to_add?pid="+$(".easyui-tree").tree("getSelected").id;
}
function editChannel() {
	location.href="${_ctxPath}/channel/to_edit?id="+$("#tt").datagrid("getSelected").id;
}
function showContents(node) {
	var data = {channel:{}};
	if (node.attributes.level==1) {
		data["channel.pid"]=node.id;
	} else if (node.attributes.level==2) {
		data["channel.id"]=node.id;
	}
	$.getJSON("${_ctxPath}/content/list_ajax",data,function(ret) {
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