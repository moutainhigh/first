<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ApproveFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.AttachResource"%>
<%@page errorPage="/errorPage.jsp" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<h4 id="showAppId" class="yellow">查看审批记录</h4>
<% 
	ApproveFssc[] appInfos = (ApproveFssc[])request.getAttribute("approvalInfos");
	//这个是为了有的页面需啊哟去掉核定金额字段
	String accountNode = "";
%>
<div id="ulBox" style="display:none;">
     <div class="ulBox2">
     	<ul>
     		<%
				for(int i=0; i<appInfos.length-1; i++){//最后一条为当前申请节点，需过滤
					ApproveFssc  appInfo = appInfos[i];
					if ("费用核算组核算专员".contentEquals(appInfo.getCurrentactivitydefname())) {
						accountNode = "AccountXX";
					}
			%>
     		<li <%=i==0?"class='first'":"class='line'" %> >审批时间:<em><%=appInfo.getApprovedateStr() %></em></li>
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
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
	<div class="dpFiles">
	<!-- 以下是上传附件 -->
		<h4 id="showFile" class="yellow">打开附件列表</h4>	
		<div  class='toFile' style="display:none;">
	     	<%					MobileFsscEntity fsscFile = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
								AttachResource[] fileArray = fsscFile.getAttachResource();
								int length = fileArray == null ? 0:fileArray.length;
								for(int i = 0 ; i < length  ; i++) {
									%>
									<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileArray[i].getAttachpath()%>&fileName=<%=fileArray[i].getAttachname()%>" ><%=fileArray[i].getAttachname()%></a>&nbsp;
								<%} %>
	     	 <h4 id='hideFile' class="yellow">关闭附件列表</h4>
		   </div>  
		</div>
<input type="hidden" id ="AccountXXIDIOS" value = <%=accountNode %>>
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

