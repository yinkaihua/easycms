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
<div style="margin:20px;">
	<a href="javascript:statizIndex()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">静态化首页</a>
</div>
<script type="text/javascript">
function siteChangeEvent(newVal, oldVal) {
	location.href="${_ctxPath}/gen/statiz_page.htm?wc_p_context_sid="+newVal;
}
function statizIndex() {
	$.getJSON("${_ctxPath}/gen/statiz_index.shtm",{},function(ret) {
		alert(ret.state);
	});
}
</script>
</body>
</html>