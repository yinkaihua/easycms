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
<div class="easyui-layout" style="width:90%;height:700px;margin:20px;">
	<div region="west" split="false" title="栏目" style="width:200px;">
		<ul class="easyui-tree" style="margin:10px"></ul>
	</div>
	<div id="content" region="center" title="内容" style="padding:5px;">
	<iframe name="contentIframe" style="border:0; width:100%; height:100%"></iframe>
		<%-- <table class="table table-bordered table-hover" style="width:800px; margin:20px">
			<thead>
				<tr class="success">
					<td>文章ID</td>
					<td>标题</td>
					<td>栏目</td>
					<td>发布时间</td>
					<td>发布状态</td>
					<td>状态</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dicts}" var="s">
			
			</c:forEach>
			</tbody>
		</table> --%>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$(".easyui-tree").tree({
		data:eval('${treejson}'),
		onClick:function(node) {
			showContents(node);
		}
	});
});
function siteChangeEvent(newVal, oldVal) {
	location.href="${_ctxPath}/content/view.htm?wc_p_context_sid="+newVal;
}
function showContents(node) {
	$("iframe[name='contentIframe']").attr("src", "${_ctxPath}/content/list.htm?cid="+node.id);
}
function getSelectedChannel() {
	return $(".easyui-tree").tree("getSelected");
}
</script>
</body>
</html>