<%@page import="com.deppon.montal.model.TWFSexpensehkSub"%>
<%@page import="com.deppon.montal.model.TWFSexpensehk"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
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
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>				
				<%
					TWFSexpensehk  expensehk = (TWFSexpensehk)request.getAttribute("expensehk");
					List<TWFSexpensehkSub> expensehkSubList = (List<TWFSexpensehkSub>)request.getAttribute("expensehkSubList");
				%>
				
				<li class="first">工作流号：<em><%=expensehk.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=expensehk.getProcessinstid()%>">
				</li>
				<li>工作流：<em>付款申请（香港）</em></li>
				
				<li>申请人姓名：<em><%=expensehk.getProposer()%></em></li>
				<li>工号：<em><%=expensehk.getUserid()%></em></li>
				<li>申请人部门：<em><%=expensehk.getApplydept()%></em></li>
				<li>所属子公司：<em><%=expensehk.getSubcompany()%></em></li>
				<li>收款方:<em><%=expensehk.getPayee()%></em></li>
				<li>电话号码:<em><%=expensehk.getPhoneno()==null?"":expensehk.getPhoneno()%></em></li>
				<li>开户银行：<em><%=expensehk.getBank()%></em></li>
				<li>账号：<em><%=expensehk.getBankno()%></em></li>
				<li>开户行省份：<em><%=expensehk.getProvince()%></em></li>
				<li>开户行城市：<em><%=expensehk.getCity()%></em></li>
				<li>开户支行：<em><%=expensehk.getSubbranch()%></em></li>
				<li>支付方式：<em><%=expensehk.getPaymentmethod()%></em></li>
				<li>账户性质：<em><%=expensehk.getAccounttype()%></em></li>
				<li>发票抬头：<em><%=expensehk.getInvoicetitle()%></em></li>
				<li>申请事由：<em><%=expensehk.getReason()==null?"":expensehk.getReason() %></em></li>
				<li><em class="yellow">付款详情</em>	</li>			
			
				<%
					for(int i=0;i<expensehkSubList.size();i++){
						TWFSexpensehkSub entry = expensehkSubList.get(i);
				%>
				<li <%=i==0?"":"class='line'" %> >费用类型：<em><%=entry.getExpensetype()%></em></li>	
				<li>费用说明：<em><%=entry.getFeedesc()%></em></li>	
				<li>发生日期：<em><%=FormatUtil.formatDate(entry.getBizdate())%></em></li>
				
				<li>付款金额：<em><%=entry.getAmount()%></em></li>
				<li>核定金额：<em><%=entry.getAmountapproved()%></em></li>
				<li>费用承担部门：<em><%=entry.getCostdept()%></em></li>
				<li>备注：<em><%=entry.getRemark()==null?"":entry.getRemark()%></em></li>	
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
</html>