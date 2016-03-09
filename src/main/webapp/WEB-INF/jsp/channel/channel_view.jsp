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
	<a href="${_ctxPath}/channel/to_add.htm?pid=0" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建顶级栏目</a>
	<a href="javascript:createSubChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新建子栏目</a>
	<a href="javascript:editChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑栏目</a>
	<a href="javascript:delChannel();" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除栏目</a>
</div>
<hr>
<div class="easyui-layout" style="width:90%;height:700px;margin:20px;">
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
	<div id="content" region="center" title="当前栏目" style="padding:5px;">
		<iframe name="channelIframe" style="border:0; width:100%; height:100%"></iframe>              
	</table>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$(".easyui-tree").tree({
		onClick:function(node) {
			showSubNodes(node);
		}
	});
})
function siteChangeEvent(newVal, oldVal) {
	location.href="${_ctxPath}/channel/view.htm?wc_p_context_sid="+newVal;
}
function createSubChannel() {
	location.href="${_ctxPath}/channel/to_add.htm?pid="+$(".easyui-tree").tree("getSelected").id;
}
function editChannel() {
	location.href="${_ctxPath}/channel/to_edit.htm?id="+$("#tt").datagrid("getSelected").id;
}
function showSubNodes(node) {
	$("iframe[name='channelIframe']").attr("src", "${_ctxPath}/channel/list.htm?pid="+node.id);
}
function delChannel() {
	var node = $(".easyui-tree").tree("getSelected");
	if (!node) {
		alert("未选择栏目");
		return;
	}
	var id = node.id;
	$.getJSON("${_ctxPath}/channel/has_children.shtm?id="+id,{},function(ret) {
		if (ret.state=="1") {
			alert(ret.msg);
		} else {
			if (confirm("确认删除栏目？")) {
				location.href="${_ctxPath}/channel/remove.htm?id="+id;
			}
		}
	});
}
function editChannel() {
	var node = $(".easyui-tree").tree("getSelected");
	if (!node) {
		alert("未选择栏目");
		return;
	}
	location.href = "${_ctxPath}/channel/to_edit.htm?id="+node.id;
}
</script>
</body>
</html>