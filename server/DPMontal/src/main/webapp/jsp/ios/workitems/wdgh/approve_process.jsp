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

<h4 id="showAppId" class="yellow">查看审批记录</h4>
<div id="ulBox" style="display:none;">
     <div class="ulBox2">
     	<ul>
     		<%
				int size = approveInfoList == null ? 0 : approveInfoList.size();
				for(int i=0; i< size; i++){
					ApproveInfo  appInfo = approveInfoList.get(i);
			%>
     		<li <%=i==0?"class='first'":"class='line'" %> >处理时间:<em><%=FormatUtil.formatDate(appInfo.getApplyTime(), "yyyy-MM-dd HH:mm:ss")%></em></li>
     		<li>处理人:<em><%=appInfo.getApplyPersonCode()%></em></li>
     		<li>处理结果:<em><%=F_Constants.WORKFLOW_RESULT_MAP.get(appInfo.getApplyResult())%></em></li>
     		<li>处理意见:<em><%=appInfo.getApplyAdvise()==null?"":appInfo.getApplyAdvise()%></em></li>
     		<%
				}
			%>
     	</ul>
     </div>
     <h4 id="hideList" class="yellow">关闭审批记录</h4>
</div>
<div class="dpFiles">
	<!-- 以下是上传附件 -->
	<h4 id="showFile" class="yellow">打开附件列表</h4>	
		<div  class='toFile' style="display:none;">
	     	<%					int length = fileInfo == null ? 0:fileInfo.size();
								for(int i = 0 ; i < length  ; i++) {
									%>
								<ul>
									<li><em><a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileInfo.get(i).getUrl()%>&fileName=<%=fileInfo.get(i).getAttachementName()%>&fileType=<%=fileInfo.get(i).getAttachementType()%>" >
									<%=fileInfo.get(i).getAttachementName()%></a></em></li>
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

