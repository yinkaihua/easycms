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
<div class="easyui-panel" title="字典条目" style="width:300px;">
	<div style="padding:10px 20px 20px 20px">
    <form id="ff" method="post">
    	<input type="hidden" name="id" value="${so.id}"/>
    	<table cellpadding="5">
    		<tr>
    			<td>分类：</td>
    			<td><input class="easyui-textbox" type="text" name="catalogCode" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td>键（KEY）：</td>
    			<td><input class="easyui-textbox" type="text" name="key" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td>值（VALUE）：</td>
    			<td><input class="easyui-textbox" type="text" name="value" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td>描述：</td>
    			<td><input class="easyui-textbox" type="text" name="desc" data-options="required:true"/></td>
    		</tr>
    		<tr>
    			<td>排序：</td>
    			<td><input class="easyui-textbox" type="text" name="sort" data-options="required:true"/></td>
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
	catalogCode:'${so.catalogCode}',
	key:'${so.key}',
	value:'${so.value}',
	desc:'${so.desc}',
	sort:'${so.sort}'
});
</c:if>
function submitForm(){
	$('#ff').form('submit',{
		url:'${_ctxPath}/dict/save',
		method:'post',
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function() {
			location.href="${_ctxPath}/dict/view";
		}
	});
}
function clearForm(){
	$('#ff').form('clear');
}
</script>
</body>
</html>