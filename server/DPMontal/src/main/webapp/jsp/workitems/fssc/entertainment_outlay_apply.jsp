<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  info =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray(); 
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工作流:</th><td>借支申请单-应酬费</td></tr>
	    		<tr><th>单据编号:</th><td><%=info.getClaimNo() %></td></tr>
				<tr><th>申请人:</th> <td><%=info.getApplyEmpName()%></td> </tr>
				<tr><th>申请日期:</th><td><%=info.getApplyDateStr()== null?"":info.getApplyDateStr()%></td></tr>	
				<tr><th>申请人部门:</th><td><%=info.getApplyDeptName()%></td></tr>
				<tr><th>申请人公司:</th><td><%=info.getApplyCompName()%></td></tr>
				
				<tr><th colspan="2" class="yellow">报账信息</th></tr>
				<tr><th>币种:</th><td><%=info.getCurrency()%></td></tr>
				<tr><th>发票抬头:</th><td><%=info.getInvoiceTitle()%></td></tr>
				<tr><th>支付方式:</th><td><%=info.getPayType()%></td></tr>
				<tr><th>收款方:</th><td><%=info.getAccountName()%></td></tr>
				<tr><th>手机号码:</th><td ><%=info.getContactInfo()==null?"":info.getContactInfo()%></td></tr>
				<tr><th>所属财务部:</th><td><%=info.getFinancialDept()%></td></tr>
				<tr><th>最迟汇款日期:</th><td><%=info.getLatestRemitDateStr()==null?"":info.getLatestRemitDateStr()%></td></tr>
				<tr><th>项目类型:</th><td><%=info.getProjectType()%></td></tr>
				<tr><th>项目名称:</th><td><%=info.getProjectName()%></td></tr>
				<tr><th>申请事由:</th><td><%=info.getCostExplain()%></td></tr>       
				           
				<tr class="yellow"><td colspan="2" >付款信息</td></tr>
				<tr><th>付款金额:</th><td><%=FormatUtil.formatMoney(info.getPayAmount())%></td></tr>
				<tr><th>币种:</th><td><%=info.getCurrency()%></td></tr>
				<tr><th>付款金额大写:</th><td id="amountCNY"></td></tr>
				<tr><th>账户性质:</th><td><%=info.getAccountNature()==null?"":info.getAccountNature()%></td></tr>
				<tr><th>银行账号:</th><td><%=info.getAccount()%></td></tr>
				<tr><th>开户支行:</th><td><%=info.getSubbankName()%></td></tr>
				<tr class="yellow"><td colspan="2" >明细信息</td></tr>
				
				<%
				for(int i=0; i< lineBaseList.length; i++){	
					ClaimLineFssc line = lineBaseList[i];
				 %>
<%-- 				<tr <%=i==0?"":"class='topLine'" %>><th>差错处理编号:</th><td></td></tr> --%>
<!-- 				<tr><th>运单号:</th><td></td></tr> -->
				<tr <%=i==0?"":"class='topLine'" %>><th>费用类型:</th><td><%=line.getScName()%></td></tr>
				<tr><th>费用承担部门:</th><td><%=line.getCostCenterName()%></td></tr>
				<tr><th>业务发生日期:</th><td><%=line.getBizOccurDateStr()==null?"":line.getBizOccurDateStr()%></td></tr>
				<tr><th>付款金额:</th><td><%=FormatUtil.formatMoney(line.getPayAmount())%></td></tr>
				<tr><th>费用说明:</th><td><%=line.getCostExplain()==null?"":line.getCostExplain()%></td></tr>
				<%} %>
		  </table>
		  <%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>


<input type="hidden" id="workid" value="<%=info.getWfInstanceId() %>">

</body>

<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=info.getPayAmount()%>));
});
</script>
</html>