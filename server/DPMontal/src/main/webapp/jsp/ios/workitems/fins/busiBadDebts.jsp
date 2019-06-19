<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.fins.esb.mobile.domain.BaddebtMobileWfEntity"%>
<%@page import="com.deppon.fins.esb.mobile.domain.WfInfoEntity" %>
<%@page import="com.deppon.fins.esb.mobile.domain.WayInfoPojo" %>
<%@page import="com.deppon.fins.esb.mobile.domain.Duty" %>
<%@page import="com.deppon.fins.esb.mobile.domain.InitWorkFlowViewDataResponse" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
<%@include file="/common_ios.jsp"%>
<style type="text/css">
li {
	word-wrap: break-word;
}
</style>
</head>
<%
InitWorkFlowViewDataResponse finsResponse = (InitWorkFlowViewDataResponse)request.getAttribute("finsBusiRsp");
//起草人信息
WfInfoEntity applyInfo = finsResponse.getMobileFinsWfEntity().getWfInfoEntity();
//坏账业务信息
BaddebtMobileWfEntity infoBasic =finsResponse.getMobileFinsWfEntity().getBaddebtMobileWfEntity();
//其他信息
List<WayInfoPojo> wayInfoPojoList = infoBasic.getWayInfoPojo();
List<Duty> dutyList= infoBasic.getDuty();
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
				<li class="first"><em class="yellow">基本信息</em></li>
				<li>工作流号:<em><%=applyInfo.getWorkflowid() == null ? "" : applyInfo.getWorkflowid()%></em></li>
				<li>申请时间:<em><%=applyInfo.getApplydate() == null ? "" : applyInfo.getApplydate()%></em></li>
				<li>申请人:<em><%= applyInfo.getApplyname() == null ? "" : applyInfo.getApplyname()%></em></li>
				<li>申请部门:<em><%=applyInfo.getApplydept() == null ? "" : applyInfo.getApplydept()%></em></li>
				
				<li><em class="yellow">坏账信息</em></li>
				<li>工作流名称:<em><%=infoBasic.getWorkflowName() == null ? "" : infoBasic.getWorkflowName()%></em></li>
				<li>坏账金额:<em><%=infoBasic.getBadamount() == null ? "" : infoBasic.getBadamount()%></em></li>
				<li>客户编码:<em><%=infoBasic.getCustomercode() == null ? "" : infoBasic.getCustomercode()%></em></li>
				<li>客户名称:<em><%= infoBasic.getCustomername() == null ? "" : infoBasic.getCustomername()%></em></li>
				<li>坏账原因:<em><%=infoBasic.getReason() == null ? "" : infoBasic.getReason()%></em></li>
				<li>原因类型:<em><%=infoBasic.getReasontypename() == null ? "" : infoBasic.getReasontypename()%></em></li>
				<li>差错处理编码:<em><%=infoBasic.getErrorcode() == null ? "" : infoBasic.getErrorcode()%></em></li>
				<li>产生坏账原因:<em><%=infoBasic.getDiscription() == null ? "" : infoBasic.getDiscription()%></em></li>
				<li><em class="yellow">运单信息</em></li>
			   <%
				int size1 = wayInfoPojoList == null ? 0 : wayInfoPojoList.size();
				for(int i=0; i< size1; i++){
					WayInfoPojo  wayInfoPojo = wayInfoPojoList.get(i);
				%>
				<li <%=i==0?"":"class='line'" %>>账单:<em><%=wayInfoPojo.getBusinessnumber() == null ? "" : wayInfoPojo.getBusinessnumber()%></em></li>
				<li>未核销金额:<em><%=wayInfoPojo.getNoverification() == null ? "" : wayInfoPojo.getNoverification()%></em></li>
				<li>业务日期:<em><%=wayInfoPojo.getBusinessdate() == null ? "" : wayInfoPojo.getBusinessdate()%></em></li>
				<%
				}
				%>
				<li><em class="yellow">责任人及责任部门</em></li>
			   <%
				int size2 = dutyList == null ? 0 : dutyList.size();
				for(int i=0; i< size2; i++){
					Duty  duty = dutyList.get(i);
				%>
				 <li <%=i==0?"":"class='line'" %>>责任部门:<em><%=duty.getResponsibledept() == null ? "" : duty.getResponsibledept()%></em></li>	
				 <li>入部门费用:<em><%=duty.getIndeptmoney() == null ? "" : duty.getIndeptmoney()%></em></li>	
				 <li>责任人:<em><%=duty.getResponsibleperson() == null ? "" : duty.getResponsibleperson()%></em></li>	
				 <li>个人扣款:<em><%=duty.getDeductionamount() == null ? "" : duty.getDeductionamount()%></em></li>	
				<%
				}
				%>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
<script type="text/javascript">
	$(function() {
		});
	</script>
</body>
</html>