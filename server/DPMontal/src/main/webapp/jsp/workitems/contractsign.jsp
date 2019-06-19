<%@page import="java.math.BigDecimal"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%

	OaContractApply apply = (OaContractApply)request.getAttribute("contractApply");

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
				   <td id="workid"><%=apply.getProcessinstid() %></td>
				</tr>
				<tr>
				   <th >工作流:</th>
				   <td>合同签订申请<input type="hidden" id ="type_id" value="contractSignApply"></td>
				</tr>
			    <tr>
				  <th >申请人姓名:</th>
				  <td><%=apply.getProposer() %></td>
			   </tr>
				 <tr>
				  <th >申请人工号:</th>
				  <td><%=apply.getUserid() %></td>
			   </tr>
			   <tr>
				  <th >经办部门:</th>
				  <td><%=apply.getChargeindepartment() %></td>
			   </tr>
				 <tr>
				  <th >是否框架合同:</th>
					  <%if(apply.getIsframecontract().compareTo(new BigDecimal(0))==0){%>
						  <td>是</td>
					 <% } else if(apply.getIsframecontract().compareTo(new BigDecimal(1))==0){%>
						  <td>否</td>
					 <% }%>
			   </tr>
				 <tr>
				  <th >所属事业部:</th>
				  <td><%=apply.getSubordinatedepartment() %></td>
			   </tr>
				 <tr>
				  <th >所属财务部:</th>
				  <td><%=apply.getFinancedept() %></td>
			   </tr>	
				<tr>
					<th >签订类型:</th>
					<td ><%=apply.getSigntype() %></td>
				</tr>
				<tr>
					<th >合同类型:</th>
					<td><%=apply.getContracttype() %></td>
				</tr>
				<%
					if(null != apply.getSigntype() && (apply.getSigntype().equals("续签") || 
							  apply.getSigntype().equals("变更") ||apply.getSigntype().equals("作废"))){
				%>
				<tr>
					<th >原合同编号:</th>
					<td><%=apply.getOriginalcontractnumbers() %></td>
				</tr>
				<%
					}
				%>
				<%
					if(null !=apply.getContracttype() && apply.getContracttype().equals("采购类")){
				%>
				<tr>
					<th >物品名称:</th>
					<td><%=apply.getItemname() %></td>
				</tr>
				<%
						if(null != apply.getIsframecontract() && apply.getIsframecontract().toString().equals("1")){
				%>
				<tr>
					<th >数量:</th>
					<td><%=apply.getQuantity() %></td>
				</tr>
				<%
					    }
				%>
				<tr>
					<th >单价:</th>
					<td><%=apply.getUnitprice() %></td>
				</tr>
				<%
					}
				%>
				
				<tr>
					<th >合同名称:</th>
					<td><%=apply.getContractname() %></td>
				</tr>
				<tr>
					<th >合同金额:</th>
					<td ><%=apply.getContractamount() %></td>
				</tr>
				<tr>
					<th>签约对方单位:</th>
					<td><%=apply.getSigningeachotherunit() %></td>
				</tr>
				<tr>
					<th>签约我方单位:</th>
					<td><%=apply.getSigningourunit() %></td>
				</tr>

				<tr>
					<th>合同开始日期:</th>
					<td><%=FormatUtil.formatDate(apply.getContractstarttime()) %></td>
				</tr>
				<tr>
					<th>合同结束日期:</th>
					<td><%=FormatUtil.formatDate(apply.getContractendtime()) %></td>
				</tr>
				<tr>
					<th>优先盖章方:</th>
					<%if("1".equals(apply.getSeal())){%>
						<td>我方先盖章/签字</td>
					<%}else{%>
						<td>对方先盖章/签字</td>
					<%} %>
				</tr>
			    <tr>
				  <th >申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=apply.getReason()==null?"":apply.getReason() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>