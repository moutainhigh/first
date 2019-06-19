<%@page import="com.deppon.montal.model.CCFenlumingxiTable"%>
<%@page import="com.deppon.montal.model.CCExpenseaccountBill"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
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
	CCExpenseaccountBill expense = (CCExpenseaccountBill)request.getAttribute("bill");
	List<CCFenlumingxiTable> entryList = (List<CCFenlumingxiTable>)request.getAttribute("billEntryList");
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
						  报销单——物资资产采购费用
					   </td>
					</tr>

					<tr>
						<th>申请人姓名：</th>
						<td><%=expense.getApplypersonname() %>
							<input type="hidden" id="type_id" value="entertainmentExpense">
						</td>
					</tr>
				
					<tr>
						<th>申请人部门：</th>
						<td><%=expense.getApplydept()%></td>
					</tr>
					
					<tr>
						<th>所属子公司：</th>
						<td><%=expense.getApplycompany() %></td>
					</tr>
				
					<tr>
						<th>发票抬头：</th>
						<td><%=expense.getInvoicetitle() %></td>
					</tr>
				
					<tr>
						<th>收款方：</th>
						<td><%=expense.getPayee() %></td>
					</tr>
					
					<tr>
						<th>申请总金额：</th>					
						<td><%=expense.getAmount() %></td>
					</tr>
					
					<tr>
						<th>账号：</th>
						<td><%=expense.getBanknumber() %></td>
					</tr>
				
				    <tr>
						<th>会计核定金额：</th>
						<td><%=expense.getAmountapproved() %></td>
					</tr>
					
					<tr>
						<th>开户银行：</th>
						<td><%=expense.getBank() %></td>
					</tr>
					
					<tr>
						<th>最迟汇款日期：</th>
						<td><%=expense.getLastremitdate() %></td>
					</tr>
					<tr>
						<th>事由及说明：</th>
						<td  style="word-wrap:break-word;word-break:break-all"><%=expense.getDiscription()==null?"": expense.getDiscription()%></td>
					</tr>
					<tr>
						<th colspan="2" class="yellow">详细信息</th>
					</tr>
					<%
						for(int i=0;i<entryList.size();i++){
							CCFenlumingxiTable entry = entryList.get(i);
					%>
					<tr class="topLine">
						<th>费用类型:</th>
						<td><%=entry.getExpensetype()%></td>
					</tr>
					<tr>
						<th>费用说明:</th>
						<td><%=entry.getDiscription() %></td>
					</tr>
					<tr>
						<th>发生日期:</th>
						<td><%=entry.getBizdate() %></td>
					</tr>
					<tr>	
						<th>报销金额:</th>
						<td><%=entry.getAmount() %></td>
					</tr>
					<tr>
						<th>核定金额:</th>
						<td ><%=entry.getAmountapproved() %></td>
					</tr>
					<tr>	
						<th>费用承担部门:</th>
						<td><%=entry.getCostdept() %></td>
					</tr>
					<tr>	
						<th>备注:</th>
						<td><%=entry.getRemark()==null?"":entry.getRemark() %></td>
					</tr>
					<%
						}
					%>					
					<%@include file="approve_process.jsp" %>
					<%
					     if("财务副总".equals(expense.getCurrentnode())){ 
					%>
					<tr>
					 	<th>是否总裁审批:</th>
					 	<td>
						 	<input type="radio" name="need" value="1"><label>需要</label>
						 	<input type="radio" name="need" value="0" checked="checked"><label>不需要</label>
					 	<td>
					</tr>
					<% 
					 	 } 
					%>
				</table>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>