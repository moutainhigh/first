<%@page import="com.deppon.wfs.workflow.domain.FilePublishBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	FilePublishBean info = (FilePublishBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   		<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em> 文件发布申请</em></li>
			   		<li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   		</li>
					<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>文件发布申请</em></li>
					<li>申请人：<em><%=info.getApplyPersonName()%></em></li>
					<li>责任部门：<em><%=info.getResponDepart()%></em></li>
					<li>责任者：<em><%=info.getResponPeople()%></em></li>
					<li>页数：<em><%=info.getCountPage()%></em></li>
					<li>效力状态：<em><%=info.getEffectState()%></em></li>
					<li>申请类别：<em><%=info.getApplyType()%></em></li>
					<li>文件类别：<em><%=info.getFileType()%></em></li>
					<li>任免类型：<em><%=info.getAppointedType()%></em></li>
					<li>被任免人所在事业部：<em><%=info.getDivision()%></em></li>
					<li>文件使用范围：<em><%=info.getFileScope()%></em></li>
					<li>文件编号：<em><%=info.getFileCode()%></em></li>
					<li>文件标题：<em><%=info.getFileTitle()%></em></li>
					<li>文件摘要：<em><%=info.getFileAbstract()%></em></li>
					<li>文件生效日期：<em><%=FormatUtil.formatDate(info.getEffectDate())%></em></li>
					<li>文件过期日期：<em><%=FormatUtil.formatDate(info.getExpiredDate())%></em></li>
					<li>申请事由：<em><%=info.getApplyReason()%></em></li>  
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<f:init/>
</body>
<script type="text/javascript">
$(function(){
	var activityDefId = $('#activitydefid').val();
	if(activityDefId == 'manualActivity6'){
		$("#btnbox").hide();
		$("#approve_area").hide();
		var html = "<div id='div_span'><span style='color:red;float:left;text-align:center;line-height:20px;width: 100%;font-size: 20px;'>该节点未设置手机端，请至网页端审批，谢谢。</span></div>";
		$("body").append(html);
	}
});	
</script>
</html>