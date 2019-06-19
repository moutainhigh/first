<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OaContractApply info = (OaContractApply)request.getAttribute("projectcontractapply");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>项目类合同签订申请 <input type="hidden" id ="type_id" value="projectcontractapply"></td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getProposer()%></td>
				   </tr>
					 <tr>
					  <th>工号:</th>
					  <td><%=info.getUserid()%></td>
				   </tr>
				   <tr>
					  <th>经办部门:</th>
					  <td><%=info.getChargeindepartment()%></td>
				   </tr>
					 <tr>
					  <th>是否框架合同:</th>
					  <%if(info.getIsframecontract().compareTo(new BigDecimal(0))==0){%>
						  <td>是</td>
					 <% } else if(info.getIsframecontract().compareTo(new BigDecimal(1))==0){%>
						  <td>否</td>
					 <% }%>
				   </tr>
					 <tr>
					  <th>所属事业部:</th>
					  <td><%=info.getSubordinatedepartment()%></td>
				   </tr>
				   <tr>
					  <th>所属财务部:</th>
					  <td><%=info.getFinancedept()%></td>
				   </tr>
				   	<tr>
					  <th>签订类型:</th>
					  <td><%=info.getSigntype()%></td>
				   </tr>
				   <tr>
					  <th>合同类型:</th>
					  <td><%=info.getContracttype()%></td>
				   </tr>
				   <%if("续签".equals(info.getSigntype())||"变更".equals(info.getSigntype())||"作废".equals(info.getSigntype())){%>
					   <tr>
					  <th>原合同编号:</th>
					  <td><%=info.getOriginalcontractnumbers()%></td>
				   </tr>
				  <% }%>
					 <tr>
					  <th>合同名称:</th>
					  <td><%=info.getContractname()%></td>
				   </tr>
					 <tr>
					  <th>合同金额:</th>
					  <td><%=info.getContractamount()%></td>
				   </tr>
				   <tr>
					  <th>签约对方单位:</th>
					  <td><%=info.getSigningeachotherunit()%></td>
				   </tr>
				   	<tr>
					  <th>签约我方单位:</th>
					  <td><%=info.getSigningourunit()%></td>
				   </tr>
					 <tr>
					  <th>合同开始日期:</th>
					  <td><%=FormatUtil.formatDate(info.getContractstarttime())%></td>
				   </tr>
				   <tr>
					  <th>合同结束日期:</th>
					  <td><%=FormatUtil.formatDate(info.getContractendtime())%></td>
				   </tr>
				   <%if("1".equals(info.getSeal())){%>
					    <tr>
					  <th>优先盖章方:</th>
					  <td>我方先盖章/签字</td>
				   </tr>
				  <% } else if("2".equals(info.getSeal())){%>
					    <tr>
					  <th>优先盖章方:</th>
					  <td>对方先盖章/签字</td>
				   </tr>
				   <%}%>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason()==null?"":info.getReason()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>