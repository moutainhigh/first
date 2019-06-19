<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity"%>

<%
	AttachEntity[] fileArray = (AttachEntity[])request.getAttribute("attachListLSP");
%>
	<!-- 获取UI标记 ，转为判断附件是否显示的-->
					<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
		<tbody class="dpFiles">
			<tr>
				<th colspan="2"><a class="yellow" onclick="showFileRecord()">查看附件列表</a></th>
			</tr>
		
			<!-- 以下是上传附件 -->
				<%	
					int length = fileArray == null ? 0:fileArray.length;
					for(int i = 0 ; i < length  ; i++) {
				%>
					<tr class="fileListIdLSP" style="display: none" ><td><a href = "<%=fileArray[i].getFileURL()%>" style="color: red"><%=fileArray[i].getFileName()%></a></td></tr>
				<%} %>
			<tr class="fileListIdLSP" style="display: none">
				<th colspan="2"><a class="yellow" onclick="closeFileRecord()">关闭附件列表</a></th>
			</tr>
			</tbody>
<script type="text/javascript">
	function showFileRecord(){
		$('.fileListIdLSP').show();
		
	}
	function closeFileRecord(){
		$('.fileListIdLSP').hide();
	}
	$(function(){
		var app_ui = $("#app_ui").val();
		if(app_ui== 'false'){
			$(".dpFiles").hide();
		}
	});
</script>