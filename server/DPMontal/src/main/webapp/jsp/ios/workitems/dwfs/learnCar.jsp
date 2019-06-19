<%@page import="com.deppon.wfs.workflow.domain.LearnCarBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_ios.jsp"%>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	LearnCarBean info = (LearnCarBean)request.getAttribute("entity");
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>

					<li class="first">工作流号:<em><%=request.getAttribute("processinstid") %>
							<input type="hidden" id="busino" value="<%=info.getBusino()%>">
							<input type="hidden" id="approval_url"
							value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> </em>
					</li>

					<li>工作流:<em>学车报名申请</em></li>
					<li>申请人姓名:<em><%=info.getApplyPersonName()%></em></li>
					<li>当地办公室:<em><%=info.getLocalOfficeName()%></em></li>
					<li>享受福利原因:<em><%=info.getWelfareReason()%></em></li>
					<%if("1".equals(info.getWelfareReasonCode())) { %>
						<li>转正工作流号:<em><%=info.getFormalWorkflowId()%></em></li>
					<%}%>
					<%if("3".equals(info.getWelfareReasonCode())) {%>
						<li>储干区域:<em><%=info.getCadreArea()%></em></li>
						<li>第几届储干:<em><%=info.getCadreTime()%></em></li>
						<li>储干名次:<em><%=info.getCadreRank()%></em></li>
					<%} %>
					<li>报名日期:<em><%=FormatUtil.formatDate(info.getEnrollDate())%></em></li>
					<li>学车费用总金额:<em><%=info.getFeeAmount()%></em></li>
					<li>驾校名称:<em><%=info.getDschoolName()%></em></li>
					<li>驾校电话:<em><%=info.getDschoolTel()%></em></li>
					<li>申请事由:<em><%=info.getReason()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#rollback_but").hide();
	});
</script>
</html>