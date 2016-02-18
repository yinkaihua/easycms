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
<hr>
<div class="easyui-layout" style="width:500px;height:200px;margin:50px;">
	<div region="west" split="false" title="栏目" style="width:200px;">
		<ul class="easyui-tree" style="margin:10px">
			<li><span>栏目</span>
				<ul>
				<c:forEach items="${channels}" var="c">
					<li><span>${c.name}</span>
						<ul>
							<c:forEach items="${c.subChannel}" var="s"><li><span>${s.name }</span></li></c:forEach>
						</ul>
					</li>
				</c:forEach>
				</ul>
			</li>
		</ul>
	</div>
	<div id="content" region="center" title="编辑面板" style="padding:5px;">
	</div>
</div>

<%-- <table class="table table-bordered table-hover" style="width:800px; margin:20px">
	<thead>
		<tr class="success">
			<td>序号</td>
			<td>名称</td>
			<td>路径</td>
			<td>排序</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${channels}" var="s" varStatus="vs">
		<tr>
			<td>${vs.index+1 }</td>
			<td>${s.name }</td>
			<td>${s.path }</td>
			<td>${s.sort }</td>
			<td><ec:dict catalog="state" code="${s.state }"/></td>
			<td><a href="${_ctxPath}/channel/to_edit?id=${s.id}" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a><a href="javascript:delChannel('${s.id }');" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table> --%>
<script type="text/javascript">
$(function() {
	$("#siteCombo").combobox({
		onChange:function(newVal, oldVal) {
			location.href="${_ctxPath}/channel/view?siteId="+newVal;
		}
	});
})
function delChannel(id) {
	if (confirm("确认删除栏目？")) {
		location.href="${_ctxPath}/channel/remove?id="+id;
	}
}
</script>
</body>
</html>