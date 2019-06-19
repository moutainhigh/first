<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%
OaContractApply info = (OaContractApply)request.getAttribute("projectcontractapply");

%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="projectcontractapply">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
          <li>工作流:<em>项目类合同签订申请<input type="hidden" id ="type_id" value="projectcontractapply"></em></li>
			<li>
					  申请人:<em>
					  <%=info.getProposer()%></em>
				   </li>
					 <li>
					  工号:<em>
					  <%=info.getUserid()%></em>
				   </li>
				   <li>
					  经办部门:<em>
					  <%=info.getChargeindepartment()%></em>
				   </li>
					 <li>
					  是否框架合同:
					  <%if(info.getIsframecontract().compareTo(new BigDecimal(0))==0){%>
						  <em>是</em>
					 <% } else if(info.getIsframecontract().compareTo(new BigDecimal(1))==0){%>
						  <em>否</em>
					 <% }%>
				   </li>
					 <li>
					  所属事业部:<em>
					  <%=info.getSubordinatedepartment()%></em>
				   </li>
				   <li>
					  所属财务部:<em>
					  <%=info.getFinancedept()%></em>
				   </li>
				   	<li>
					  签订类型:<em>
					  <%=info.getSigntype()%></em>
				   </li>
				   <li>
					  合同类型:<em>
					  <%=info.getContracttype()%></em>
				   </li>
				   <%if("续签".equals(info.getSigntype())||"变更".equals(info.getSigntype())||"作废".equals(info.getSigntype())){%>
					   <li>
					  原合同编号:<em>
					  <%=info.getOriginalcontractnumbers()%></em>
				   </li>
				  <% }%>
					 <li>
					  合同名称:<em>
					  <%=info.getContractname()%></em>
				   </li>
					 <li>
					  合同金额:<em>
					  <%=info.getContractamount()%></em>
				   </li>
				   <li>
					  签约对方单位:<em>
					  <%=info.getSigningeachotherunit()%></em>
				   </li>
				   	<li>
					  签约我方单位:<em>
					  <%=info.getSigningourunit()%></em>
				   </li>
					 <li>
					  合同开始日期:<em>
					  <%=FormatUtil.formatDate(info.getContractstarttime())%></em>
				   </li>
				   <li>
					  合同结束日期:<em>
					  <%=FormatUtil.formatDate(info.getContractendtime())%></em>
				   </li>
				   <%if("1".equals(info.getSeal())){%>
					    <li>
					  优先盖章方:<em>
					  我方先盖章/签字</em>
				   </li>
				  <% } else if("2".equals(info.getSeal())){%>
					    <li>
					  优先盖章方:<em>
					  对方先盖章/签字</em>
				   </li>
				   <%}%>
				   <li>
					  申请事由:<em>
					  <%=info.getReason()==null?"":info.getReason()%></em>
				   </li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>