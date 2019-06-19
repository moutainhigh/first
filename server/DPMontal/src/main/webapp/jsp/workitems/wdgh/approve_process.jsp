<%@page import="com.deppon.montal.util.FormatUtil" %>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.wdgh.inteface.domain.ApproveInfo" %>
<%@page import="com.deppon.wdgh.inteface.domain.UploadInfo" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page errorPage="/errorPage.jsp" %>
<% 
	QueryWorkflowInfoResponse info = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
	List<ApproveInfo> approveInfoList = info.getApproveInfo();
	List<UploadInfo> fileInfo = info.getUploadInfos();
%>
		<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
		<table width="100%">
		<tbody class="dpFiles">
				<!-- 以下是上传附件 -->
			<tr class="files">
				<th colspan="2"><a class="yellow" id="showFile">查看附件列表</a></th>
			</tr>	
					<%	
					int length = fileInfo == null ? 0:fileInfo.size();
					for(int i = 0 ; i < length  ; i++) {
							%>
					<tr class='toFile' style="display: none">
						<td>
							<br>
							<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileInfo.get(i).getUrl()%>&fileName=<%=fileInfo.get(i).getAttachementName()%>&fileType=<%=fileInfo.get(i).getAttachementType()%>" style="color: red">
							<%=fileInfo.get(i).getAttachementName()%></a>&nbsp;
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
				int size = approveInfoList == null ? 0 : approveInfoList.size();
				for(int i=0; i< size; i++){
					ApproveInfo  appInfo = approveInfoList.get(i);
			%>
				 <tr <%=i==0?"class='sh'":"class='topLine sh'" %>><th>处理时间:</th> <td><%=FormatUtil.formatDate(appInfo.getApplyTime(), "yyyy-MM-dd HH:mm:ss")%></td> </tr>
				 <tr class="sh"><th>处理人:</th> <td><%=appInfo.getApplyPersonCode()%></td> </tr>
				 <tr class="sh"><th>处理结果:</th> <td><%=F_Constants.WORKFLOW_RESULT_MAP.get(appInfo.getApplyResult())%></td> </tr>
				 <tr class="sh"><th>处理意见:</th> <td><%=appInfo.getApplyAdvise()==null?"":appInfo.getApplyAdvise()%></td> </tr>
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
	</script>