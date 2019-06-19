<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity info = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
 ClaimFsscBase base = info.getMobileBaseEntity();
 ClaimLineFssc[]  mobileLineList = info.getMobileLineArray();
 ApproveFssc[] mobileApprovalInfo = info.getMobileApprovalArray();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
	    		<tr>
				   <th>单据编号:</th>
			
				   <td id="workid"><%=base.getClaimNo() %></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>水电费（区域总部）-预提</td>
				</tr>
				   <tr>
					  <th >申请人:</th>
					  <td><%= base.getApplyEmpName()%></td>
				   </tr>
					 <tr>
					  <th >申请人部门:</th>
					  <td><%=base.getApplyDeptName()%></td>
				   </tr>
					 <tr>
					  <th >申请人公司:</th>
					  <td><%=base.getApplyCompName()%></td>
				   </tr>
					 <tr>
					  <th >申请时间:</th>
					  <td><%=base.getApplyDateStr()%></td>
				   </tr>
				   <tr>
						<th colspan="2" class="yellow">报账信息</th>
				   </tr>	
				   <tr>
					  <th>币种:</th>
					  <td><%=base.getCurrency()%></td>
				   </tr>
					<tr>
						<th >发票抬头:</th>
						<td><%=base.getInvoiceTitle()%></td>
					</tr>
					<tr><th>所属财务部:</th><td><%=base.getFinancialDept()%></td></tr>
					
					<tr><th>费用所属月份:</th><td><%=base.getCostMonth()%></td></tr>
					<tr>
						<th>申请事由及说明:</th>
						<td><%=base.getCostExplain()%></td>
					</tr>                  
					<tr class="yellow">
						<td colspan="2" >付款信息</td>
					</tr>
				   <tr>
					  <th>预提金额:</th>
					  <td><%=FormatUtil.formatMoney(base.getApplyAmount())%></td>
				   </tr>
				   <tr>
					  <th>币种:</th>
					  <td><%=base.getCurrency()%></td>
				   </tr>
				    <tr>
					  <th>预提金额大写:</th>
					  <td id='amountCNY'></td>
				   </tr>
				  
					<tr class="yellow">
						<td colspan="2" >明细信息</td>
					</tr>
					<%for(int i = 0; i < mobileLineList.length; i++ ) {%>
					 <tr <%=i==0 ? "" : "class='topLine'" %>>
					  <th>费用承担部门:</th>
					  <td><%= mobileLineList[i].getCostCenterName()%></td>
				   </tr>
					 <tr  >
					  <th>费用类型:</th>
					  <td><%= mobileLineList[i].getScName()%></td>
				   </tr>
				   
				    <tr>
					  <th>预提金额:</th>
					  <td><%=FormatUtil.formatMoney(mobileLineList[i].getActualAmount()) %></td>
				   </tr>
				    <tr>
					  <th>核定金额:</th>
					  <td><%= FormatUtil.formatMoney(mobileLineList[i].getRetifyAmount())%></td>
				   </tr>
				   <tr>
					  <th>费用说明:</th>
					  <td><%= mobileLineList[i].getCostExplain() == null ? "" : mobileLineList[i].getCostExplain()%></td>
				   </tr>
				   <%} %>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<input type="hidden" value="<%=request.getAttribute("activitydefid")%>" id="activitydefid">
</div>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=base.getPayAmount()%>));
	//直接上级、逐级审批至业务部门副总、事业部财务部负责人、总裁/区域财务管理部负责人
// 	var activitydefid = $("#activitydefid").val();
// 	if(activitydefid != 'manualActivity6' && activitydefid != 'manualActivity2' && activitydefid != 'manualActivity8' && activitydefid != 'manualActivity1' && activitydefid != 'manualActivity5'){
// 		$("#approve_area").hide();
// 		$("#div3").hide();
// 	}
});
</script>
</body>
</html>