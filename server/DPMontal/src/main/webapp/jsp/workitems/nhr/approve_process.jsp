<%@page import="com.deppon.fins.esb.mobile.domain.MobileFinsWfEntity"%>
<%@page import="com.deppon.montal.util.FormatUtil" %>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.ApprovalDetail" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.FileInfo" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page errorPage="/errorPage.jsp" %>
<% 
	QueryWorkflowInfoResponse infoAppr = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
	List<ApprovalDetail> approveInfoList = infoAppr.getApprovalList();
	String accountNode = "";
%>
<!--  获取UI标记-->
<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
	
		<table width="100%">
			<tbody class="dpFiles">
				<!-- 		<th>附件信息：</th> -->
				<tr class="files">
					<th colspan="2"><a class="yellow" id="showFile">查看附件列表</a></th>
				</tr>	
			
	     	<%					
	     						List<FileInfo> fileList = infoAppr.getFiles();
	     						int length = fileList == null ? 0:fileList.size();
								for(int i = 0 ; i < length; i++) {
									%>
						<tr class='toFile' style="display: none">
								<td class="<%=i == 0 ? "first" : "line" %>">
									<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileList.get(i).getFileAddress()%>&fileName=<%=fileList.get(i).getFileName()%>" style="color: red"><%=fileList.get(i).getFileName()%></a>&nbsp;
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
				for(int i=0; i< size -1; i++){
					ApprovalDetail  appInfo = approveInfoList.get(i);
			%>
				 <tr <%=i==0?"class='sh'":"class='topLine sh'" %>><th>审批时间:</th> <td><%=FormatUtil.formatDate(appInfo.getApprovaldate(), "yyyy-MM-dd hh:mm:ss")%></td> </tr>
				 <tr class="sh"><th>审批处理人:</th> <td><%=appInfo.getApprover()==null?"":appInfo.getApprover()%></td> </tr>
				 <tr class="sh"><th>审批人岗位</th> <td><%=appInfo.getApplyno()==null?"": appInfo.getApplyno()%></td></tr>
				 <tr class="sh"><th>审批结果:</th> <td><%=appInfo.getIsagree()==null?"": appInfo.getIsagree()%></td> </tr>
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
	</script>