<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>easycms</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<%@ include file="/WEB-INF/jsp/include/common_css.jsp" %>
	<%@ include file="/WEB-INF/jsp/include/common_js.jsp" %>
</head>
<body>
<div style="padding:5px 0;">
	<a id="addLvlOneBtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加一级菜单</a>
	<a id="addLvlTwoBtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加子菜单</a>
	<a id="delBtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除菜单</a>
</div>
<div id="acc" class="easyui-accordion" style="width:100%;">
<c:forEach items="${menus}" var="item" varStatus="stat">
<div data-options="title:'${item.text}',collapsed:false" style="padding:10px;" id="${item.id}" text="${item.text}">
	<ul id="tree${item.id}" class="easyui-tree" data-options="animate: true,onContextMenu: function(e,node){
					e.preventDefault();
					$(this).tree('select',node.target);
					$('#selectedSubMenu').val(node.id);
					$('#mm${stat.index}').menu('show',{
						left: e.pageX,
						top: e.pageY
					});}">
		<c:forEach items="${item.subMenus}" var="menu">
			<li id="${menu.id}">${menu.text}</li>
		</c:forEach>
	</ul>
	<div id="mm${stat.index}" class="easyui-menu" style="width:120px;">
		<div onclick="removeSubMenu()" data-options="iconCls:'icon-remove'">Remove</div>
	</div>
</div>
</c:forEach>
</div>
<div id="addMenu" class="easyui-dialog" title="添加一级菜单" style="top:100px;left:100px;width:200px;padding:10px"
	data-options="
		iconCls: 'icon-save',
		modal:true,
		closed:true,
		buttons: [{
			text:'确定',
			iconCls:'icon-ok',
			handler:function(){
				$('#addLvlOneForm').form('submit',{
					url:'${_ctxPath}/menu/add',
					method:'post',
					onSubmit:function(none) {
						$(this).form('validate');
					},
					success:function() {
						location.href='${_ctxPath}/menu/view';
					}
				});
			}
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				$('#addMenu').dialog('close');
			}
		}]
	">
	<form id="addLvlOneForm">
	<input name="action" style="display:none;" value="0">
	<input name="pid" style="display:none;" value="0">
	<input name="level" style="display:none;" value="1">
	<div style="margin-bottom:20px">
		<div>名称</div>
		<input name="text" class="easyui-textbox" style="width:100%;height:25px" data-options="required:true">
		<div>排序</div>
		<input name="sort" class="easyui-textbox" style="width:100%;height:25px" data-options="required:true">
		<div>是否启用</div>
		<select name="state" class="easyui-combobox" style="width:100%">
			<option value="1">是</option>
			<option value="9">否</option>
		</select>
	</div>
	</form>
	<form id="delForm" method="post" action="${_ctxPath}/menu/remove"><input type="hidden" name="id"></form>
</div>
<div id="addSubMenu" class="easyui-dialog" title="添加子菜单" style="top:100px;left:100px;width:200px;padding:10px"
	data-options="
		iconCls: 'icon-save',
		modal:true,
		closed:true,
		buttons: [{
			text:'确定',
			iconCls:'icon-ok',
			handler:function(){
				$('#addLvlTwoForm').form('submit',{
					url:'${_ctxPath}/menu/add',
					method:'post',
					onSubmit:function(none) {
						$(this).form('validate');
					},
					success:function() {
						location.href='${_ctxPath}/menu/view';
					}
				});
			}
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				$('#addSubMenu').dialog('close');
			}
		}]
	">
	<form id="addLvlTwoForm">
	<input name="action" style="display:none;" value="0">
	<input name="pid" style="display:none;">
	<input name="level" style="display:none;" value="2">
	<div style="margin-bottom:20px">
		父菜单：<span id="superMenu"></span>
		<div>名称</div>
		<input name="text" class="easyui-textbox" style="width:100%;height:25px" data-options="required:true">
		<div>排序</div>
		<input name="sort" class="easyui-textbox" style="width:100%;height:25px" data-options="required:true">
		<div>动作</div>
		<input name="action" class="easyui-textbox" style="width:100%;height:25px" data-options="required:true">
		<div>是否启用</div>
		<select name="state" class="easyui-combobox" style="width:100%">
			<option value="1">是</option>
			<option value="9">否</option>
		</select>
	</div>
	</form>
	<form id="delForm" method="post" action="${_ctxPath}/menu/remove"><input type="hidden" name="id"></form>
</div>
<input type="hidden" id="selectedSubMenu">
<script type="text/javascript">
$(function() {
	$("#addLvlOneBtn").click(function() {
		$("#addMenu").dialog("open");
	});
	$("#addLvlTwoBtn").click(function() {
		$("#superMenu").html($("#acc").accordion("getSelected").panel('body').attr("text"));
		$("input[name='pid']").val($("#acc").accordion("getSelected").panel('body').attr("id"));
		$("#addSubMenu").dialog("open");
	});
	$("#delBtn").click(function() {
		if (confirm("是否确认删除菜单？注意：子菜单也会删除")) {
			var id = $("#acc").accordion("getSelected").panel('body').attr("id");
			$("input[name='id']").val(id);
			$("#delForm").submit();
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