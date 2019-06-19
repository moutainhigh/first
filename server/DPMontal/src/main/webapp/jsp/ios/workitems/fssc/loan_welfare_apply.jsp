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
	<%@include file="/common_ios.jsp" %>
</head>

<body>
 <%
 MobileFsscEntity entity = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
	ClaimFsscBase  info =  entity.getMobileBaseEntity();
	ClaimLineFssc[] lineBaseList = entity.getMobileLineArray();
	String scName = "";
	for(int i=0; i< lineBaseList.length; i++){	
		ClaimLineFssc line = lineBaseList[i];
		scName = line.getScName();
	}
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
	    		<li class="first"><em class="yellow">基本信息</em></li>
	    		<li>工作流:<em>员工借款单-福利费</em></li>
	    		<li>单据编号:<em><%=info.getClaimNo() %></em></li>
				<li>申请人:<em><%=info.getApplyEmpName()%></em></li>
				<li>申请日期:<em><%=info.getApplyDateStr()== null?"":info.getApplyDateStr()%></em></li>	
				<li>申请人部门:<em><%=info.getApplyDeptName()%></em></li>
				<li>申请人公司:<em><%=info.getApplyCompName()%></em></li>
				
				<li><em class="yellow">报账信息</em></li>
				<li>费用类型:<em><%=scName==null?"":scName%></em></li>
				<li>发票抬头:<em><%=info.getInvoiceTitle()%></em></li>
				<li>所属财务部:<em><%=info.getFinancialDept()%></em></li>
				<li>收款方:<em><%=info.getAccountName()%></em></li>
				<li>币种:<em><%=info.getCurrency()%></em></li>
				<li>借款金额:<em><%=FormatUtil.formatMoney(info.getPayAmount())%></em></li>
				<li>最迟汇款日期:<em><%=info.getLatestRemitDateStr()==null?"":info.getLatestRemitDateStr()%></em></li>
				<li>手机号码:<em ><%=info.getContactInfo()==null?"":info.getContactInfo()%></em></li>
				<li>申请事由:<em><%=info.getCostExplain()%></em></li>       
				           
				<li><em class="yellow">付款信息</em></li>
				<li>借款金额:<em><%=FormatUtil.formatMoney(info.getPayAmount())%></em></li>
				<li>币种:<em><%=info.getCurrency()%></em></li>
				<li>借款金额大写:<em id="amountCNY"></em></li>
				<li>账户性质:<em><%=info.getAccountNature()==null?"":info.getAccountNature()%></em></li>
				<li>开户支行:<em><%=info.getSubbankName()%></em></li>
				<li>银行账号:<em><%=info.getAccount()%></em></li>
				<li>支付方式:<em><%=info.getPayType()%></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp"%>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
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