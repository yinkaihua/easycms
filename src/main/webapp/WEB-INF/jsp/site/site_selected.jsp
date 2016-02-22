<%@ page contentType="text/html; charset=utf-8"%>
<div style="margin:20px">
	站点选择：<select id="siteCombo" name="site" class="easyui-combobox" style="width:100px">
		<c:forEach items="${sites}" var="s">
		<option value="-1" <c:if test="${p.siteId==null}"> selected="selected"</c:if>>无</option>
		<option value="${s.id }" <c:if test="${p.siteId==s.id}"> selected="selected"</c:if>>${s.name}</option>
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