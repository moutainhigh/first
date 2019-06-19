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
						  外请车-付款单
					   </td>
					</tr>
					<tr>
						<th>发票抬头：</th>
						<td><%=expense.getInvoicetitle() %></td>
					</tr>
					<tr>
						<th>申请人工号：</th>
						<td><%=expense.getApplypersonnumber() %></td>
					</tr>
					<tr>
						<th>申请人姓名：</th>
						<td><%=expense.getApplypersonname() %></td>					
					</tr>
				
					<tr>
						<th>申请人部门：</th>
						<td><%=expense.getApplydept()%></td>
					</tr>
					
					<tr>
						<th>银行：</th>
						<td><%=expense.getFbank() %></td>
					</tr>
					<tr>
						<th>开户行支行：</th>
						<td><%=expense.getFsubbank() %></td>
					</tr>
					<tr>
						<th>开户行账号：</th>
						<td><%=expense.getFaccountnumber() %></td>
					</tr>
					<tr>
						<th>开户行省份：</th>
						<td><%=expense.getFprovince() %></td>
					</tr>
				
					<tr>
						<th>收款方：</th>
						<td><%=expense.getFaccountname() %></td>
					</tr>
					
					<tr>
						<th>押回单到达：</th>					
						<td><%=expense.getFisback() %></td>
					</tr>
					
					<tr>
						<th>代理到达：</th>
						<td><%=expense.getFisagency() %></td>
					</tr>
				
				    <tr>
						<th>开户行城市：</th>
						<td><%=expense.getFcity() %></td>
					</tr>
					
					<tr>
						<th>支付方式：</th>
						<td><%=expense.getFpaytype() %></td>
					</tr>
					
					<tr>
						<th>是否冲借支：</th>
						<td><%=expense.getFisrevpaymentbill() %></td>
					</tr>
					<tr>
						<th>申请日期：</th>
						<td><%=expense.getFapplydate() %></td>
					</tr>
					<tr>
						<th>最迟汇款日期：</th>
						<td><%=expense.getLastremitdate() %></td>
					</tr>
					<tr>
						<th>申请总金额：</th>
						<td><%=expense.getFtotalamount() %></td>
					</tr>
					<tr>
						<th>实付金额：</th>
						<td><%=expense.getFpayamount() %></td>
					</tr>
					<tr>
						<th>冲销金额：</th>
						<td><%=expense.getFrevamount() %></td>
					</tr>
					<tr>
						<th>冲销付款单号：</th>
						<td><%=expense.getFpaymentbillno()==null?"":expense.getFpaymentbillno() %></td>
					</tr>
					
					<tr>
						<th colspan="2" class="yellow">详细信息</th>
					</tr>
					<%
						for(int i=0;i<entryList.size();i++){
							CCFenlumingxiTable entry = entryList.get(i);
					%>					
					<tr class="topLine">
						<th>出发部门:</th>
						<td><%=entry.getFstartdept()%></td>
					</tr>
					<tr>
						<th>到达部门:</th>
						<td><%=entry.getFenddept() %></td>
					</tr>
					<tr>
						<th>付款类型:</th>
						<td><%=entry.getFtype() %></td>
					</tr>
					<tr>	
						<th>车次号:</th>
						<td><%=entry.getFtrucknumber() %></td>
					</tr>
					<tr>
						<th>车牌号:</th>
						<td ><%=entry.getFtruckno() %></td>
					</tr>
					<tr>	
						<th>司机:</th>
						<td><%=entry.getFdriver() %></td>
					</tr>
					<tr>	
						<th>总额:</th>
						<td><%=entry.getFamount()==null?"":entry.getFamount()%></td>
					</tr>
					<tr>	
						<th>出发付金额:</th>
						<td><%=entry.getFstartamount() %></td>
					</tr>
					<tr>	
						<th>到达付金额:</th>
						<td><%=entry.getFendamount() %></td>
					</tr>
					<tr>	
						<th>增减变化:</th>
						<td><%=entry.getFchangeamount() %></td>
					</tr>
					<tr>	
						<th>押回单:</th>
						<td><%=entry.getFisbackpay() %></td>
					</tr>
					<tr>	
						<th>奖励/扣款:</th>
						<td><%=entry.getFchangetype() %></td>
					</tr>
					<%
						}
					%>					
					<%@include file="approve_process.jsp" %>					
				</table>
				<%
			  if("财务副总".equals(expense.getCurrentnode())){
			 %>
			 <table>
			 	<tr>
				 	<th>是否总裁审批:</th>
				 	<td>
					 	<input type="radio" name="need" value="1"><label>需要</label>
					 	<input type="radio" name="need" value="0" checked="checked"><label>不需要</label>
				 	<td>
				 </tr>
			 </table>
		 	<% } %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>