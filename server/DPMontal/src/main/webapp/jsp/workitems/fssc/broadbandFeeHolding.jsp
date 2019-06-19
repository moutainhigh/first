<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimLineFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ClaimFsscBase"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_win8.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
	MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  baseEntity =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray(); 
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
    <!--div2 S-->
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
	    		<tr>
				   <th>单据编号:</th>
			
				   <td id="workid"><%=baseEntity.getClaimNo() %></td>
				</tr>
				<tr><th>工作流:</th><td>预提报账单-宽带及初装费-预提</td></tr>				
				<tr><th>申请人:</th><td><%=baseEntity.getApplyEmpName() %></td></tr>				
				<tr><th>申请日期:</th><td><%=baseEntity.getApplyDateStr()%></td></tr>
				<tr><th>申请人部门:</th><td><%=baseEntity.getApplyDeptName() %></td></tr>
				<tr><th>申请人公司:</th><td><%=baseEntity.getApplyCompName() %></td></tr>
								
				<tr class="yellow"><th colspan="2">报账信息</th></tr>  
				<tr><th>发票抬头:</th><td><%=baseEntity.getInvoiceTitle()%></td></tr>
				<tr><th>所属财务部:</th><td><%=baseEntity.getFinancialDept() %></td></tr> 
				<tr><th>支付方式:</th><td><%=baseEntity.getPayType()==null?"":baseEntity.getPayType() %></td></tr>
				<tr><th>币种:</th><td><%=baseEntity.getCurrency() %></td></tr>
				<tr><th>费用所属月份:</th><td><%=baseEntity.getCostMonth()==null?"":baseEntity.getCostMonth() %></td></tr>
				<tr><th>申请事由及说明:</th><td><%=baseEntity.getCostExplain()==null?"":baseEntity.getCostExplain() %></td></tr>				
				
				<tr class="yellow"><th colspan="2">付款信息</th></tr>
				<tr><th>预提金额:</th><td><%=FormatUtil.formatMoney(baseEntity.getApplyAmount()) %></td></tr>
				<tr><th>币种:</th><td><%=baseEntity.getCurrency() %></td></tr>
				<tr><th>预提金额大写:</th><td id="amountCNY"></td></tr>
				
				<tr class="yellow"><th colspan="2">明细信息</th></tr>
				<%
					for(int i=0; i< lineBaseList.length; i++){							
						ClaimLineFssc line = lineBaseList[i];
				%>
				<tr <%=i==0?"":"class='topLine'" %>><th>费用承担部门:</th><td><%=line.getCostCenterName() %></td> </tr>
				<tr><th>费用类型:</th><td><%=line.getScName() %></td></tr>
				<tr><th>预提金额:</th><td><%=line.getActualAmount()%></td></tr>
				<tr><th>核定金额:</th><td><%=line.getActualAmount()%></td></tr>
				<tr><th>费用说明:</th><td><%=line.getCostPeriod()==null?"无":line.getCostPeriod() %></td></tr>
				<%
					}
				%>				
		  </table>
		  <%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>

</body>
<script type="text/javascript">
$(function(){
	//将付款金额转成大写
	$("#amountCNY").html(numToCny(<%=baseEntity.getApplyAmount()%>));
});
</script>
</html>