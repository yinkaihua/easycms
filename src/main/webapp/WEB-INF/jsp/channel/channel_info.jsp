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
<div style="margin:20px"></div>
<div class="easyui-panel" title="栏目信息" style="width:300px;">
	<div style="padding:10px 20px 20px 20px">
    <form id="ff" method="post">
    	<input type="hidden" name="pid" value="${p.pid}" />
    	<input type="hidden" name="id" />
    	<table cellpadding="5">
    		<tr>
    			<td>名称：</td>
    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td>路径：</td>
    			<td><input class="easyui-textbox" type="text" name="path" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td>排序：</td>
    			<td><input class="easyui-textbox" type="text" name="sort" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td><div>是否启用</div></td>
				<td><select name="state" class="easyui-combobox" style="width:100%">
					<option value="1">是</option>
					<option value="9">否</option>
				</select></td>
    		</tr>
    	</table>
    </form>
    <div style="text-align:center;padding:5px">
    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
    </div>
    </div>
</div>
<script type="text/javascript">
<c:if test="${isEdit=='yes'}">
$("#ff").form("load", {
	id:'${so.id}',
	name:'${so.name}',
	path:'${so.path}',
	sort:'${so.sort}',
	state:'${so.state}'
});
</c:if>
function submitForm(){
	$('#ff').form('submit',{
		url:'${_ctxPath}/channel/save',
		method:'post',
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function() {
			location.href="${_ctxPath}/channel/view";
		}
	});
}
function clearForm(){
	$('#ff').form('clear');
}
</script>
</body>
</html>