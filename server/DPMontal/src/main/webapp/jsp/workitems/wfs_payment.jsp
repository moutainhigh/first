<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.text.Format"%>
<%@page import="com.deppon.montal.model.TWFSexpensehkSub"%>
<%@page import="com.deppon.montal.model.TWFSexpensehk"%>
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

	TWFSexpensehk  expensehk = (TWFSexpensehk)request.getAttribute("expensehk");
	List<TWFSexpensehkSub> expensehkSubList = (List<TWFSexpensehkSub>)request.getAttribute("expensehkSubList");
	
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
				   <td id="workid"><%=expensehk.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>付款申请（香港）</td>
				</tr>
				<tr>
					<th>申请人姓名:</th>
					<td><%=expensehk.getProposer()%></td>
				</tr>
			    <tr>
				   <th>工号:</th>
				   <td><%=expensehk.getUserid()%></td>
				</tr>
				
				<tr>
				   <th>申请人部门:</th>
				   <td><%=expensehk.getApplydept()%></td>
				</tr>
				<tr>
				   <th>所属子公司:</th>
				   <td><%=expensehk.getSubcompany()%></td>
				</tr>
				<tr>
				   <th>收款方:</th>
				   <td><%=expensehk.getPayee()%></td>
				</tr>
				<tr>
				   <th>电话号码:</th>
				   <td><%=expensehk.getPhoneno()==null?"":expensehk.getPhoneno()%></td>
				</tr>
				
				<tr>
				   <th>开户银行:</th>
				   <td><%=expensehk.getBank()%></td>
				</tr>
				<tr>
				   <th>账号:</th>
				   <td><%=expensehk.getBankno()%></td>
				</tr>
				<tr>
				   <th>开户行省份:</th>
				   <td><%=expensehk.getProvince()%></td>
				</tr>
				<tr>
				   <th>开户行城市:</th>
				   <td><%=expensehk.getCity()%></td>
				</tr>
				<tr>
				   <th>开户支行:</th>
				   <td><%=expensehk.getSubbranch()%></td>
				</tr>
				<tr>
				   <th>支付方式:</th>
				   <td><%=expensehk.getPaymentmethod()%></td>
				</tr>
				<tr>
				   <th>账户性质:</th>
				   <td><%=expensehk.getAccounttype()%></td>
				</tr>
				<tr>
				   <th>发票抬头:</th>
				   <td><%=expensehk.getInvoicetitle()%></td>
				</tr>	
				<tr>
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=expensehk.getReason()==null?"":expensehk.getReason() %></td>
			    </tr>
				<tr>
					<th colspan="2" class="yellow">付款详情</th>
				</tr>
				<%
					for(int i=0;i<expensehkSubList.size();i++){
						TWFSexpensehkSub entry = expensehkSubList.get(i);
				%>
				<tr <%=i==0?"":"class='topLine'" %> >
				   <th>费用类型:</th>
				   <td><%=entry.getExpensetype()%></td>
				</tr>
				<tr>
				   <th>费用说明:</th>
				   <td><%=entry.getFeedesc()%></td>
				</tr>
				<tr>
				   <th>发生日期:</th>
				   <td>
				   		<%=FormatUtil.formatDate(entry.getBizdate())%>
				   </td>
				</tr>
				<tr>
				   <th>付款金额:</th>
				   <td><%=entry.getAmount()%></td>
				</tr>
				<tr>
				   <th>核定金额:</th>
				   <td><%=entry.getAmountapproved()%></td>
				</tr>
				<tr>
				   <th>费用承担部门:</th>
				   <td><%=entry.getCostdept()%></td>
				</tr>
				<tr>
				   <th>备注:</th>
				   <td><%=entry.getRemark()==null?"":entry.getRemark()%></td>
				</tr>
				<%
					}
				%>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>