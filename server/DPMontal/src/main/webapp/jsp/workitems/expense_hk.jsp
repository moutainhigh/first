<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.TWFSexpensehkSub"%>
<%@page import="com.deppon.montal.model.TWFSexpensehk"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
	TWFSexpensehk expense = (TWFSexpensehk)request.getAttribute("expense_hk");
	List<TWFSexpensehkSub> entryList = (List<TWFSexpensehkSub>)request.getAttribute("expense_info");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=expense.getProcessinstid() %></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>
						  费用报销申请(香港)
					   </td>
					</tr>
			<tr><th>申请人姓名:</th><td><%=expense.getProposer() %></td></tr>
		   <tr><th>工号:</th><td><%=expense.getUserid()%></td></tr>
		   <tr><th>申请人部门:</th><td><%=expense.getApplydept() %></td></tr>
		   <tr><th>所属子公司:</th><td><%=expense.getSubcompany() %></td></tr>
		   <tr><th>收款方:</th><td><%=expense.getPayee() %></td></tr>
		   <tr><th>电话号码:</th><td><%=expense.getPhoneno()==null?"":expense.getPhoneno() %></td></tr>
		   <tr><th>开户银行:</th><td><%=expense.getBank() %></td></tr>
		   <tr><th>账号:</th><td><%=expense.getBankno() %></td></tr>
		   <tr><th>开户行省份:</th><td><%=expense.getProvince() %></td></tr>
		   <tr><th>开户行城市:</th><td><%=expense.getCity() %></td></tr>
		   <tr><th>开户支行:</th><td><%=expense.getSubbranch()%></td></tr>
		   <tr><th>支付方式:</th><td><%=expense.getPaymentmethod() %></td></tr>
		   <tr><th>账户性质:</th><td><%=expense.getAccounttype() %></td></tr>
		   <tr><th>发票抬头:</th><td><%=expense.getInvoicetitle() %></td></tr>
		   <tr><th>事由及说明：</th><td><%=expense.getReason()==null?"":expense.getReason() %></td></tr>
		   <tr><th colspan="2" class="yellow">详细信息</tr>
			<%
				for(int i=0;i<entryList.size();i++){
					TWFSexpensehkSub entry = entryList.get(i);
			%>
						   
			   <tr class="topLine"><th>费用类型:</th><td><%=entry.getExpensetype()%></td></tr>
			   <tr><th>费用说明:</th><td><%=entry.getFeedesc() %></td></tr>
			   <tr><th>发生日期:</th><td><%=FormatUtil.formatDate(entry.getBizdate()) %></td></tr>
			   <tr><th>报销金额:</th><td><%=entry.getAmount() %></td></tr>
			   <tr><th>核定金额:</th><td><%=entry.getAmountapproved() %></td></tr>
			   <tr><th>费用承担部门:</th><td><%=entry.getCostdept() %></td></tr>
			   <tr><th>备注:</th><td><%=entry.getRemark()==null?"":entry.getRemark() %></td></tr>
			<%
				}
			%>
							   				
					<%@include file="approve_process.jsp" %>
				</table>
				<table width="100%">
				<%if("审核会计".equals(expense.getCurrentnode())){%>
					 <tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
				<%}%>
				</table>
    	</div>
	</div>
<%-- 	<%if(!"审核会计".equals(expense.getCurrentnode())){%> --%>
	<%@include file="workflow_approve_button.jsp" %>
<%-- 	<%}%> --%>
	<%if("审核会计".equals(expense.getCurrentnode())){%>
		<script type="text/javascript">
		$(function(){
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		});
		</script>
	<%}%>
</div>
</body>
</html>