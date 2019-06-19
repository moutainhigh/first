<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity"%>

<%
	AttachEntity[] fileArray = (AttachEntity[])request.getAttribute("attachListLSP");
%>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
<div class="dpFiles">
		<h4 class="yellow" id="showFile">查看附件列表</h4>
<!-- 以下是上传附件 -->

		<div id="toFile" style="display: none">
			<ul>
				<%	
					int length = fileArray == null ? 0:fileArray.length;
					for(int i = 0 ; i < length  ; i++) {
				%>
				<li><em><a href = "<%=fileArray[i].getFileURL()%>" ><%=fileArray[i].getFileName()%></a></em></li>
				<%} %>
			</ul>
			<h4 class="yellow" id='hideFile'>关闭附件列表</h4>
		</div>
</div>
<script type="text/javascript">
	$("#showFile").click(function(){
		$("#toFile").slideDown();
	});
	$("#hideFile").click(function(){
		$("#toFile").slideUp();
	});
	$("#showFile").click(function(){
		$("#toFile").slideDown();
	});
	$("#hideFile").click(function(){
		$("#toFile").slideUp();
	});
	if($("#app_ui").val()=="false"){
		$(".dpFiles").hide();
	}
</script>
