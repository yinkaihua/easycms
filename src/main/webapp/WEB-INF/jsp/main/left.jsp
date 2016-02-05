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
<div class="easyui-accordion" style="width:100%;">
<c:forEach items="${menus}" var="item" varStatus="stat">
  <%-- <div class="panel panel-info">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse${stat.index}">
        ${item.text }
        </a>
      </h4>
    </div>
    <div id="collapse${stat.index}" class="panel-collapse collapse">
      <div class="panel-body">
        <ul class="list-group">
           <c:forEach items="${item.subMenus}" var="menu">
           	  <a href="${_ctxPath}/${menu.action}" class="list-group-item" target="rightFrame">${menu.text}</a>
           </c:forEach>
		</ul>
      </div>
    </div>
  </div> --%>
	<div title="${item.text}" data-options="" style="padding:10px;">
		<ul class="easyui-tree">
			<c:forEach items="${item.subMenus}" var="menu">
				<li><a href="${_ctxPath}/${menu.action}" target="rightFrame">${menu.text}</a></li>
           </c:forEach>
		</ul>
	</div>
</c:forEach>
</div>
<script type="text/javascript">
$(function() {
	
})
</script>
</body>
</html>