<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OASystempowerApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
	MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  baseEntity =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray(); 
%>
<body>
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
				   <td>
				   		<%=baseEntity.getClaimNo()%>
				   		<input type="hidden" id="workid" value="<%=baseEntity.getWfInstanceId() %>">
				   	</td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>员工借款单-工伤医疗</td>
				</tr>
				
				<tr>
				   <th>申请人:</th>
				   <td><%=baseEntity.getApplyEmpName() %></td>
				</tr>
				<tr>
				   <th>申请日期:</th>
				   <td><%=baseEntity.getApplyDateStr()%></td>
				</tr>
				<tr>
				   <th>申请人部门:</th>
				   <td><%=baseEntity.getApplyDeptName() %></td>
				</tr>
				<tr>
				   <th>申请人公司:</th>
				   <td><%=baseEntity.getApplyCompName() %></td>
				</tr>
			    <tr>
					<th colspan="2" class="yellow">报账信息</th>
				</tr>
			    <tr>
				   <th>发票抬头:</th>
				   <td><%=baseEntity.getInvoiceTitle()%></td>
				</tr>
				<tr>
				   <th>所属财务部:</th>
				   <td><%=baseEntity.getFinancialDept() %></td>
				</tr>	
				<tr>
				   <th>所属事业部:</th>
				   <td><%=baseEntity.getSalaryGroupName() %></td>
				</tr>	
				<tr>
				   <th>币种:</th>
				   <td><%=baseEntity.getCurrency() %></td>
				</tr>
				<tr>
				   <th>收款方:</th>
				   <td><%=baseEntity.getAccountName() %></td>
				</tr>
				<tr>
				   <th>借款金额:</th>
				   <td><%=FormatUtil.formatMoney(baseEntity.getApplyAmount()) %></td>
				</tr>
				<tr>
				   <th>最迟汇款日期:</th>
				   <td><%=baseEntity.getLatestRemitDateStr()==null?"":baseEntity.getLatestRemitDateStr()%></td>
				</tr>
				<tr>
				   <th>手机号码:</th>
				   <td><%=baseEntity.getContactInfo()==null?"":baseEntity.getContactInfo() %></td>
				</tr>				
				<tr>
				   <th>申请事由及说明:</th>
				   <td><%=baseEntity.getCostExplain() %></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">付款信息</th>
				</tr>
				<tr>
				   <th>借款金额:</th>
				   <td><%=FormatUtil.formatMoney(baseEntity.getApplyAmount())  %></td>
				</tr>
				<tr>
				   <th>币种:</th>
				   <td><%=baseEntity.getCurrency() %></td>
				</tr>
				<tr>
				   <th>借款金额大写:</th>
				   <td id="amountCNY"></td>
				</tr>
				
				<tr>
				   <th>账户性质:</th>
				   <td><%=baseEntity.getAccountNature() %></td>
				</tr>
				<tr>
				   <th>银行账号:</th>
				   <td><%=baseEntity.getAccount() %></td>
				</tr>
				<tr>
				   <th>开户支行:</th>
				   <td><%=baseEntity.getSubbankName() %></td>
				</tr>
				<tr>
					<th >支付方式:</th>
					<td><%=baseEntity.getPayType()%></td>
				</tr>
			    <tr>
					<th colspan="2" class="yellow">明细信息</th>
				</tr>
				<%
					for(int i=0; i< lineBaseList.length; i++){	
				
						ClaimLineFssc line = lineBaseList[i];
				%>
				<tr <%=i==0?"":"class='topLine'" %>>
					<th>工伤人员:</th>
					<td><%=line.getInjuryName() %></td>
				</tr>
				<tr>
					<th>工伤人员工号:</th>
					<td><%=line.getInjuryCode() %></td>
				</tr>
				<tr>
					<th>工伤日期:</th>
					<td><%=F_Constants.getDateyyyyMMdd(line.getInjuryDateStr()) %></td>
				</tr>				
				<tr>
					<th>工伤员工公司:</th>
					<td><%=line.getInjuryCompanyname() %></td>
				</tr>
				<tr>
					<th>工伤员工部门:</th>
					<td><%=line.getInjuryDeptname() %></td>
				</tr>	
				<tr>
					<th>工伤差错编号:</th>
					<td><%=line.getInjuryNum() %></td>
				</tr>
							
				<%
					}
				%>				
			    <%@include file="approve_process.jsp"%>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>

</body>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=baseEntity.getPayAmount()%>));
});
</script>
</html>