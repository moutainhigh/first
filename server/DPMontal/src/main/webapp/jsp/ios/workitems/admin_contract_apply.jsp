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
				    OaContractApply apply = (OaContractApply)request.getAttribute("contractApply");
				 %>
				   <li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
				   </li>
				   <li>工作流：<em>行政类合同申请</em></li>
				   <li>申请人姓名：<em><%=apply.getProposer() %></em></li>
				   <li>申请人工号：<em><%=apply.getUserid() %></em></li>
				   <li>经办部门：<em><%=apply.getChargeindepartment() %></em></li>
				   <li>是否框架合同：<em><%=apply.getIsframecontract().toString().equals("0")?"是":"否" %></em></li>
				   <li>所属事业部：<em><%=apply.getSubordinatedepartment()%></em></li>
				   <li>所属财务部：<em><%= apply.getFinancedept()%></em></li>
				   <li>签订类型：<em><%=apply.getSigntype() %></em></li>
				   <li>合同类型：<em><%=apply.getContracttype() %></em></li>
				<%
					if(null != apply.getSigntype() && (apply.getSigntype().equals("续签") || 
							  apply.getSigntype().equals("变更") ||apply.getSigntype().equals("作废"))){
				%>				   
				       <li>原合同编号：<em><%=apply.getOriginalcontractnumbers() %></em></li>
				<%
					}
				%>
				<%
					if(null !=apply.getContracttype() && apply.getContracttype().equals("金融类")){
				%>				       
					   <li>是否主要：<em><%=apply.getIsmain().equals("0")?"是":"否"%></em></li>
				<%
					}
				%>		
				       <li>合同名称：<em><%=apply.getContractname()%></em></li>
				       <li>合同金额：<em><%=apply.getContractamount()%></em></li>
				       <li>签约对方单位：<em><%=apply.getSigningeachotherunit()%></em></li>
				       <li>签约我方单位：<em><%=apply.getSigningourunit()%></em></li>
				       <li>合同开始日期：<em><%=FormatUtil.formatDate(apply.getContractstarttime())%></em></li>
				       <li>合同结束日期：<em><%=FormatUtil.formatDate(apply.getContractendtime())%></em></li>		       
					   <li>申请理由：<em><%=apply.getReason()==null?"":apply.getReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>