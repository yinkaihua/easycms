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
	<link href="${_staticRes}/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<link href="${_staticRes}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${_staticRes}/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" src="${_staticRes}/umeditor/umeditor.min.js"></script>
    <script type="text/javascript" src="${_staticRes}/umeditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div style="margin:20px;">
	<a href="javascript:history.go(-1);" class="easyui-linkbutton" data-options="iconCls:'icon-add'">返回</a>
	<label for="name">当前栏目：</label>${channel.name}
	<a style="float:right;" href="javascript:autoFill();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">自动填充</a>
	<a style="float:right;" href="javascript:submitContent();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">发布</a>
</div>
<form action="${_ctxPath}/content/save.htm" method="post" id="form">
<input type="hidden" name="id" value="${contents.id}">
<input type="hidden" name="channel.id" value="${channel.id}">
<input type="hidden" name="contentExt.txt" id="txt">
<div style="margin:20px;">
	<label for="name">标题</label>
	<input name="title" type="text" class="form-control" id="title" placeholder="请输入标题" autocomplete="off" value="${contents.title}"/>
</div>
<div style="margin:20px;">
	<label for="name">SEO标题</label>
	<input name="metaTitle" type="text" class="form-control" id="metaTitle" placeholder="请输入SEO标题" autocomplete="off" value="${contents.metaTitle}"/>
</div>
<div style="margin:20px;">
	<label for="name">SEO关键字</label>
	<input name="metaKeywords" type="text" class="form-control" id="metaKeywords" placeholder="请输入SEO关键字" autocomplete="off" value="${contents.metaKeywords}"/>
</div>
<div style="margin:20px;">
	<label for="name">SEO描述</label>
	<input name="metaDescription" type="text" class="form-control" id="metaDescription" placeholder="请输入SEO描述" autocomplete="off" value="${contents.metaDescription}"/>
</div>
<div style="margin:20px; display:none;">
	<label for="name">状态</label>
	<select name="state" class="easyui-combobox" style="width:100px">
		<option value="1" selected="selected">是</option>
		<option value="9">否</option>
	</select>
</div>
<div style="margin:20px;">
	<label for="name">内容</label>
	<script type="text/plain" id="editor" style="width:100%;height:350px;"><p>${contents.contentExt.txt}</p></script>
</div>
<div style="margin:20px;">
	<a href="javascript:history.go(-1);" class="easyui-linkbutton" data-options="iconCls:'icon-add'">返回</a>
	<a href="javascript:submitContent();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">发布</a>
</div>
</form>
<script type="text/javascript">
//实例化编辑器
var um = UM.getEditor("editor");
function submitContent() {
	if ($("#title").val()=="") {
		alert("标题不能为空");
		return;
	}
	var txt = UM.getEditor("editor").getContent();
	if (txt=="") {
		alert("内容不能为空");
		return;
	}
	$("#txt").val(txt);
	$("#form").submit();
}
function autoFill() {
	var txt = um.getContentTxt();
	var r = /HTML5{0,1} (<\w*>)/.exec(txt);
	if (r==null || r.length<2) {
		alert("自动填充失败==>" + r);
		return;
	}
	var tag = r[1];
	alert("当前标签==>" + tag);
	$("#metaTitle").val("HTML " + tag + " 标签" + "－HTML教程－编程之家");
	$("#title").val(tag);
	tag = tag.replace(/<|>/g,"")
	$("#metaKeywords").val(tag+"，"+tag+"标签，"+"HTML5，HTML实例");
}
$(function() {
	var isEdit = "${isEdit}";
	if (isEdit!="yes") {
		//设置默认seo标题
		$("#metaTitle").val("－HTML教程－编程之家");
		$("#metaKeywords").val("HTML5，HTML实例");
	}
})
</script>
</body>
</html>