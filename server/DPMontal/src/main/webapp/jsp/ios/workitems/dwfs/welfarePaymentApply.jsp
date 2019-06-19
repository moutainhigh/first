<%@page import="com.deppon.wfs.workflow.domain.WelfarePaymentBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
</head>
<%
WelfarePaymentBean info = (WelfarePaymentBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>工作流:<em>福利费发放申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>部门:<em><%=info.getUserDept()%></em></li>
				<li>申请发放类型:<em><%=info.getWagesTypeName()%></em></li>
				<%if(!"7".equals(info.getWagesType())){ %>
					<li>人均工资水平:<em><%=info.getWageLevel()%></em></li>
				<%} %>
				<li>申请发放薪资年份:<em><%=info.getEarningsYear()%></em></li>
				<li>申请发放薪资月份:<em><%=info.getEarningsMonth()%></em></li>
				<li>申请发放总笔数:<em><%=info.getTotalFrequencyStr()%></em></li>
				<li>申请发放总金额:<em><%=info.getApplyAmount()%></em></li>
				<%if(!"7".equals(info.getWagesType())){ %>
					<li>基本工资合计金额:<em><%=info.getBasicWagesAmount()%></em></li>
					<li>业务费合计金额:<em><%=info.getOperationCostAmount()%></em></li>
					<li>亲情扣款合计金额:<em><%=info.getFamilyDeductionAmount()%></em></li>
					<li>代还个人借款合计金额:<em><%=info.getPersonalLoanAmount()%></em></li>
				<%} %>
				<li>申请事由<em><%=info.getApplyReason()%></em></li>
		 </ul>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
	
	
	
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
</div>
<script type="text/javascript">
$(function(){
	//起草人[manualActivity8]、起草人[manualActivity81]
	var activitydefid = $("#activitydefid").val();
	if(activitydefid == 'manualActivity8' ||  activitydefid == 'manualActivity81' ){
		$("#approve_area").hide();
		$("#div3").hide();
	}
});
</script>
</body>
</html>