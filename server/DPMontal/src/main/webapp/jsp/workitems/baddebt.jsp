<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OABaddebtChild"%>
<%@page import="com.deppon.montal.model.OABaddebtApply"%>
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
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<%
						OABaddebtApply apply = (OABaddebtApply)request.getAttribute("badApply");
						List<OABaddebtChild> badChildList = (List<OABaddebtChild>)request.getAttribute("badChildList");
					%>
					<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=apply.getProcessinstid() %></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>
						  非业务类坏账申请
					   </td>
					</tr>
					<tr>
						<th>申请人：</th>
						<td><%=apply.getApplyname() %>
						</td>
					</tr>
					<tr>
						<th>申请部门：</th>
						<td><%=apply.getApplydeptment()%></td>
					</tr>
					<tr>
						<th>申请时间：</th>
						<td><%=FormatUtil.formatDate(apply.getApplydate()) %></td>
					</tr>
					<tr>
						<th>坏账类型：</th>
						<td><%=apply.getBaddebttype() %></td>
					</tr>
					<%
						if(null != apply.getBaddebttype() && apply.getBaddebttype().equals("押金、保证金")){
					%>
					<tr>
						<th>押金编号：</th>
						<td><%=apply.getDepositcode()==null?"":apply.getDepositcode() %></td>
					</tr>
					<tr>
						<th>押金收取方：</th>					
						<td><%=apply.getAcceptdeposit()==null?"":apply.getAcceptdeposit() %></td>
					</tr>
					<tr>
						<th>起始日期：</th>
						<td><%=FormatUtil.formatDate(apply.getBegindate()) %></td>
					</tr>
				    <tr>
						<th>到期日期：</th>
						<td><%=FormatUtil.formatDate(apply.getMaturedate()) %></td>
					</tr>
					<tr>
						<th>押金类型：</th>
						<td><%=apply.getDeposittype() %></td>
					</tr>
					<%
						}
						if(null != apply.getBaddebttype() && apply.getBaddebttype().equals("员工私人借支")){
					%>
					<tr>
						<th>借支编号：</th>
						<td><%=apply.getDebitcode()==null?"":apply.getDebitcode() %></td>
					</tr>
					<tr>
						<th>借支人：</th>
						<td><%=apply.getDebitname()==null?"":apply.getDebitname()%></td>
					</tr>
					<%
						}
						if(null != apply.getBaddebttype() && apply.getBaddebttype().equals("应交营业款")){
					%>
					<tr>
						<th>客户：</th>
						<td><%=apply.getCustomername() %></td>
					</tr>
					<%
						}
					%>
					<tr>
						<th>坏账金额：</th>
						<td><%=FormatUtil.formatMoney(apply.getBaddebtmoney())%></td>
					</tr>
					<tr>
						<th>差错编号：</th>
						<td><%=apply.getMishapcode() %></td>
					</tr>
					<tr>
						<th>产生坏账原因：</th>
						<td  style="word-wrap:break-word;word-break:break-all"><%=apply.getBaddebtreason()==null?"": apply.getBaddebtreason()%></td>
					</tr>
					<%
						if(null != apply.getMishapcode() && !apply.getMishapcode().equals("")){
					%>
					<tr>
						<th colspan="2" class="yellow">差错详细</th>
					</tr>
					<%
							for(int i=0;i<badChildList.size();i++){
								OABaddebtChild entry = badChildList.get(i);
					%>
					<tr class="topLine">
						<th>责任部门:</th>
						<td><%=entry.getResponsibilitydept()==null?"":entry.getResponsibilitydept()%></td>
					</tr>
					<tr>
						<th>入部门费用:</th>
						<td><%=entry.getTodeptaccount() %></td>
					</tr>
					<tr>
						<th>责任人:</th>
						<td><%=entry.getResponsibilityperson()==null?"":entry.getResponsibilityperson() %></td>
					</tr>
					<tr>	
						<th>个人扣款:</th>
						<td><%=entry.getPersonwithhold() %></td>
					</tr>					
					<%
							}
						}
					%>					
				</table>
				<%@include file="approve_process.jsp" %>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>