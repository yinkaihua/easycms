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
<div style="margin:20px">
	栏目选择：<select name="channel" class="easyui-combobox" style="width:300px">
		<option value="-1">无</option>
		<c:forEach items="${channels}" var="s">
		<option value="${s.id}">${s.name}</option>
		</c:forEach>
	</select>
</div>
<div style="margin:20px;">
	<label for="name">标题</label>
	<input type="text" class="form-control" id="name" placeholder="请输入标题"/>
</div>
<div style="margin:20px;">
	<label for="name">内容</label>
	<script type="text/plain" id="myEditor" style="width:100%;height:240px;"></script>
</div>
<script type="text/javascript">
//实例化编辑器
var um = UM.getEditor("myEditor");
</script>
</body>
</html>