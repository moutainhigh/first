<%@page import="com.deppon.wfs.workflow.domain.WelfarePaymentBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
WelfarePaymentBean info = (WelfarePaymentBean)request.getAttribute("entity");
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>福利费发放申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getApplyPersonName()%></td></tr>
				<tr><th>工号:</th><td><%=info.getApplyPersonId()%></td></tr>
				<tr><th>部门:</th><td><%=info.getUserDept()%></td></tr>
				<tr><th>申请发放类型:</th><td><%=info.getWagesTypeName()%></td></tr>
				<%if(!"7".equals(info.getWagesType())){ %>
					<tr><th>人均工资水平:</th><td><%=info.getWageLevel()%></td></tr>
				<%} %>
				<tr><th>申请发放薪资年份:</th><td><%=info.getEarningsYear()%></td></tr>
				<tr><th>申请发放薪资月份:</th><td><%=info.getEarningsMonth()%></td></tr>
				<tr><th>申请发放总笔数:</th><td><%=info.getTotalFrequencyStr()%></td></tr>
				<tr><th>申请发放总金额:</th><td><%=info.getApplyAmount()%></td></tr>
				<%if(!"7".equals(info.getWagesType())){ %>
					<tr><th>基本工资合计金额:</th><td><%=info.getBasicWagesAmount()%></td></tr>
					<tr><th>业务费合计金额:</th><td><%=info.getOperationCostAmount()%></td></tr>
					<tr><th>亲情扣款合计金额:</th><td><%=info.getFamilyDeductionAmount()%></td></tr>
					<tr><th>代还个人借款合计金额:</th><td><%=info.getPersonalLoanAmount()%></td></tr>
				<%} %>
				<tr><th>申请事由</th><td><%=info.getApplyReason()%></td></tr>
			   </tr>
		<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
</div>

</body>
</html>