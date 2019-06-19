<%@page import="com.deppon.montal.util.FormatUtil" %>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.module.crm.damin.ApprovalInfo"%>
<%@page import="com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.montal.module.crm.damin.FileInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date" %>
<%@page errorPage="/errorPage.jsp" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<% 
QueryWorkflowInfoResponse info1 = (QueryWorkflowInfoResponse)request.getAttribute("queryWorkflowInfoResponse");
List<ApprovalInfo> approvalInfo = info1.getApprovalInfo();
%>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">

<h4 id="showAppId" class="yellow">查看审批记录</h4>
<div id="ulBox" style="display:none;">
     <div class="ulBox2">
     	<ul>
     		<%
     		int size = approvalInfo == null ? 0:approvalInfo.size();
			for(int i=0; i< size; i++){
				ApprovalInfo  appInfo = approvalInfo.get(i);
			%>
     		<li <%=i==0?"class='first'":"class='line'" %> >审批时间:<em><%=FormatUtil.formatDate(appInfo.getApprovedate(), "yyyy-MM-dd hh:mm:ss")%></em></li>
     		<li>审批处理人:<em><%=appInfo.getApprover()%></em></li>
     		<li>审批人结果:<em><%=F_Constants.WORKFLOW_RESULT_MAP.get(appInfo.getIsagree())%></em></li>
     		<li>审批人意见:<em><%=appInfo.getApprovever()==null?"":appInfo.getApprovever()%></em></li>
     		<%
				}
			%>
     	</ul>
     </div>
     <h4 id="hideList" class="yellow">关闭审批记录</h4>
</div>
<!-- 以下是上传附件 -->
	<div class='dpFiles'>
		<h4 id="showFile" class="yellow">打开附件列表</h4>	
	
		<div  class='toFile' style="display:none;">
     	<%					List<FileInfo> fileList = info1.getFileInfo();
							int length = fileList == null ? 0:fileList.size();
							for(int i = 0 ; i < length; i++) {
								%>
							<ul>
								<li><em><a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileList.get(i).getSavePath()%>&fileName=<%=fileList.get(i).getFileName()%>" ><%=fileList.get(i).getFileName()%></a></em></li>
							</ul>
							<%} %>
   		  <h4 id='hideFile' class="yellow">关闭附件列表</h4>
	   </div>  
	 </div>
<div class="ulBox2" id="approve_area">
	<ul>
		<li class="first gray"><textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" class="gray" id="textarea-a"  placeholder="请输入审批意见..."></textarea></li>
		<li class="num">剩余<i id="textareaNum">300</i><i >/300</i>字</li>
	</ul>
</div>
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
	$("#showAppId").click(function(){
		$("#ulBox").slideDown();
	});
	$("#hideList").click(function(){
		$("#ulBox").slideUp();
	});
	if($("#app_ui").val()=="false"){
		$(".dpFiles").hide();
	}
});	
</script>

