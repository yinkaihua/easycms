<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.coding17.easycms.web.util.WebConst" %>
<div style="margin:20px">
	站点选择：<select id="siteCombo" name="site" class="easyui-combobox" style="width:100px">
		<c:forEach items="${wc_a_req_allsites}" var="s">
		<option value="-1" <c:if test="${wc_a_req_sid==-1}"> selected="selected"</c:if>>无</option>
		<option value="${s.id}" <c:if test="${wc_a_req_sid==s.id}"> selected="selected"</c:if>>${s.name}</option>
		</c:forEach>
	</select>
</div>
<hr>
<script type="text/javascript">
$(function() {
	$("#siteCombo").combobox({
		onChange:function(newVal, oldVal) {
			siteChangeEvent(newVal, oldVal);
		}
	});
})
</script>