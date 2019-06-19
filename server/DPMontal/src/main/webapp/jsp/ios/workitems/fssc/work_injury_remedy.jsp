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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li class="first"><em class="yellow">基本信息</em></li>
				<li>单据编号：<%=baseEntity.getClaimNo() %>
					<em>
				  	  <input type="hidden" id="workid" value="<%=baseEntity.getWfInstanceId() %>">
				    </em>
				</li>
				<li>工作流:<em>员工借款单-工伤医疗</em></li>				
				<li>申请人:<em><%=baseEntity.getApplyEmpName() %></em></li>				
				<li>申请日期:<em><%=baseEntity.getApplyDateStr()%></em></li>
				<li>申请人部门:<em><%=baseEntity.getApplyDeptName() %></em></li>
				<li>申请人公司:<em><%=baseEntity.getApplyCompName() %></em></li>
								
				<li><em class="yellow">报账信息</em></li>  
				<li>发票抬头:<em><%=baseEntity.getInvoiceTitle()%></em></li>
				<li>所属财务部:<em><%=baseEntity.getFinancialDept() %></em></li> 
				<li>所属事业部:<em><%=baseEntity.getSalaryGroupName() %></em></li>
				<li>币种:<em><%=baseEntity.getCurrency() %></em></li>
				<li>收款方:<em><%=baseEntity.getAccountName()%></em></li>
				<li>借款金额:<em><%=FormatUtil.formatMoney(baseEntity.getApplyAmount()) %></em></li>
				<li>最迟汇款日期:<em><%=baseEntity.getLatestRemitDateStr()==null?"":baseEntity.getLatestRemitDateStr() %></em></li>
				<li>手机号码:<em><%=baseEntity.getContactInfo() %></em></li>
				<li>申请事由及说明:<em><%=baseEntity.getCostExplain() %></em></li>				
				
				<li><em class="yellow">付款信息</em></li>
				<li>借款金额:<em><%=FormatUtil.formatMoney(baseEntity.getApplyAmount()) %></em></li>
				<li>币种:<em><%=baseEntity.getCurrency() %></em></li>
				<li>借款金额大写:<em id="amountCNY"></em></li>
				<li>账户性质:<em><%=baseEntity.getAccountNature() %></em></li>
				<li>银行账号:<em><%=baseEntity.getAccount() %></em></li>
				<li>开户支行:<em><%=baseEntity.getSubbankName() %></em></li>
				<li>支付方式:<em><%=baseEntity.getPayType() %></em></li>
				<li><em class="yellow">明细信息</em></li>
				<%
					for(int i=0; i< lineBaseList.length; i++){							
						ClaimLineFssc line = lineBaseList[i];
				%>
				<li <%=i==0?"":"class='line'" %>>工伤人员:<em><%=line.getInjuryName() %></em></li>
				<li>工伤人员工号:<em><%=line.getInjuryCode() %></em></li>
				<li>工伤日期:<em><%=F_Constants.getDateyyyyMMdd(line.getInjuryDateStr()) %></em></li>
				<li>工伤员工公司:<em><%=line.getInjuryCompanyname() %></em></li>
				<li>工伤员工部门:<em><%=line.getInjuryDeptname() %></em></li>
				<li>工伤差错编号:<em><%=line.getInjuryNum() %></em></li>
				<%
					}
				%>				
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
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