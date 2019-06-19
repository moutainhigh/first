<%@page import="com.deppon.montal.util.FormatUtil" %>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity"%>
<%@page import="com.deppon.bpms.module.shared.domain.ApprovalInfo"%>

<%@ page language="java"  pageEncoding="UTF-8"%>

<% 
	WorkflowEntity infoForApprovalInfoCommon = (WorkflowEntity)request.getAttribute("lspResponseEntity");
	
	ApprovalInfo[] ApprovalInfoList = infoForApprovalInfoCommon.getApprovalInfoList();

	String accountNode = "";
%>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
<!-- 附件 -->
		<table  width="100%">
			<tbody class="dpFiles">
			<!-- 以下是上传附件 -->
			<tr class="files">
				<th colspan="2"><a class="yellow" id="showFile">查看附件列表</a></th>
			</tr>	
					<%	
						AttachEntity[] fileArray = infoForApprovalInfoCommon.getAttachList();
						int length = fileArray == null ? 0:fileArray.length;
						for(int i = 0 ; i < length  ; i++) {
							%>
					<tr class='toFile' style="display: none">
						<td>
							<br><a href = "<%=fileArray[i].getFileURL()%>" style="color:red"><%=fileArray[i].getFileName()%></a>&nbsp;
						</td>
					</tr>
					<%} %>
   			 <tr class="toFile" style="display: none">
				<th colspan="2"><a class="yellow" id="hideFile">关闭附件列表</a></th>
			</tr>
			</tbody>
			<tr id="appstr">
				<th colspan="2"><a class="yellow" id="sliderDown">查看审批记录</a></th>
			</tr>					
			<%
				int size = ApprovalInfoList == null ? 0:ApprovalInfoList.length;
				for(int i=0; i< size - 1; i++){
					ApprovalInfo  appInfo = ApprovalInfoList[i];
			%>
				 <tr <%=i==0?"class='sh'":"class='topLine sh'" %>><th>审批时间:</th> <td><%=FormatUtil.formatDate(appInfo.getApprovedate(), "yyyy-MM-dd hh:mm:ss")%></td> </tr>
				 <tr class="sh"><th>审批处理人:</th> <td><%=appInfo.getApprover()%></td> </tr>
				 <tr class="sh"><th>审批人结果:</th> <td><%=F_Constants.WORKFLOW_RESULT_MAP.get(appInfo.getIsagree())%></td> </tr>
				 <tr class="sh"><th>审批人意见:</th> <td><%=appInfo.getApprovever()==null?"":appInfo.getApprovever()%></td> </tr>
			<%
				}
			%>

			<tr class="sh">
				<th colspan="2"><a class="yellow" id="sliderUp">关闭审批记录</a></th>
			</tr>
			
			<tr>
				<td colspan="2" class="fyy-textRt"></td>
			</tr>
			<tr>
			   	<td colspan="2">
			   		<div class="area" id="approve_area">
						<textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" id="textarea-a" placeholder="请输入审批意见..."></textarea>
						<h6>剩余<i id="textareaNum">300</i><i>/300</i>字</h6>
					</div>
			   	</td>
			</tr>
		</table>
		
	<script type="text/javascript">
		$(function(){
			//显示附件列表
			$("#showFile").click(function(){
				$(".toFile").show();
			});
			//关闭附件列表
			$("#hideFile").click(function(){
				$(".toFile").hide();
			});
			//显示审批记录
			$("#sliderDown").click(function(){
				$("table").find(".sh").show();
			});
			//关闭审批记录
			$("#sliderUp").click(function(){
				$("table").find(".sh").hide();
			});
			if($("#app_ui").val()=="false"){
				$(".dpFiles").hide();
			}
		});
		
		$('#textarea-a').bind('input propertychange', function(event) {
		    $("#textarea-a").parent().css("border-color","#aaa");
		    	var length1 = event.srcElement.value.length;
		    	if(length1 <= length0){
		    		var length2 = length0-length1;
		        	$("#textareaNum").text((length2));
		    	}
		    	if($(this).val().length >300){
					$(this).val(this.value.substring(0,300));		
				}
		});
		
		var length0 = 300;
		
		//审批意见输入监听
		document.getElementById("textarea-a").onkeydown = function(event_e){
			if( window.event ) event_e = window.event;
			var int_keycode = event_e.charCode||event_e.keyCode;
			var length = document.getElementById("textarea-a").value.length;
			var obj = document.getElementById("textarea-a");
			if(length == 0 ){
				if(int_keycode ==32){
					return false;
			 	}
			}
			if (/^\s+/.test(obj.value)) {
				return false;
			} 
			if(int_keycode ==13){
					return false;
			 }
		};
	</script>