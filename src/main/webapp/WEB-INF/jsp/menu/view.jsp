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
<body style="padding:10px;">
<div class="panel-group" id="accordion" style="width:500px">
<c:forEach items="${menus}" var="item" varStatus="stat">
  <div class="panel panel-info">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse${stat.index}">
        ${item.text }
        </a>
        <a class="del" href="javascript:;" style="float:right">删除</a><a class="edit" href="javascript:;" style="float:right;margin-right:5px;">编辑</a>
      </h4>
    </div>
    <div id="collapse${stat.index}" class="panel-collapse collapse in">
      <div class="panel-body">
        <ul class="list-group">
           <c:forEach items="${item.subMenus}" var="menu">
           	  <li class="list-group-item">${menu.text}<a class="del" href="javascript:;" style="float:right">删除</a><a class="edit"  href="javascript:;" style="float:right;margin-right:5px;">编辑</a></li>
           </c:forEach>
		</ul>
      </div>
    </div>
  </div>
</c:forEach>
</div>
<script type="text/javascript">
$(function() {
	
})
</script>
</body>
</html>