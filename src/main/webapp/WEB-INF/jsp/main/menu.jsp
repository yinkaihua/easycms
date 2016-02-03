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
<div class="panel-group" id="accordion">
<c:forEach items="${menus}" var="item" varStatus="stat">
  <div class="panel panel-default">
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
		   <li class="list-group-item">免费域名注册</li>
		   <li class="list-group-item">免费 Window 空间托管</li>
		   <li class="list-group-item">图像的数量</li>
		   <li class="list-group-item">24*7 支持</li>
		   <li class="list-group-item">每年更新成本</li>
		</ul>
      </div>
    </div>
  </div>
</c:forEach>
</div>
</body>
</html>